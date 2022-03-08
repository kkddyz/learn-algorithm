package leetcode.剑指Offer专项练习.day11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author kkddyz
 * @date 2022/2/19
 * @description 49. 字母异位词分组
 */
public class GroupAnagrams {

    /**
     * 使用排序的思路
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        // return　new ArrayList<>(Collection<? extends E> c);
        // map.values() Returns a Collection view of the values contained in this map.
        return new ArrayList<>(
                Arrays.stream(strs) // 将String[]转为Stream<String>流
                .collect(Collectors.groupingBy(str -> {
                    // 返回 str 排序后的结果。
                    // 按排序后的结果来grouping by，算子类似于 sql 里的 group by。
                    char[] array = str.toCharArray();
                    Arrays.sort(array);
                    return new String(array);
                }))
                .values());
    }
}
