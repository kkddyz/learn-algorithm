package leetcode.动态规划;

/**
 * @author kkddyz
 * @date 2021/12/15
 * @description
 */
public class NumDecodings {

    // 问题关键明确状态转移
    // 要么选择 cur作为字符译码，要么将 pre+cur作为字符译码
    public static int numDecodings(String s) {

        // 1. 定义状态 dp[i] 表示[0,i-1]
        int[] dp = new int[s.length()];

        // base side dp[0] = 1
        if (s.charAt(0) == '0') {
            return 0;
        } else {
            dp[0] = 1;
        }


        for (int i = 1; i < s.length(); i++) {

            String cur = s.substring(i, i + 1);
            String pre = s.substring(i - 1, i);

            // if cur == 0

            if ("0".equals(cur)) {
                // pre是1，2，例如 10
                if ("1".equals(pre) || "2".equals(pre)) {
                    dp[i] = dp[i - 1];
                } else {
                    // 出现无法解析的部分 40
                    return 0;
                }

                // 不是0
            } else {
                // pre + cur 合法 26
                if (available(pre + cur)) {
                    dp[i] = dp[i - 1] + 1;
                } else {
                    // 不合法 33
                    dp[i] = dp[i - 1];
                }
            }
        }
        return dp[s.length() - 1];
    }


    /**
     * 判断字符s是否合法
     * 合法返回1，不合法返回0
     */

    public static boolean available(String s) {
        String[] dict = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26"};

        for (int i = 0; i < dict.length; i++) {
            if (dict[i].equals(s)) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        String str = "21101";
        System.out.println(numDecodings(str));

    }
}
