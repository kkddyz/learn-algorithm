package leetcode.dp;

/**
 * @author kkddyz
 * @date 2021/12/15
 * @description leetcode 413 简单题
 */
public class Test {
    public static int numberOfArithmeticSlices(int[] nums) {

        // 特殊情况
        if (nums.length < 3) {
            return 0;
        }

        // 考虑动态规划

        // 1. 定义状态 res 表示 前一个状态结果
        int res = 0;

        // 2. 状态转移方程 res += numOfNewSequence

        int numOfNewSequence = 0;

        for (int i = 2; i < nums.length; i++) {

            // 当前等差数列的差
            // int diff = nums[i] - nums[i - 1];

            // 计算i新产生的等差数列数量
            for (int j = i - 1; j >= 1; j--) {
                if (nums[j] - nums[j - 1] == nums[i] - nums[i - 1]) {
                    res++;
                } else {
                    break;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        System.out.println(numberOfArithmeticSlices(arr));

    }
}

