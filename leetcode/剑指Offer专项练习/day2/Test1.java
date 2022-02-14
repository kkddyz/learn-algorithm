package leetcode.剑指Offer专项练习.day2;

import java.util.HashMap;
import java.util.Map;

/**
 * @author kkddyz
 * @date 2022/2/4
 * @description
 */
public class Test1 {

    public int singleNumber(int[] nums) {

        if (nums.length == 1) {
            return nums[0];
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            // 如果当前元素nums[i]不存在，记录到map中
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], 1);
            } else { // 如果存在 value++
                int count = map.get(nums[i]);
                // 已经出现2次，移除该元素
                if (count == 2) {
                    map.remove(nums[i]);
                } else {
                    map.put(nums[i], ++count);
                }

            }
        }

        // 虽然此时我们知道只有一个元素，但是对于Map的处理只能通过遍历实现
        // 不要想将Map变成其他什么数据结构

        int res = 0;
        for (Integer integer : map.keySet()) {
            res = integer;
        }
        return res;


    }

    public static void main(String[] args) {
        Test1 test1 = new Test1();
        int[] nums = {30000,500,100,30000,100,30000,100};
        System.out.println(test1.singleNumber(nums));
    }
}
