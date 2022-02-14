package leetcode.剑指offer.day5;


/**
 * @author kkddyz
 * @date 2021/11/25
 * @description
 */

/**
 * 问题在于 如何确定
 */
public class FindNumberIn2DArray {

    /**
     * 如果存在target返回target下标(mid)
     * 如果不存在，返回target应该在的地方left
     * <p>
     * 需要检查返回值是否与target相等
     */
    public int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        int mid;
        while (left <= right) {
            mid = (left + right) / 2;
            if (arr[mid] == target) {
                return mid;
            }
            if (target < arr[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }

    public boolean findNumberIn2DArray(int[][] matrix, int target) {

        int row = matrix.length;
        if (row == 0) {
            return false;
        }
        int col = matrix[0].length;
        if (col == 0) {
            return false;
        }

        // index的范围[-1,len-1]
        int index = binarySearch(matrix[0], target);

        if (index == -1){
            return false;
        }

        if (matrix[0][index] == target) {
            // 直接找到了
            return true;
        } else {
            // 没直接找到，在targetCol所在列的数组继续查找
            int targetCol = index;

            // 创建列数组
            int[] colArr = new int[row];
            for (int i = 0; i < row; i++) {
                colArr[i] = matrix[i][targetCol];
            }

            // 二分查找
            int targetRow = binarySearch(colArr, target);
            if (targetRow == -1){
                return false;
            }
            if (matrix[targetRow][targetCol] == target) {
                return true;
            } else {
                return false;
            }
        }
    }

    public static void main(String[] args) {
        FindNumberIn2DArray s = new FindNumberIn2DArray();
        int[][] arr = {
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };

        int[][] arr1 = new int[0][0];

        int[][] arr2 = {{-1, 3}};

        int[][] arr3 = {{-5}};

        int[][] arr4 = {
                {1,2,3,4,5},
                {6,7,8,9,10},
                {11,12,13,14,15},
                {16,17,18,19,20},
                {21,22,23,24,25}
        };


        System.out.println(s.findNumberIn2DArray(arr4, 19));
    }
}