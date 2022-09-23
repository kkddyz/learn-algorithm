package leetcode.sort;

import java.util.Arrays;

/**
 * @author kkddyz
 * @date 2022/9/22
 * @description
 */
public class BubbleSort {
    public void sort(int[] arr) {
        // 把i位置的元素浮到合适的位置
        for (int i = 0; i < arr.length; i++) {
            // 比较 arr[j] arr[j+1] 所以 j <= arr.length - 2
            for (int j = 0; j < arr.length - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // 往后浮动一位
                    swap(arr, j, j + 1);
                }
            }

            System.out.println(Arrays.toString(arr));
        }
    }

    public static void main(String[] args) {
        int[] nums = {6, 9, 5, 1, 3};
        BubbleSort sort = new BubbleSort();
        sort.sort(nums);
    }

    /**
     * 交换数组元素
     */
    private static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
