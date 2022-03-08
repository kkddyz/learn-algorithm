package leetcode.剑指Offer专项练习.day5;

/**
 * @author kkddyz
 * @date 2022/2/14
 * @description
 */
public class Test6 {


    public static long testForI(String s) {
        long start = 0,end = 0;

        start = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++) {
            for (int j = 0; j < s.length(); j++) {
                char c = s.charAt(j);
            }
        }
        end = System.currentTimeMillis();
        return end - start;
    }

    public static long testForEach(String s) {
        long start = 0,end = 0;

        start = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++) {

            for (char c : s.toCharArray()) {
                char c1 = c;
            }
        }
        end = System.currentTimeMillis();
        return end - start;
    }

    public static void main(String[] args) {

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 2048; i++) {
            sb.append('a');
        }
        String s = sb.toString();
        System.out.println(s.length());
        System.out.println("ForI:" + testForI(s));
        System.out.println("ForEach:" + testForEach(s));
    }
}
