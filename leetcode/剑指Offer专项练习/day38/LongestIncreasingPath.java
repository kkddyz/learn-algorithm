package leetcode.剑指Offer专项练习.day38;

/**
 * @author kkddyz
 * @date 2022/3/27
 * @description
 */
public class LongestIncreasingPath {

    private int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private int rows, columns;
    private int[][] matrix;
    private int[][] memo;

    public int longestIncreasingPath(int[][] matrix) {

        // 特判: 数组为空
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        // 初始化成员变量
        this.matrix = matrix;
        rows = matrix.length;
        columns = matrix[0].length;
        memo = new int[rows][columns];

        int ans = 0;
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < columns; ++j) {
                ans = Math.max(ans, dfs(i, j));
            }
        }
        return ans;
    }

    // 返回(i,j)为起点的的最长路径长度
    public int dfs(int i, int j) {
        // 计算memo[i][j]
        if (memo[i][j] == 0) {

            // maxAdjLen = max{memo[i-1][j],memo[i+1][j],memo[i][j+1],memo[i][j-1]}
            int maxAdjLen = 0;

            // 枚举(i,j)的邻点(a,b)
            for (int[] dir : dirs) {
                int a = i + dir[0], b = j + dir[1];
                // 如果(a,b)越界，跳过
                if (a >= 0 && a < rows && b >= 0 && b < columns && matrix[a][b] > matrix[i][j]) {
                    maxAdjLen = Math.max(maxAdjLen, dfs(a, b));
                }
            }
            // 算上当前结点长度
            memo[i][j] = maxAdjLen + 1;
        }

        return memo[i][j];
    }
}

