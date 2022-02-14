package leetcode.剑指offer.第四天查找;

/**
 * @author kkddyz
 * @date 2021/11/27
 * @description
 */
public class Test {

    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        int mid;
        while (left <= right) {
            mid = (left + right) / 2;

            if (arr[mid] == target) {
                return target;
            }

            if (target < arr[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        System.out.println("left：" + left);
        System.out.println("right：" + right);
        return -1;
    }

    public static void main(String[] args) {
        int[] arr1 = {1,3,5};
        binarySearch(arr1,0);
        binarySearch(arr1,2);
        binarySearch(arr1,4);
        binarySearch(arr1,6);

    }
}
