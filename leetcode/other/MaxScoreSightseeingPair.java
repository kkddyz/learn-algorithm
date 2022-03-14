package leetcode.other;

/**
 * @author kkddyz
 * @date 2021/12/10
 * @description 题目的考点实际上是对算法的优化，尝试DP没有思路
 * <p>
 * 看了题解后，我就明白这题算是一个智力题，也就是没有固定解法，真只能先暴力，后优化
 * <p>
 * 如果这种题目可以优化，关键肯定在于给出的式子 profit = nums[i] + nums[j] + i - j
 */
public class MaxScoreSightseeingPair {
    public static int maxScoreSightseeingPair(int[] values) {

        int profit = 0;
        for (int i = 0; i < values.length; i++) {
            for (int j = i + 1; j < values.length; j++) {
                if (values[i] + values[j] + i - j > profit) {
                    profit = values[i] + values[j] + i - j;
                }
            }
        }
        return profit;
    }


    public static void main(String[] args) {
        int[] arr = {8,1,5,2,6};
        System.out.println(maxScoreSightseeingPair(arr));
    }
}
