package leetcode.sort;

import java.util.Arrays;

/**
 * @author kkddyz
 * @date 2022/9/22
 * @description 技术排序
 */
public class CntSort {

    public static int[] sort(int[] arr) {

        // 数组中元素种类不好确定
        int[] cnt = new int[4];
        int[] sum = new int[cnt.length];
        int[] sortedArr = new int[arr.length];

        // 1. 统计arr元素个数
        for (int i = 0; i < arr.length; i++) {

            // 1. 读取到arr[i]
            // 2.arr[i]对应的计数数组元素++
            cnt[arr[i]]++;
        }
        // 打印统计数组
        System.out.println("统计数组" + Arrays.toString(cnt));


        // 2. 生成累加数组
        for (int i = 1; i < cnt.length; i++) {
            sum[i] = cnt[i - 1] + cnt[i];
        }
        // 打印累加数组
        System.out.println("累加数组" + Arrays.toString(sum));


        /**
         * 基于lastIndexOf(i) = sum[i] - 1
         * 我们可以确认无序数组中i对应的有序数组位置
         * 填入后，i存入有序数组的位置应前移,因此sum[i]--
         */

        // 3. 遍历arr，填入result
        for (int i = 0; i < arr.length; i++) {

            // 1. 无序数组中的元素e
            int num = arr[i];

            // 2. 计算对应的lastIndexOf(e)
            int lastIndexOfE = sum[num] - 1;

            // 3. 将num填入到有序数组的正确位置
            sortedArr[lastIndexOfE] = num;

            // 3. lastIndexOfE  前移
            sum[num]--;
        }
        return sortedArr;
    }


    public static void main(String[] args) {
        int[] arr = {2, 1, 3, 3, 1, 2};
        int[] result = sort(arr);
        System.out.println(Arrays.toString(result));
    }
}
