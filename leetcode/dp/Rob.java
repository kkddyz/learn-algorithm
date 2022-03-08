package leetcode.dp;

/**
 * @author kkddyz
 * @date 2021/12/9
 * @description
 */

public class Rob {
    // 首尾相连 产生的影响是 偷了第一家就不能偷最后一家
    // 解决的一个思路是 两次打劫，一次[0.len-2] 一次[1,len-1]两家不同时出现再打劫队列中


    private static int maxProfit(int[] nums, int start) {
        int len = nums.length - 1;
        int[] dp = new int[len];
        dp[0] = nums[start];
        dp[1] = Math.max(nums[start], nums[start + 1]);
        for (int i = 2; i < len; i++) {
            //打劫第i家
            int profit1 = nums[start + i] + dp[i - 2];
            // 不打劫第i家
            int profit2 = dp[i - 1];
            dp[i] = (profit1 > profit2) ? profit1 : profit2;
        }

        return dp[len - 1];
    }

    public static int rob(int[] nums) {

        int len = nums.length;
        // 特殊情况 len == 1 || len == 2
        if (len == 1) {
            return nums[0];
        } else if (len == 2) {
            return Math.max(nums[0], nums[1]);
        } else if (len == 3) {
            return Math.max(Math.max(nums[0], nums[1]), nums[2]);
        }
        int profit1 = maxProfit(nums, 0);
        int profit2 = maxProfit(nums, 1);
        return Math.max(profit1, profit2);
    }

    public static void main(String[] args) {
        int[] arr ={1,3,1,3,100};
        int profit = rob(arr);
        System.out.println(profit);
    }
}
