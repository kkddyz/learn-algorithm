package leetcode.剑指Offer专项练习.day5;

/**
 * @author kkddyz
 * @date 2022/2/15
 * @description
 */
public class Test7 {


    public boolean validPalindrome(String s, int left, int right) {
        for (; left < right && s.charAt(left) == s.charAt(right); left++, right--) ;

        // left >= right 说明正常结束 是回文字串
        return left >= right;
    }

    public boolean validPalindrome(String s) {

        int left = 0, right = s.length() - 1;

        for (; left < right && s.charAt(left) == s.charAt(right); left++, right--) ;
        // 循环结束后 1. 正常结束(是回文字串) left>=right 2. left,right所指字符不相等

        // 如果是情况1，或者(情况2)满足两个子串都是回文字符

        return (left >= right || validPalindrome(s, left + 1, right) || validPalindrome(s, left, right - 1));

    }
}
