//package leetcode;
//
//import java.util.List;
//
///**
// * @author kkddyz
// * @date 2021/12/23
// * @description 全排列
// */
//public class Test {
//
//    /**
//     * 初始end=0,标识没有选择任何数字
//     */
//
//    private int[] swap(int[] nums, int i, int j) {
//        int a = nums[i];
//        nums[i] = nums[j];
//        nums[j] = a;
//        return nums;
//    }
//
//    public List<List<Integer>> recurse(int[] nums, int first) {
//        if (first == nums.length) {
//            return nums;
//        } else {
//            for (int i = first; i < nums.length; i++) {
//                recurse(swap(nums, first, i), first + 1);
//            }
//        }
//    }
//
//    public List<List<Integer>> permute(int[] nums) {
//
//        // [0,i]已经排列的元素 nums[i]当前选择的元素 [i+1,len-1]未排列元素
//        for (int i = 0; i < nums.length; i++) {
//
//        }
//
//    }
//}
