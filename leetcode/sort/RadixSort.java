package leetcode.sort;

import java.util.Arrays;

/**
 * @author kkddyz
 * @date 2022/9/22
 * @description
 */
public class RadixSort {
    // len表示数位
    public static int[] sort(int[] arr, int len) {

        int[] cnt = new int[10];
        int[] sum = new int[cnt.length];
        int[] result = new int[arr.length];

        // 以某一位作为基数进行计数排序  从低位开始(LSD)
        for (int i = 0; i < len; i++) {

            // divison = 1O的i次方
            int divison = (int) Math.pow(10, i);

            // 1. 统计基数频率
            for (int j = 0; j < arr.length; j++) {

                // 1.1计算元素的基数  当 i = 1 获取十位值 , 123/10%10 = 2
                int num = arr[j] / divison % 10;

                // 1.2在对应的count++
                cnt[num]++;
            }

            // 2. 生成累加数组
            for (int j = 1; j < cnt.length; j++) {
                sum[j] = cnt[j] + cnt[j - 1];
            }


            // 3. 根据lastIndexOfNum排序

            for (int j = arr.length - 1; j >= 0; j--) {

                // 3.1 计算元素的基数
                int num = arr[j] / divison % 10;

                // 3.2 通过lastIndexOfNum确定元素位置
                int lastIndexOfNum = sum[num] - 1;
                result[lastIndexOfNum] = arr[j];

                // 3.3 lastIndexOfNum前移
                sum[num]--;
            }


            // 4. result覆盖到arr,使用新基数排序
            System.arraycopy(result, 0, arr, 0, arr.length);
            Arrays.fill(cnt, 0);

        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {123, 1, 11, 21, 22, 31, 111};
        int[] sort = sort(arr, 10);
        System.out.println(Arrays.toString(sort));
    }
}
