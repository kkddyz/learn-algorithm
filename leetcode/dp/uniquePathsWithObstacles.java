package leetcode.dp;

/**
 * @author kkddyz
 * @date 2021/12/22
 * @description
 */
public class uniquePathsWithObstacles {
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {

        for (int i = 0; i < obstacleGrid.length; i++) {
            for (int j = 0; j < obstacleGrid[0].length; j++) {
                // 遇到石头
                if (obstacleGrid[i][j] == 1) {
                    obstacleGrid[i][j] = 0;
                    continue;
                }
                // 没遇到石头 考虑边界导致的四种情况
                if (i - 1 < 0 && j - 1 < 0) { // 跳过起点
                    obstacleGrid[i][j] = 1;

                } else if (i - 1 < 0) { // 上边界
                    obstacleGrid[i][j] = obstacleGrid[i][j - 1];
                } else if (j - 1 < 0) { // 左边边界
                    obstacleGrid[i][j] = obstacleGrid[i - 1][j];
                } else {
                    obstacleGrid[i][j] = obstacleGrid[i - 1][j] + obstacleGrid[i][j - 1];
                }
            }
        }
        return obstacleGrid[obstacleGrid.length - 1][obstacleGrid[0].length - 1];
    }

    public static void main(String[] args) {
        int[][] arr = {{0,0,0}, {0,1,0},{0,0,0}};
        System.out.println(uniquePathsWithObstacles(arr));
    }
}
