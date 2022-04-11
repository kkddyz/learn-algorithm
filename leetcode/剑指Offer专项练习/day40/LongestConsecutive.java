package leetcode.剑指Offer专项练习.day40;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author kkddyz
 * @date 2022/3/29
 * @description
 */
public class LongestConsecutive {
    // 集合范围 parent[i][0] ~ parent[i][1]
    // K为num值,int[]为num所在集合范围
    private Map<Integer, int[]> map = new HashMap<>();
    // 利用hash在O(1)时间内寻找到可以与当前集合合并的集合

    // 返回集合范围
    private int[] find(int index) {
        return map.get(index);
    }

    private int maxLen = 1;

    // 合并index1,index2所在的集合
    // index1 != index2
    // index1.range[1] + 1 = index2.range[0]
    private void union(int index1, int index2) {
        int[] range1 = find(index1);
        int[] range2 = find(index2);
        // 确保集合不相同
        if (Arrays.equals(range1, range2)) return;

        int[] unionRange = {range1[0], range2[1]};

        // 更新最长序列长度
        maxLen = Math.max(unionRange[1] - unionRange[0] + 1, maxLen);
        // 合并集合
        map.put(index1, unionRange);
        map.put(index2, unionRange);
    }

    public int longestConsecutive(int[] nums) {


        // 过滤重复元素
        // 集合范围初始化为[nums[i],nums[i]]
        for (int i = 0; i < nums.length; i++) {
            int[] range = {nums[i], nums[i]};
            map.put(nums[i], range);
        }

        // 合并集合
        for (int i = 0; i < nums.length; i++) {

            // 通过set寻找相邻数字,合并
            if (map.get(nums[i] - 1) != null) {
                union(nums[i] - 1, nums[i]);
            }

            if (map.get(nums[i] + 1) != null) {
                union(nums[i], nums[i] + 1);
            }

        }

        return maxLen;
    }

    public static void main(String[] args) {
        //int[] nums = {-6, -5, -4, -3, -2, -1, 0, 1, 2, 3, 4, 5, 7, 8, 9};
        int[] nums = {3,4,5};
        LongestConsecutive s = new LongestConsecutive();
        System.out.println(s.longestConsecutive(nums));
    }
}
