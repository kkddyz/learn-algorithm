package leetcode.剑指Offer专项练习.day10;

/**
 * @author kkddyz
 * @date 2022/2/15
 * @description
 */
public class IsAnagram {
    /**
     * 判断s是否是t的一种computation
     */
    public boolean isAnagram(String s, String t) {

        if (s.length() != t.length()) return false;

        int[] cnt = new int[26];

        // 遍历s c对应的cnt++
        for (int i = 0; i < s.length(); i++) {
            cnt[s.charAt(i) - 'a']++;

        }

        for (int i = 0; i < t.length(); i++) {
            cnt[t.charAt(i) - 'a']--;
            if (cnt[t.charAt(i) - 'a'] < 0) {
                return false;
            }

        }
        return true;
    }



    public static void main(String[] args) {
        String s = "rat";
        String t = "car";

        IsAnagram test = new IsAnagram();
        System.out.println(test.isAnagram(s, t));


    }
}

