package leetcode.剑指Offer专项练习.day11;

import java.util.Arrays;
import java.util.List;

/**
 * @author kkddyz
 * @date 2022/2/22
 * @description
 */
public class FindMinDifference {

    public static int findMinDifference(List<String> timePoints) {
        int n = timePoints.size() * 2;
        int[] nums = new int[n];

        // 处理数据 O(n)
        for (int i = 0, idx = 0; i < n / 2; i++, idx += 2) {
            String[] ss = timePoints.get(i).split(":");
            int h = Integer.parseInt(ss[0]), m = Integer.parseInt(ss[1]);
            nums[idx] = h * 60 + m;
            nums[idx + 1] = nums[idx] + 1440;
        }
        // 排序 O(nlogn)
        Arrays.sort(nums);

        // 遍历获取最小差值 O(n)`3
        int ans = nums[1] - nums[0];
        for (int i = 0; i < n - 1; i++) {
            ans = Math.min(ans, nums[i + 1] - nums[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        List<String> timePoints = Arrays.asList("00:01", "23:59", "00:30");
        findMinDifference(timePoints);
    }
}
