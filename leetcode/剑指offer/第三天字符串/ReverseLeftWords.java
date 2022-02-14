package leetcode.剑指offer.第三天字符串;

/**
 * @author kkddyz
 * @date 2021/11/23
 * @description
 */
public class ReverseLeftWords {
    public String reverseLeftWords(String s, int n) {
        char[] chars = s.toCharArray();
        int len = chars.length;
        char[] newChars = new char[len];


        for (int i = 0; i < len; i++) {
            if (i < n) {
                // [0,n-1] 右移 len-n
                newChars[i + len - n] = chars[i];
            } else {
                // [n,len-1] 左移n
                newChars[i - n] = chars[i];
            }
        }

        // chars.toString(); 返回的是"[C@29774679"因为数组没有实现toString()
        return String.valueOf(newChars);
    }
}