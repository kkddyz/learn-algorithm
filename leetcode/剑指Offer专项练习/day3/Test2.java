package leetcode.剑指Offer专项练习.day3;

/**
 * @author kkddyz
 * @date 2022/2/6
 * @description 和达到target的子数组的最短长度
 */
public class Test2 {
    public int minSubArrayLen(int target, int[] nums) {

        int first = 0;  // 子数组的第一个元素
        int last = 0;   // 子数组的最后一个元素
        int cur = 0;    // 当前子数组的和


        // 循环终止的两个条件 1.正常终止 cur >= target 2. 非正常终止 last == nums.length
        while (last < nums.length && (cur += nums[last]) < target) {
            last++;
        }

        // 检查终止情况
        if (last == nums.length) {
            // 非正常终止, 说明整个数组和都达不到target，不存在符合条件的子数组
            return 0;
        }

        // 抛出多余元素
        while (cur - nums[first] >= target) {
            cur -= nums[first];
            first++;
        }

        int minLen = last - first + 1;
        if (minLen == 1){
            return 1;
        }

        // 每次选择一个元素，然后抛出多余元素
        while (last < nums.length - 1) {
            cur += nums[++last];

            // 如果当前和减去first后依旧大于target
            while (cur - nums[first] >= target) {
                cur -= nums[first];
                first++;
            }

            // 更新minLen
            if ((last - first + 1) < minLen) {
                minLen = last - first + 1;

                // 不会存在更小的minLen
                if (minLen == 1){
                    return 1;
                }
            }
        }


        return minLen;
    }


    public static void main(String[] args) {
        Test2 test2 = new Test2();
        int[] nums = {1, 4, 4};
        int target = 4;
        System.out.println(test2.minSubArrayLen(target, nums));

    }
}
