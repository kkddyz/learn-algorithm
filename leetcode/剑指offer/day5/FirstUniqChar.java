package leetcode.剑指offer.day5;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author kkddyz
 * @date 2021/11/27
 * @description
 */
public class FirstUniqChar {

    public char firstUniqChar(String s) {
        char[] chars = s.toCharArray();

        /*
         * 使用boolean作为值，而不是int记录次数。
         * 当首次加入c到map，置为ture,之后再遇到置为false;
         */
        Map<Character,Boolean> map = new HashMap<>();
        for (int i = 0; i < chars.length; i++){
            // 如果不存在就加入map,如果存在value置为false.
            map.put(chars[i],!map.containsKey(chars[i]));

            /*
            *  if (!map.containsKey(chars[i])){
                map.put(chars[i],true);
                }else {
                map.put(chars[i],false);
            }
            *
            * */
        }

        /*
         *  按顺序遍历chars,在Map中查找该元素时候只出现一次第一个值为true的就是目标
         */

        for (int i = 0; i < chars.length; i++) {
            Boolean isUniqChar = map.get(chars[i]);
            if (isUniqChar){
                return chars[i];
            }
        }
        return ' ';
    }
}
