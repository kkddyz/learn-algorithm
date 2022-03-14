package leetcode.剑指Offer专项练习.day4;

/**
 * @author kkddyz
 * @date 2022/3/11
 * @description
 */
public class NumMatrix {
    private int[][] prefix;

    // 求和 第一想到 前缀和数组
    public NumMatrix(int[][] matrix) {

        // 累加 每一行到prefix
        prefix = new int[matrix.length + 1][matrix[0].length];

        for (int i = 1; i < prefix.length; i++) {
            // 每一列
            for (int j = 0; j < prefix[0].length; j++) {
                prefix[i][j] = prefix[i - 1][j] + matrix[i - 1][j];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = 0;

        // 对于每一列 计算 row2 - row1的和
        // 由于prefix[i]对应的是matrix[i-1] 因此在计算时要将prefix中的行数加1
        for (int j = col1; j <= col2; j++) {
            sum += prefix[row2 + 1][j] - prefix[row1][j];
        }

        return sum;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {3, 0, 1, 4, 2},
                {5, 6, 3, 2, 1},
                {1, 2, 0, 1, 5},
                {4, 1, 0, 1, 7},
                {1, 0, 3, 0, 5},
        };
        NumMatrix numMatrix = new NumMatrix(matrix);

        System.out.println(numMatrix.sumRegion(1, 2, 2, 4));
    }
}
