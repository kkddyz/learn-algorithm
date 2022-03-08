package leetcode.dp;

import java.util.Arrays;

/**
 * @author kkddyz
 * @date 2021/12/2
 * @description
 */
public class MaxSubArray {
    public int maxSubArray(int[] nums) {

        int max = 0;
        int cur = 0; // 当前连续数组的和，初始化为0，表示没有任何元素
        int maxInt = Integer.MIN_VALUE; // 数组里面的最大值
        for (int i = 0; i < nums.length; i++) {
            // 更新数组最大值
            if (nums[i] > maxInt) {
                maxInt = nums[i];
            }
            // 如果当前子序列的值小于0，那么它不可能是使包含它的子序列取得最大值，因此舍弃
            if (nums[i] + cur < 0) {
                cur = 0; // 当前子序列不包含任何元素
            } else {
                // 更新cur
                cur += nums[i];
                // 更新max
                if (cur > max) {
                    max = cur;
                }
            }
        }

        // max==0 说明数组没有正数，cur一直都是0
        return (max == 0) ? maxInt : max;
    }

    public int maxSubarraySumCircular(int[] nums) {

        // 将nums与nums拼接
        int[] newNums = Arrays.copyOf(nums, nums.length * 2);
        System.arraycopy(nums, 0, newNums, nums.length, nums.length);

        return maxSubArray(newNums);
    }


    public static void main(String[] args) {
        int[] nums = {5, -3, 5};
        MaxSubArray s = new MaxSubArray();
        System.out.println(s.maxSubarraySumCircular(nums));
    }
}
