package leetcode.动态规划;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kkddyz
 * @date 2021/12/18
 * @description 每一步只能移动到下一行中相邻的结点上。
 * <p>
 * 相邻的结点 在这里指的是下标与上一层结点下标相同或者等于上一层结点下标 + 1 的两个结点。
 * 也就是说，如果正位于当前行的下标 i ，那么下一步可以移动到下一行的下标 i 或 i + 1 。
 */
public class MinFallingPathSum2 {

    public static int minimumTotal(List<List<Integer>> triangle) {

        int n = triangle.size();

        // 记录当前的最小路径
        int[] f = new int[n];
        f[0] = triangle.get(0).get(0);

        for (int i = 1; i < n; ++i) {
            // 最后一个
            f[i] = f[i - 1] + triangle.get(i).get(i);
            for (int j = i - 1; j > 0; --j) {
                f[j] = Math.min(f[j - 1], f[j]) + triangle.get(i).get(j);
            }
            // 第一个
            f[0] += triangle.get(i).get(0);
        }
        int minTotal = f[0];
        for (int i = 1; i < n; ++i) {
            minTotal = Math.min(minTotal, f[i]);
        }
        return minTotal;
    }

    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<>();
        ArrayList<Integer> row0 = new ArrayList<>();
        row0.add(2);

        ArrayList<Integer> row1 = new ArrayList<>();
        row1.add(3);
        row1.add(4);

        ArrayList<Integer> row2 = new ArrayList<>();
        row2.add(6);
        row2.add(5);
        row2.add(7);

        ArrayList<Integer> row3 = new ArrayList<>();
        row3.add(4);
        row3.add(1);
        row3.add(8);
        row3.add(3);

        triangle.add(0, row0);
        triangle.add(1, row1);
        triangle.add(2, row2);
        triangle.add(3, row3);

        System.out.println(minimumTotal(triangle));
    }
}
