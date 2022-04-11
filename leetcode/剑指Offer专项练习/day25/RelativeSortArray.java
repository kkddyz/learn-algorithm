package leetcode.剑指Offer专项练习.day25;

import java.util.*;

/**
 * @author kkddyz
 * @date 2022/3/14
 * @description
 */
public class RelativeSortArray {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {


        // 数组 + 哈希表 实现一个有序 -- 可以直接用 LinkedHashMap

        Map<Integer, Integer> map = new LinkedHashMap<>();

        // arr2中没有出现在arr1的元素
        List<Integer> list = new ArrayList<>();

        // arr2 作为K
        for (int k : arr2) {
            map.put(k, 0);
        }

        // 统计arr1 元素cnt,没有的加入list
        for (int k : arr1) {
            if (map.containsKey(k)) {
                map.put(k, map.get(k) + 1);
            } else {
                list.add(k);
            }
        }

        // 将map中的元素按顺序加入ans

        List<Integer> ans = new ArrayList<>();

        for (Integer k : map.keySet()) {
            int cnt = map.get(k);
            while (cnt-- > 0) {
                ans.add(k);
            }
        }

        list.sort((a, b) -> a - b);
        ans.addAll(list);

        return ans.stream().mapToInt(i -> i).toArray();

    }

    public static void main(String[] args) {
        RelativeSortArray s = new RelativeSortArray();
        int[] arr1 = {2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19};
        int[] arr2 = {2, 1, 4, 3, 9, 6};
        int[] ints = s.relativeSortArray(arr1, arr2);
        System.out.println(Arrays.toString(ints));
    }

}