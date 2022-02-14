package leetcode.剑指Offer专项练习.day4;

import java.util.HashMap;
import java.util.Map;

/**
 * @author kkddyz
 * @date 2022/2/13
 * @description
 */
public class Test2 {

    public int findMaxLength(int[] nums) {

        int pre = 0;
        int maxLength = 0;

        // K为pre,V为pre第一次出现位置(最小索引)
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        // 初始化map
        for (int i = 0; i < nums.length; i++) {

            // 更新pre
            if (nums[i] == 1) {
                pre++;
            } else {
                pre--;
            }

            // 如果pre出现过
            if (map.containsKey(pre)) {

                // 更新maxLen
                int newLen = i - map.get(pre);
                if (newLen > maxLength) {
                    maxLength = newLen;
                }
            } else {
                // 否则将pre加入map
                map.put(pre, i);
            }
        }
        return maxLength;

    }


    public static void main(String[] args) {
        Test2 test = new Test2();
        int[] nums = {0, 1};
        int maxLength = test.findMaxLength(nums);
        System.out.println(maxLength);

    }
}


