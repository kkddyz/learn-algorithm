package leetcode.other;


import java.util.Arrays;


/**
 * @author kkddyz
 * @date 2022/3/10
 * @description 丑数从已有丑数dp[i]*因质数prime[i]
 */
public class NthSuperUglyNumber {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] dp = new int[n + 1];
        dp[1] = 1;

        // dpIndex[i]表示prime[i]使用的丑数下标 dp[dpIndex[i]] 表示因质数primes[i]对应的丑数值
        int[] dpIndex = new int[primes.length];
        Arrays.fill(dpIndex, 1);

        for (int i = 2; i <= n; i++) {
            // 计算dp[i](求minProduct)
            int minProduct = primes[0] * dp[dpIndex[0]];
            for (int j = 1; j < primes.length; j++) {
                if (primes[j] * dp[dpIndex[j]] < minProduct) {
                    minProduct = primes[j] * dp[dpIndex[j]];
                }
            }
            dp[i] = minProduct;

            // 找出 primes[j] * multiple[j] == minProduct (在循环结束前minProduct无法确定)
            for (int j = 0; j < primes.length; j++) {
                if (primes[j] * dp[dpIndex[j]] == minProduct) {
                    dpIndex[j]++;
                }
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int[] primes = {2, 7, 13, 19};

        NthSuperUglyNumber s = new NthSuperUglyNumber();
        System.out.println(s.nthSuperUglyNumber(12, primes));
    }
}
