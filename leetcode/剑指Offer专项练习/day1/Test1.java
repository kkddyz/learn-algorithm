package leetcode.剑指Offer专项练习.day1;

/**
 * @author kkddyz
 * @date 2022/2/1
 * @description
 */
public class Test1 {

    /**
     * a,b均为正整数 且 a>b
     */
    public static int divide1(int a, int b) {
        int res = 0;
        // 注意使用>>1代替/2
        int c;

        int left = 0;
        int right = a;
        while (left <= right) {
            // 取中间值c
            c = (left + right) / 2;

            // 判断c是否为正确结果
            if (c * b <= a && (c + 1) * b > a) {
                res = c;
            }

            // 调整边界
            if (c * b > a) {// c偏大
                right = c - 1;
            } else {
                left = c + 1;
            }
        }

        // 返回 a/b的结果
        return res;
    }


    // b!=0
    public static int divide(int a, int b) {

        // 除数绝对值大于被除数绝对值
        if (Math.abs(b) > Math.abs(a)) {
            return 0;
        }

        // 判断是否异号 异或后无符号移动31位
        if ((a ^ b) >>> 31 == 1) {
            // 异号加-
            return -divide1(Math.abs(a), Math.abs(b));
        } else {
            return divide1(Math.abs(a), Math.abs(b));
        }
    }

    public static void main(String[] args) {
        //System.out.println(divide(-2147483648, -1));
        int b = 1;
        System.out.println(Integer.toBinaryString(1));
        System.out.println(Integer.toBinaryString(-1));



        //System.out.println(Math.abs(a));
    }

}
