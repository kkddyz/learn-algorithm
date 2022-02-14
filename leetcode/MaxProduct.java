package leetcode;

/**
 * @author kkddyz
 * @date 2021/12/11
 * @description
 */
public class MaxProduct {
    // 遇到0看作子问题

    public static int maxProduct(int[] nums) {
        return maxProduct(nums, 0);
    }

    public static int maxProduct(int[] nums, int start) {

        if (start == nums.length) {
            return Integer.MIN_VALUE;
        }

        int maxProduct = nums[0];

        // 维持两个乘积为正数子数组，和一个夹在二者之间的负数
        int product1 = 1;
        int product2 = 1;
        int negativeNumberIndex = -1;

        // 定义first
        int firstNegativeNumberIndex = -1;
        int firstPositiveNumber = 1;

        // 从start开始 一直遇不到0
        int next = nums.length;
        for (int i = start; i < nums.length; i++) {
            // 遇到0
            if (nums[i] == 0) {

                maxProduct = Math.max(0, maxProduct);

                next = i + 1;
                break;
                //product1 = 1;
                //product2 = 1;
                //negativeNumber = 0;


            } else if (nums[i] < 0) {
                if (firstNegativeNumberIndex == -1) {
                    firstNegativeNumberIndex = i;
                }
                maxProduct = Math.max(nums[i], maxProduct);

                // 第一次遇到负数
                if (negativeNumberIndex == -1) {
                    negativeNumberIndex = i;


                } else {
                    // 第二次遇到负数

                    // 合并product1,negativeNumber,product2,nums[i]
                    product1 = product1 * nums[negativeNumberIndex] * product2 * nums[i];

                    // 合并后negativeNumber，product2重置
                    product2 = 1;
                    negativeNumberIndex = -1;

                    maxProduct = Math.max(product1, maxProduct);
                }
            } else {
                // 还没有遇到第一个负数
                if (firstNegativeNumberIndex == -1) {
                    firstPositiveNumber *= nums[i];
                }
                // 遇到正数
                if (negativeNumberIndex == -1) {
                    product1 *= nums[i];
                    maxProduct = Math.max(product1, maxProduct);
                } else {
                    product2 *= nums[i];
                    maxProduct = Math.max(product2, maxProduct);
                }
            }
        }


        // 计算另一种可能 存在3个负数
        if (negativeNumberIndex != -1 && firstNegativeNumberIndex != negativeNumberIndex) {
            int a = product1;
            int b = product2;
            int c = firstPositiveNumber;
            int last = nums[negativeNumberIndex];
            int first = nums[firstNegativeNumberIndex];
            int d = (a * last * b) / (c * first);
            maxProduct = Math.max(Math.max(c, d), maxProduct);
        }

        return Math.max(maxProduct, maxProduct(nums, next));
    }

    public static void main(String[] args) {
        int[] arr = {0, 2};
        System.out.println(maxProduct(arr));
    }
}
