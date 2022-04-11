package leetcode.dp;

/**
 * @author kkddyz
 * @date 2021/12/3
 * @description
 */
public class MaxProfit {
    public static int maxProfit3(int[] prices) {
        // base side 前两次卖出
        int profit1 = 0;
        int profit2 = 0;

        // 第三次卖出
        int profit3 = 0;
        // 如果这次的收益很大，足以弥补之前两次做一次卖出的损失，那么就将前两次合并选择这一次。

        int minPrice = prices[0];
        int maxProfit = 0; // 一次交易
        int curProfit = 0; // 当前


        for (int j = 1; j < prices.length; j++) {
            // 计算一次交易最大值
            if (prices[j] < minPrice) {
                // 更新最低价格
                minPrice = prices[j];
            } else {
                // 更新最大收益
                if (prices[j] - minPrice > maxProfit) {
                    maxProfit = prices[j] - minPrice;
                }
            }

            // 记录交易
            int i= 0;
            if (prices[j] < prices[j - 1]){
                // 在股价下跌前出售
                curProfit += prices[j - 1] - prices[i];
                // 重新买入
                i = j;
            }
        }

        return 0;

    }

    // 多次交易最大值
    public static int maxProfit2(int[] prices) {
        int i = 0;
        int j = 1;
        int maxProfit = 0; // 总收益

        for (; j < prices.length; j++) {
            // 递增序列
            if (prices[j] < prices[j - 1]){
                // 在股价下跌前出售
                maxProfit += prices[j - 1] - prices[i];
                // 重新买入
                i = j;
            }
        }

        // 防止股价一直涨，没有出售
        maxProfit += prices[j - 1] - prices[i];
        return maxProfit;
    }

    //计算一次交易最大收益
    public static int maxProfit1(int[] prices) {
        int minPrice = prices[0];
        int maxProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                // 更新最低价格
                minPrice = prices[i];
            } else {
                // 更新最大收益
                if (prices[i] - minPrice > maxProfit) {
                    maxProfit = prices[i] - minPrice;
                }
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2};
        System.out.println(maxProfit1(arr1));
    }

}
