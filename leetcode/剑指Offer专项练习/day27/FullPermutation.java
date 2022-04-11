package leetcode.剑指Offer专项练习.day27;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author kkddyz
 * @date 2022/3/22
 * @description
 */
public class FullPermutation {
    private List<List<Integer>> ans = new ArrayList<>();


    public List<List<Integer>> permute(int[] nums) {
        recurse(nums,0);
        return ans;
    }

    // p表示当前需要枚举可能性的位置，p == len - 1 终止
    public void recurse(int[] nums,int p){
        // 终止条件
        if (p == nums.length - 1){
            List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());
            ans.add(list);
            return;
        }

        // 继续递归
        for (int i = p; i < nums.length; i++){
            swap(nums,i,p);
            recurse(nums,p+1);
            // 回溯
            swap(nums,i,p);
        }
    }


    private void swap(int[] nums,int a,int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
