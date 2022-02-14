package leetcode.剑指Offer专项练习.day3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author kkddyz
 * @date 2022/2/5
 * @description 在数组中寻找满足条件：a+b+c = 0，的三元组数组{ {a1,b1,c1},{a,b2,c2} }
 */
public class Test1 {


    //public List<List<Integer>> threeSum(int[] nums) {
    //
    //
    //    // 定义数据结构
    //    List<List<Integer>> ans = new ArrayList<>();
    //
    //    // 特解
    //    if (nums == null || nums.length <= 2) {
    //        return ans;
    //    }
    //    // 排序数组
    //    Arrays.sort(nums);
    //
    //    // 固定c后通过双指针匹配a,b
    //    for (int cIndex = 0; cIndex < nums.length - 2; cIndex++) {
    //        int c = nums[cIndex];
    //        int target = -c;
    //
    //
    //        if (c > 0) {
    //            // 如果c>0,由于b>a>0，不存在 a+b+c = 0
    //            continue;
    //        } else if (cIndex > 0 && nums[cIndex] == nums[cIndex - 1]) {
    //            // 错误方式: 直接将cIndex定位到最后一个重复c nums[cIndex] == nums[cIndex + 1]
    //            // 因为 可能存在 a == c 使得条件成立，如果直接定位到最后一个c就忽略了这种情况
    //
    //            // 重复情况是指 在重复元素大于3 定义重复元素第一次出现下标为first,最后出现为last
    //            // first < cIndex < last
    //
    //
    //            continue;
    //        } else {
    //
    //            int aIndex = cIndex + 1;
    //            int a = nums[aIndex];
    //            int bIndex = nums.length - 1;
    //            int b = nums[bIndex];
    //
    //
    //            // 通过双指针寻找符合条件的a,b
    //            while (aIndex < bIndex) {
    //
    //                //// 不需要考虑aIndex,bIndex指向的是相同的重复元素,此时将aIndex
    //                //if (nums[aIndex] == nums[bIndex]) {
    //                //    aIndex = bIndex;
    //                //}
    //
    //                // aIndex,bIndex指向不同的
    //
    //                // 过滤重复的a ：过滤后aIndex定位到最后一个重复a
    //                // aIndex < nums.length 防止数组越界
    //                while (aIndex < nums.length - 1 && nums[aIndex] == nums[aIndex + 1]) aIndex++;
    //
    //
    //                // 过滤重复的b ： 过滤后bIndex定位到第一个重复b
    //                while (bIndex > 0 && nums[bIndex] == nums[bIndex - 1]) bIndex--;
    //
    //
    //                if (a + b < target) {
    //                    a = nums[++aIndex];
    //                } else if (a + b > target) {
    //                    b = nums[--bIndex];
    //                } else {
    //                    List<Integer> tuple = new ArrayList<>();
    //                    Collections.addAll(tuple, c, a, b);
    //                    ans.add(tuple);
    //
    //                    // 匹配到一组a,b 注意同时修改aIndex和a
    //                    if (aIndex < nums.length - 1) {
    //                        a = nums[++aIndex];
    //                    }
    //                    if (bIndex > 0) {
    //                        b = nums[--bIndex];
    //                    }
    //
    //                }
    //            }
    //        }
    //    }
    //    return ans;
    //}

    public List<List<Integer>> threeSum(int[] nums) {


        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null || nums.length <= 2) {
            return ans;
        }
        Arrays.sort(nums);

        for (int cIndex = 0; cIndex < nums.length - 2; cIndex++) {


            if (nums[cIndex] > 0) {
                // 如果c>0,由于b>a>0，不存在 a+b+c = 0
                continue;
            } else if (cIndex > 0 && nums[cIndex] == nums[cIndex - 1]) {
                continue;
            } else {

                int aIndex = cIndex + 1;
                int bIndex = nums.length - 1;

                // 通过双指针寻找符合条件的a,b
                while (aIndex <= bIndex) {

                    int target = -nums[cIndex];
                    if (nums[aIndex] + nums[bIndex] < target) {
                        ++aIndex;
                    } else if (nums[aIndex] + nums[bIndex] > target) {
                        --bIndex;
                    } else {
                        List<Integer> tuple = new ArrayList<>();
                        Collections.addAll(tuple, nums[cIndex], nums[aIndex], nums[bIndex]);
                        ans.add(tuple);

                        // 过滤重复的a ：过滤后aIndex定位到最后一个重复a
                        while (aIndex < nums.length - 1 && nums[aIndex] == nums[aIndex + 1]) aIndex++;
                        // 过滤重复的b ： 过滤后bIndex定位到第一个重复b
                        while (bIndex > 0 && nums[bIndex] == nums[bIndex - 1]) bIndex--;

                        // 匹配到一组a,b 注意同时修改aIndex和a
                        if (aIndex < nums.length - 1) {
                            ++aIndex;
                        }
                        if (bIndex > 0) {
                            --bIndex;
                        }
                    }
                }
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        Test1 test1 = new Test1();
        int[] nums = {-4,-2,1,-5,-4,-4,4,-2,0,4,0,-2,3,1,-5,0};
        List<List<Integer>> lists = test1.threeSum(nums);
        for (List<Integer> list : lists) {
            System.out.println(list);
        }
    }
}
