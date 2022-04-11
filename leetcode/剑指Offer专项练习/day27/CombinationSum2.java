package leetcode.剑指Offer专项练习.day27;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author kkddyz
 * @date 2022/3/23
 * @description 相当于求sum==target的子集
 */
public class CombinationSum2 {
    List<List<Integer>> ans = new ArrayList<>();

    // value对应Map的K，cnt对应Map的V
    List<Integer> valueList = new ArrayList<>();
    List<Integer> freqList = new ArrayList<>();
    private int target;

    // 递归枚举所有可能
    // list记录p之前的组合，sum是list元素之和
    public void recurse(int p, int[] combination, int sum) {

        // 成功终止 ： 找到一种sum==target的组合，后面所有都不选择
        if (sum == target) {
            List<Integer> list = new ArrayList<>();
            // 根据combination填入value
            for (int i = 0; i < combination.length; i++) {
                int cnt = combination[i];
                int value = valueList.get(i);
                while (cnt > 0) {
                    list.add(value);
                    cnt--;
                }
            }
            ans.add(list);
            return;
        }

        // 失败终止 ： sum超过target,或者选择完依旧达不到sum
        if (p == valueList.size() || sum > target) {
            return;
        }


        // 递归 枚举选择 0 - cntList[p]次 valueList[p]

        int cnt = freqList.get(p);
        for (int i = 0; i <= cnt; i++) {
            // 选择i次
            sum += i * valueList.get(p);
            combination[p] = i;
            recurse(p + 1, combination, sum);

            // 回溯
            sum -= i * valueList.get(p);
            combination[p] = 0;
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        this.target = target;

        // 统计元素频率
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : candidates) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        // 记录到list
        for (Integer integer : map.keySet()) {
            valueList.add(integer);
            freqList.add(map.get(integer));
        }

        // combination 记录每个元素选择的次数
        int[] combination = new int[valueList.size()];
        recurse(0, combination, 0);
        return ans;
    }

    public static void main(String[] args) {
        CombinationSum2 s = new CombinationSum2();
        List<List<Integer>> lists = s.combinationSum2(new int[]{1, 2, 2, 2, 5}, 5);
        System.out.println(lists);
    }
}
