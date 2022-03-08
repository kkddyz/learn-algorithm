package leetcode.剑指Offer专项练习.bucketSort;

import java.util.HashMap;

/**
 * @author kkddyz
 * @date 2022/3/8
 * @description
 */
public class ContainsNearbyAlmostDuplicate {

    // 键 bucketId 值 nums[i]
    private HashMap<Long, Long> map = new HashMap<>();

    private int w;      // 桶宽度
    private int diff;   // 元素差 diff = w - 1


    /**
     * 返回value对应的桶索引
     */
    private long getBucketId(long value) {
        if (value >= 0) {
            return value / w;
        } else {
            return (value + 1) / w - 1;
        }
    }

    /**
     * 检查value对应索引的位置是否已经有元素
     */
    private boolean isValueContainedInBucket(long value) {
        long key = getBucketId(value);
        return map.containsKey(key);
    }

    private boolean isKeyContainedInBucket(long key){
        return map.containsKey(key);
    }

    /**
     * 向桶中插入num
     */
    private long insertIntoBucket(long value) {
        long key = getBucketId(value);
        map.put(key, value);
        return key;
    }

    /**
     * 从桶中移除num
     */
    private void removeFromBucket(long value) {
        map.remove(getBucketId(value));
    }


    /**
     * 保证value对应索引之前没有值
     * 检查value隔壁是否有符合条件(与value差值的绝对值小于diff)的元素
     */
    private boolean hasEligibleAdjElement(long value) {
        long key = getBucketId(value);

        if (isKeyContainedInBucket(key - 1) && Math.abs(map.get(key - 1) - value) <= diff) {
            return true;
        }

        if (isKeyContainedInBucket(key + 1) && Math.abs(map.get(key + 1) - value) <= diff) {
            return true;
        }

        return false;
    }

    // t 值差 k 索引差
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {

        this.diff = t;
        this.w = diff + 1;

        for (int i = 0; i < nums.length; i++) {
            // [0,k] i== k+1 remove(i-k-1)
            if (i > k) {
                // 从桶中移除元素
                removeFromBucket(nums[i - k - 1]);
            }

            // 检查当前桶是否已经存在元素
            boolean valueContainedInBucket = isValueContainedInBucket(nums[i]);

            // 如果桶中没有该元素,插入元素
            if (!valueContainedInBucket) {
                insertIntoBucket(nums[i]);
            }

            // 元素对应的索引已经有元素，或者隔壁有符合条件的元素
            if (valueContainedInBucket || hasEligibleAdjElement(nums[i])){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ContainsNearbyAlmostDuplicate c = new ContainsNearbyAlmostDuplicate();
        int[] arr = {1, 0, 1, 1};
        c.containsNearbyAlmostDuplicate(arr, 1, 2);
    }

}


