package leetcode.剑指Offer专项练习.day4;

import java.util.HashMap;
import java.util.Map;

/**
 * @author kkddyz
 * @date 2022/2/13
 * @description
 */
public class Test1 {

    public static void main(String[] args) {
        int[] nums = {-1,-1,1};
        int k = 0;
        Solution solution = new Solution();
        int i = solution.subarraySum(nums, k);

        System.out.println(i);

    }
}

class Solution {

    public int subarraySum1(int[] nums, int k) {

        int res = 0; // 结果
        int pre = 0; // 前缀和
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1); // 将pre[-1]，记录到map

        // 1. 计算前缀和pre,写入map(K为pre,V为出现次数)
        for (int i = 0; i < nums.length; i++) {
            pre += nums[i];

            // 不存在nums[i]时返回0，value = 1;
            int value = map.getOrDefault(pre, 0) + 1;
            map.put(pre, value);
        }

        // 2. 遍历map，寻找差为K的元素对
        for (Integer a : map.keySet()) {
            // a作为被减数, a-k --> b
            if (map.containsKey(a - k)) {
                res += map.get(a - k);
            }
        }

        if (k == 0) {
            return res - map.size();
        }
        return res;
    }


    public int subarraySum(int[] nums, int k) {
        int count = 0, pre = 0;
        HashMap<Integer, Integer> mp = new HashMap<>();
        mp.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            pre += nums[i];
            if (mp.containsKey(pre - k)) {
                count += mp.get(pre - k);
            }
            mp.put(pre, mp.getOrDefault(pre, 0) + 1);
        }
        return count;
    }

}