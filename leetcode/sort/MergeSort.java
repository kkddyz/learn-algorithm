package leetcode.sort;

import java.util.Arrays;

/**
 * @author kkddyz
 * @date 2022/4/11
 * @description
 */
public class MergeSort {

    public int[] mergeSort(int[] arr) {

        // 首先考虑最简情况
        if (arr.length == 1) {
            return arr;

        } else if (arr.length == 2) {
            if (arr[0] > arr[1]) {
                swap(arr);
            }
            return arr;

        } else {
            // 考虑一般情况: 递推条件

            int mid = arr.length / 2 - 1;

            // 递归得到有序的左子数组
            int[] leftArr = mergeSort(Arrays.copyOfRange(arr, 0, mid + 1));
            // 递归得到有序的右子数组x
            int[] rightArr = mergeSort(Arrays.copyOfRange(arr, mid + 1, arr.length));

            // 合并
            return mergeSubArr(leftArr, rightArr);
        }
    }

    // 将得到的左右子数组合并，升序排列
    private int[] mergeSubArr(int[] leftArr, int[] rightArr) {
        int[] arr = new int[leftArr.length + rightArr.length];

        int leftIndex = 0;
        int rightIndex = 0;
        int arrIndex = 0;

        while (leftIndex < leftArr.length && rightIndex < rightArr.length) {
            if (leftArr[leftIndex] <= rightArr[rightIndex]) {
                arr[arrIndex++] = leftArr[leftIndex++];
            } else {
                arr[arrIndex++] = rightArr[rightIndex++];
            }
        }

        // leftArr,rightArr其中一方的元素完成拷贝
        if (leftIndex == leftArr.length) {
            // 拷贝剩余的rightArr
            while (rightIndex < rightArr.length) {
                arr[arrIndex++] = rightArr[rightIndex++];
            }
        } else {
            // 拷贝剩余的left
            while (leftIndex < leftArr.length) {
                arr[arrIndex++] = leftArr[leftIndex++];
            }
        }

        return arr;
    }

    private void swap(int[] arr) {
        if (arr.length != 2) {
            throw new UnsupportedOperationException("数组长度不为2");
        }

        int temp = arr[0];
        arr[0] = arr[1];
        arr[1] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 1, 4, 5};
        MergeSort sorter = new MergeSort();
        int[] sortedArr = sorter.mergeSort(arr);
        System.out.println(Arrays.toString(sortedArr));

    }
}
