package leetcode.剑指Offer专项练习.day1;

/**
 * @author kkddyz
 * @date 2022/2/2
 * @description
 */
public class 二进制加法 {
    /**
     * carry表示前一位运算的进位
     */
    public static String addBinary(String a, String b) {
        StringBuffer ans = new StringBuffer();

        int n = Math.max(a.length(), b.length());
        int carry = 0;
        for (int i = 0; i < n; ++i) {
            if (i < a.length()) {
                // a.charAt(a.length() - 1 - i) - '0' -- 从低位开始i位置的值
                carry += a.charAt(a.length() - 1 - i) - '0';
            } else {
                // 补零部分
                carry += 0;
            }
            if (i < b.length()) {
                carry += b.charAt(b.length() - 1 - i) - '0';
            } else {
                carry += 0;
            }
            ans.append((char) (carry % 2 + '0'));
            carry /= 2;
        }

        if (carry > 0) {

            ans.append('1');
        }
        ans.reverse();

        return ans.toString();
    }

    public static void main(String[] args) {
        String a = "101";
        String b = "1011";
        System.out.println(addBinary(a, b));
    }
}
