package leetcode.剑指Offer专项练习.day3;

/**
 * @author kkddyz
 * @date 2022/2/6
 * @description
 */
public class Test3 {


    public int numSubarrayProductLessThanK(int[] nums, int k) {

        // 特解
        if (k <= 1) return 0;
        int product = 1, ans = 0, base = 0, end;

        // 每次让窗口尺寸+1
        for (end = 0; end < nums.length; end++) {

            // 更新窗口状态
            product *= nums[end];

            // 缩小窗口使得满足条件
            while (product >= k) {
                product /= nums[base++];
            }
            ans += end - base + 1;
        }
        return ans;
    }

    //public int numSubarrayProductLessThanK(int[] nums, int k) {
    //
    //    // 特解 注意题目要求乘积小于k 正整数的最小乘积是1，所以k=1，也返回0
    //    if (k <= 1) {
    //        return 0;
    //    }
    //
    //
    //    int base;
    //    int end = 0;        // 滑动窗口范围 [base,end-1]
    //    int count = 0;      // 符合条件的窗口数
    //    int product = 1;    // 窗口的乘积
    //
    //    // base 作为窗口的的开始下标
    //    for (base = 0; base < nums.length; base++) {
    //
    //        // 确定窗口
    //        while (end < nums.length && (product * nums[end]) < k) {
    //            product *= nums[end++];
    //        }
    //
    //        // 循环终止的条件是 product刚好达到k 所以不大于k的窗口区间是[base,end-1]
    //        // end == nums..length 说明窗口范围是[0,nums.length-1]
    //
    //
    //        if (end - base > 0) {
    //            // 修改count
    //            count += (end - base);
    //
    //            // 调整window，移除之前的base
    //            product /= nums[base]; // 移除窗口的第一个元素
    //        } else {
    //            // base == count 窗口范围[base,base-1]，不存在窗口
    //            // 此时 end == base
    //            end++;
    //        }
    //    }
    //    return count;
    //}

    public static void main(String[] args) {

        Test3 test3 = new Test3();
        int[] nums = {10, 5, 2, 6};
        int k = 100;
        System.out.println(test3.numSubarrayProductLessThanK(nums, k));
    }
}
