package leetcode.剑指Offer专项练习.day36;

/**
 * @author kkddyz
 * @date 2022/3/24
 * @description
 */
public class MaxAreaOfIsland {
    // 标记单元格是否被访问
    private boolean[][] searched;


    private int dfs(int[][] grid, int i, int j) {

        // 1.越界 2. 界内，是0 3. 界内，是1，已经访问
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0 || searched[i][j]) {
            return 0;
        } else {
            // 4. 界内，是1，未访问
            searched[i][j] = true; // 上                下                       左                        右
            return 1 + dfs(grid, i - 1, j) + dfs(grid, i + 1, j) + dfs(grid, i, j - 1) + dfs(grid, i, j + 1);
        }
    }

    public int maxAreaOfIsland(int[][] grid) {

        // 默认为false
        searched = new boolean[grid.length][grid[0].length];

        int maxArea = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                // 跳过搜索过的和0
                if (searched[i][j] || grid[i][j] == 0) {
                    continue;
                }

                // 如果没用使用dfs,计算岛屿面积
                int area = dfs(grid, i, j);
                maxArea = Math.max(area, maxArea);
            }
        }

        return maxArea;
    }

    public static void main(String[] args) {
        int[][] grid =
                {
                        {1, 1, 0, 0, 0},
                        {1, 1, 0, 0, 0},
                        {0, 0, 0, 1, 1},
                        {0, 0, 0, 1, 1}
                };
        MaxAreaOfIsland s = new MaxAreaOfIsland();
        System.out.println(s.maxAreaOfIsland(grid));
    }
}
