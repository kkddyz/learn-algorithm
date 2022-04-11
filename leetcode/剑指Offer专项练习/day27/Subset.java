package leetcode.剑指Offer专项练习.day27;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kkddyz
 * @date 2022/3/22
 * @description
 */
public class Subset {
    private List<List<Integer>> ans = new ArrayList<>();


    // 子集可以看作一个0/1问题每一个元素都有两种可能 选择/不选
    public List<List<Integer>> subsets(int[] nums) {
        recurse(nums, 0, new ArrayList());
        return ans;
    }

    // p指向当前需要考虑的对象
    // list是p之前选择
    // 每次做出两个选择，如果在选择后立即记录，需要写两次，如果延迟到下一轮只需要写依次
    public void recurse(int[] nums, int p, List<Integer> list) {

        //递归终止
        if (p == nums.length) {
            // 记录当前的选择
            List<Integer> subSet = new ArrayList<>(list);
            ans.add(subSet);
            return;
        }


        // 在当前基础上，做出两种选择

        // 选择p 当前函数结束后回到上一层，需要撤销对于p的选择
        list.add(nums[p]);
        recurse(nums, p + 1, list);
        list.remove(list.size() - 1);

        // 不选择p
        recurse(nums, p + 1, list);


    }

    public static void main(String[] args) {
        Subset s = new Subset();
        int[] nums = {1, 2, 3};
        s.subsets(nums);
        System.out.println(s.ans);
    }
}
