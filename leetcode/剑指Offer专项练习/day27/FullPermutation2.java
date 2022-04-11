package leetcode.剑指Offer专项练习.day27;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author kkddyz
 * @date 2022/3/23
 * @description
 */
public class FullPermutation2 {
    boolean[] vis;
    private List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {

        // vis 记录当前选择
        List<Integer> perm = new ArrayList<>();
        vis = new boolean[nums.length];
        Arrays.sort(nums);

        backtrack(nums, 0, perm);
        return ans;
    }

    // 选择idx的元素
    public void backtrack(int[] nums, int idx, List<Integer> perm) {

        if (idx == nums.length) {
            ans.add(new ArrayList<>(perm));
            return;
        }


        for (int i = 0; i < nums.length; ++i) {
            // 当前元素已填入直接跳过
            // 当前元素与之前重复且之前元素未被填入

            // nums[i] == nums[i - 1] && !vis[i - 1])
            // 用于移动到下一组
            // 1. 当前这一组存在一个vis[i] == true
            // 2. 当前组没有
            if (vis[i] || (i > 0 && nums[i] == nums[i - 1] && !vis[i - 1])) {
                continue;
            }
            // i是一个未被填入的不重复数
            perm.add(nums[i]);
            vis[i] = true;
            backtrack(nums, idx + 1, perm);
            vis[i] = false;
            perm.remove(idx);
        }
    }


    public static void main(String[] args) {
        FullPermutation2 s = new FullPermutation2();
        int[] nums = {0, 0, 0, 1, 2};
        System.out.println(s.permuteUnique(nums));
    }
}
