package leetcode.剑指offer.第四天查找;

/**
 * @author kkddyz
 * @date 2021/11/25
 * @description
 */
public class FindRepeatNumber {


    public int findRepeatNumber(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            // 1. 索引与其元素匹配 指针后移
            if (i == nums[i]) {
                i++;
            } else {
                // 2. 索引与其元素不匹配
                if (equals(nums, i, nums[i])) {
                    // 当前索引与目标索引的值相同说明元素重复
                    return nums[i];
                } else {
                    // 并且交换的元素不相等
                    // 交换元素到正确位置, 指针不后移 （i是当前不匹配的位置，nums[i]是当前元素应该去的地方）
                    swap(nums, i, nums[i]);
                }
            }

        }
        return -1;
    }

    private void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    private boolean equals(int[] arr, int a, int b) {
        return arr[a] == arr[b];
    }

    public static void main(String[] args) {

        int[] nums = {2, 3, 1, 0, 2, 5, 3};
        FindRepeatNumber s = new FindRepeatNumber();
        int repeatNumber = s.findRepeatNumber(nums);
        System.out.println(repeatNumber);

    }
}
