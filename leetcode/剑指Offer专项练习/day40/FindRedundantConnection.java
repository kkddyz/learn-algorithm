package leetcode.剑指Offer专项练习.day40;

import java.util.Arrays;

/**
 * @author kkddyz
 * @date 2022/3/28
 * @description
 */
public class FindRedundantConnection {

    // parent[i] 表示i的父节点
    private int[] parent;


    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        parent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < n; i++) {
            int[] edge = edges[i];
            int node1 = edge[0], node2 = edge[1];

            // 如果node1,node2不属于同一个集合
            if (getRoot(node1) != getRoot(node2)) {
                union(node1, node2);
            } else {
                return edge;
            }
        }
        return new int[0];
    }

    /**
     * 合并这两个顶点的连通分量
     * 将node1.root挂到node2.root下。
     */
    public void union(int node1, int node2) {
        // node1所在集合的root
        parent[getRoot(node1)] = getRoot(node2);
    }

    /**
     * 获取node所在联通分量的代表结点，即 parent[node] == node 的结点
     */
    public int getRoot(int node) {

        if (parent[node] != node) {
            // 向上递归
            return getRoot(parent[node]);
        }
        return node;
    }

    public static void main(String[] args) {
        int[][] edges = {{1, 2}, {3, 4}, {3, 2}, {1, 4}, {1, 5}};

        FindRedundantConnection s = new FindRedundantConnection();
        int[] ints = s.findRedundantConnection(edges);
        System.out.println(Arrays.toString(ints));
    }
}
