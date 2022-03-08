package leetcode.dp;

/**
 * @author kkddyz
 * @date 2021/12/3
 * @description
 */
public class MinCostClimbingStairs {

    public static int minCostClimbingStairs(int[] cost) {
        int len = cost.length;

        int[] dp = new int[cost.length];
        for (int i = 2; i < len; i++) {
            int temp1 = cost[i - 2] + dp[i - 2];
            int temp2 = cost[i - 1] + dp[i - 1];
            dp[i] = Math.min(temp1, temp2);
        }

        return Math.min(dp[len - 1] + cost[len - 1], dp[len - 2] + cost[len - 2]);
    }

    public static void main(String[] args) {
        int[] arr = {1, 100, 1, 100, 1};
        int i = minCostClimbingStairs(arr);
        System.out.println(i);
    }
}
