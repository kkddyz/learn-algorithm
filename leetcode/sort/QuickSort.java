package leetcode.sort;

import java.util.Arrays;

/**
 * @author kkddyz
 * @date 2022/3/22
 * @description
 */
public class QuickSort {

    ///**
    // * 快速排序
    // *
    // * @param arr   输入数组
    // * @param left  划分左边界
    // * @param right 划分右边界
    // */
    //private static void sort(int[] arr, int left, int right) {
    //    // 递归返回条件，和分区排序结束
    //    if (right - left <= 0) {
    //        return;
    //    }
    //    // 选择数组右边界值作为分区节点(轴)
    //    int pivot = arr[right];
    //    System.out.println("当前的数组" + Arrays.toString(Arrays.copyOfRange(arr, left, right + 1)));
    //    System.out.println("选的轴是" + pivot);
    //    // 从数组左边界开始维护分区
    //    int partition = left - 1;
    //    // 遍历当前分区内元素
    //    for (int i = left; i <= right - 1; i++) {
    //        if ((arr[i] < pivot)) {
    //            // 扩展小数分区，将小数交换到分区末尾
    //            System.out.println("当前遍历到数:" + arr[i] + ",小于pivot");
    //            swap(arr, ++partition, i);
    //            System.out.println("交换" + arr[partition] + "和" + arr[i]);
    //            System.out.println("交换后的数组" + Arrays.toString(arr));
    //        }
    //    }
    //    // 将pivot插到小数分区之后
    //    swap(arr, partition + 1, right);
    //    // 此时轴在partition+1,DQ的部分是(left,partition)
    //    sort(arr, left, partition);
    //    sort(arr, partition + 2, right);
    //}

    /**
     * 快速排序
     *
     * @param arr   输入数组
     * @param left  划分左边界
     * @param right 划分右边界
     */
    private static void quickSort(int[] arr, int left, int right) {
        // 递归返回条件，和分区排序结束
        if (right - left <= 0) { // left == right 当前分区只有一个元素，显然不需要继续递归
            return;
        }
        // 选择数组右边界值作为分区节点(轴)
        int pivot = arr[right];
        // 初始小数分区：[left,partiton] --> [left,left-1]
        int partition = left - 1;
        // 遍历当前分区内元素
        for (int i = left; i <= right - 1; i++) {
            if ((arr[i] < pivot)) {
                // 将小于pivot的元素交换到partition+1位置，使小数分区向后扩展一位
                swap(arr, i, ++partition);
            }
        }

        // 将pivot与partition+1(小数分区后面一个元素)交换，
        swap(arr, partition + 1, right);
        // 此时pivot处于数组的正确位置,partition + 1 = pivot.index

        // 递归处理左右子分区
        quickSort(arr, left, partition);
        quickSort(arr, partition + 2, right);
    }


    public static void sort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    public static void main(String[] args) {
        int[] arr = {4, 1, 2, 5, 3};
        QuickSort.sort(arr);
        System.out.println(Arrays.toString(arr));
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
