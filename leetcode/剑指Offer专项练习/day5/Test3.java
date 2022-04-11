package leetcode.剑指Offer专项练习.day5;

import java.util.HashMap;
import java.util.Map;

/**
 * @author kkddyz
 * @date 2022/2/14
 * @description
 */
public class Test3 {

    public int lengthOfLongestSubstring(String s) {
        // 特解 : 空字符串
        if (("").equals(s)) return 0;

        // 双指针 定义 left = right = 0;
        int left = 0, right = 0, maxLen = 0;

        // 使用Map K为字符 V为字符last位置
        Map<Character, Integer> map = new HashMap<>();

        for (; right < s.length(); right++) {
            // 每次加入一个新字符
            char c = s.charAt(right);

            // 如果出现重复，收缩left，将[left,map.get(c)]部分元素从map移除
            if (map.containsKey(c)) {
                int i = left;
                left = map.get(c) + 1;
                for (; i < left; i++) {
                    map.remove(s.charAt(i));
                }
            }
            // 更新c出现的位置
            map.put(c, right);
            // 更新maxLen
            maxLen = (right - left + 1 > maxLen) ? right - left + 1 : maxLen;
        }
        return maxLen;
    }

    public static void main(String[] args) {

        Test3 test = new Test3();
        String s = "abcabcbb";
        int i = test.lengthOfLongestSubstring(s);
        System.out.println(i);
    }

}
