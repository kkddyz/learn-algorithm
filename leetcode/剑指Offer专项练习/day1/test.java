package leetcode.剑指Offer专项练习.day1;

/**
 * @author kkddyz
 * @date 2022/2/2
 * @description
 */
public class test {
    public int[] countBits(int n) {

        // 初始化dp数组
        int[] dp = new int[n];
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i < n; i++) {
           dp[i] = dp[i/2] + 1;
        }

        return null;

    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            StringBuilder sb = new StringBuilder();
            String binStr = Integer.toBinaryString(i);
            int count = 0;
            for (int j = 0; j < binStr.length(); j++) {
                if (binStr.charAt(j) == '1') {
                    count++;
                }
            }

            sb.append(i).append(" : ").append(binStr).append(" : ").append(count);

            System.out.println(sb);
        }
    }
}
