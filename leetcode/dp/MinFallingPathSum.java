package leetcode.dp;

/**
 * @author kkddyz
 * @date 2021/12/15
 * @description 题目链接 https://leetcode-cn.com/problems/minimum-falling-path-sum/
 */
public class MinFallingPathSum {

    public static int minFallingPathSum(int[][] matrix) {


        int n = matrix[0].length;

        // 递推第i行的dp数组
        for (int i = 1; i < n; i++) {
            // dp[j] 到达第i行,j列的最小cost
            for (int j = 0; j < n; j++) {
                // dp[i][j] 从 dp[i-1][j-1] dp[i-1][j] dp[i-1][j+1] 选择 转移状态

                // 左边界
                int min;
                if (j == 0) {
                    min = (matrix[i - 1][j] > matrix[i - 1][j + 1]) ? matrix[i - 1][j + 1] : matrix[i - 1][j];
                    matrix[i][j] += min;
                    //右边界
                } else if (j == n - 1) {
                    min = (matrix[i - 1][j] > matrix[i - 1][j - 1]) ? matrix[i - 1][j + 1] : matrix[i - 1][j];
                    matrix[i][j] += min;
                } else {
                    min = (matrix[i - 1][j] > matrix[i - 1][j + 1]) ? matrix[i - 1][j + 1] : matrix[i - 1][j];
                    min = (matrix[i - 1][j] > min) ? min : matrix[i - 1][j];
                    matrix[i][j] += min;
                }
            }
        }

        // 返回 dp[n-1]的最小值
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (matrix[n - 1][i] < res) {
                res = matrix[n - 1][i];
            }
        }

        return res;

    }


    public static void main(String[] args) {

        int[][] matrix = {{82, 81}, {69, 33}};
        System.out.println(minFallingPathSum(matrix));


    }
}
