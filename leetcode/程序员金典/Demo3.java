package leetcode.程序员金典;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author kkddyz
 * @date 2022/4/13
 * @description N皇后问题
 */

// stack记录调用栈
public class Demo3 {


    // 每行只有一个，因此可以简化成数组,cur指向最后一个queue

    // cur == -1 相当于栈空 cur == n-1 相当于栈满
    private int[] queens;
    private int cur;
    private boolean[][] visited;
    private int n;

    public List<List<String>> solveNQueens(int n) {

        this.n = n;
        visited = new boolean[n][n];
        queens = new int[n];
        Arrays.fill(queens, -1);

        List<List<String>> ans = new ArrayList<>();

        while (cur > -1) {
            // 获取第cur+1行可以插入的位置
            int idx = getIndex(cur + 1);

            // 如果没有，则返回上一行(回溯)
            if (idx == -1) {
                // 移除queens[cur]的值，cur--;
                queens[cur--] = -1;
            } else {
                // 如果有就插入，同时将visited置为true
                queens[cur + 1] = idx;
                visited[cur + 1][idx] = true;

                // 插入后,如果cur + 1,记录方案
                if (cur + 1 == n) {
                    ans.add(getAns());
                }
            }
        }

        return ans;
    }

    /**
     * 计算第i行可以插入的位置
     */
    private int getIndex(int i) {
        if (i >= n) {
            return -1;
        }
        return 0;
    }

    /**
     * 将queens数组转换成答案
     */
    private List<String> getAns() {
        List<String> list = new ArrayList<>();
        // 每一行转换成一个String
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            int index = queens[i];
            for (int j = 0; j < n; j++) {
                if (j == index) {
                    sb.append("Q");
                } else {
                    sb.append(".");
                }
            }
            list.add(sb.toString());
        }
        return list;
    }
}
