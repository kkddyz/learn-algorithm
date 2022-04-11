package leetcode.剑指Offer专项练习.day38;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kkddyz
 * @date 2022/3/28
 * @description
 */
public class FindOrder {

    // 存储有向图 (edges是邻接表)
    private List<List<Integer>> edges;

    // 标记每个节点的状态：0=未搜索，1=搜索中，2=已完成
    private int[] visited;

    // 用数组来模拟栈，下标 n-1 为栈底，0 为栈顶()
    int[] result;
    // 栈下标 从n-1开始
    int index;

    // valid = ture 图中还没有环
    boolean valid = true;

    public int[] findOrder(int numCourses, int[][] prerequisites) {

        edges = new ArrayList<>();
        visited = new int[numCourses];
        result = new int[numCourses];
        index = result.length - 1;

        // 初始化邻接表
        for (int i = 0; i < numCourses; i++) {
            edges.add(new ArrayList<>());
        }

        // 向edges中添加边
        for (int i = 0; i < prerequisites.length; i++) {
            int from = prerequisites[i][1];
            int to = prerequisites[i][0];
            edges.get(from).add(to);
        }

        // 每次挑选一个「未搜索」的节点，开始进行深度优先搜索
        for (int i = 0; i < numCourses && valid; i++) {
            if (visited[i] == 0) {
                dfs(i);
            }
        }

        // dfs结束后,如果存在环，说明没有拓扑排序,返回空数组
        if (!valid) {
            return new int[0];
        } else {
            return result;
        }
    }

    private void dfs(int u) {
        // 将结点标记为搜索中
        visited[u] = 1;

        // 搜索邻接点
        for (int v : edges.get(u)) {
            // 如果v「未搜索」，DFS
            if (visited[v] == 0) {
                dfs(v);
                // 搜索v可能会发现环,如果有环，直接停止
                if (!valid) return;
            }
            // 如果v「搜索中」,发现环停止
            else if (visited[v] == 1) {
                valid = false;
                return;
            }
            // if (visited[i] == 2) continue;
        }

        // u的邻接点v都搜索完

        // 标记为已完成
        visited[u] = 2;
        // 结点入栈
        result[index--] = u;
    }
}

class Solution {

    // 省份是一个连通图,城市则是结点
    // isConnected是一个邻接矩阵
    // 返回矩阵中 省份 的数量 -> 返回连通图数量

    private boolean[] visited;
    private int[][] edges;
    private int n; // 结点数

    public int findCircleNum(int[][] isConnected) {

        n = isConnected.length;
        visited = new boolean[n];
        edges = isConnected;
        int count = 0;

        // 遍历每一个结点
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i);
                count++;
            }
        }

        return count;

    }

    // dfs结点v
    private void dfs(int u) {
        visited[u] = true;

        // 访问邻接点
        for (int v = 0; v < n; v++) {
            // 确保1.存在边 2. 不是自环 3. 未访问
            if (edges[u][v] == 1 && u != v && !visited[v]) {
                dfs(v);
            }
        }
    }
}
