package leetcode.剑指Offer专项练习.day11;

import java.util.HashMap;
import java.util.Map;

/**
 * @author kkddyz
 * @date 2022/2/22
 * @description
 */
public class IsAlienSorted {
    /**
     *  确保字典words按照字母表顺序排列
     */
    public static boolean isAlienSorted(String[] words, String order) {

        // 1. 如何快速判断两个字母的顺序，哈希表
        Map<Character, Integer> alphabet = new HashMap<>();
        for (int i = 0; i < order.length(); i++) {
            alphabet.put(order.charAt(i), i);
        }

        // 2. 比较相邻两个word
        for (int i = 0; i < words.length - 1; i++) {
            // 相邻字符不符合字母表顺序
            if (!adjStringValid(words, i, alphabet)) {
                return false;
            }
        }

        return true;
    }

    /**
     * 比较words[i] words[i+1]是否符合字典顺序
     */
    private static boolean adjStringValid(String[] words, int i, Map<Character, Integer> alphabet) {
        String pre = words[i];
        String next = words[i + 1];

        for (int j = 0; j < Math.min(pre.length(), next.length()); j++) {
            if (pre.charAt(j) != next.charAt(j)) {
                return (alphabet.get(pre.charAt(j)) < alphabet.get(next.charAt(j)));
            }
        }
        // 前缀相同 ，就会进行到这一行
        return pre.length() <= next.length();
    }

    public static void main(String[] args) {
        String[] words = {"kuvp", "q"};
        System.out.println(isAlienSorted(words, "ngxlkthsjuoqcpavbfdermiywz"));

    }
}
