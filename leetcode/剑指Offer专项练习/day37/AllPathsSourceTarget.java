package leetcode.剑指Offer专项练习.day37;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kkddyz
 * @date 2022/3/27
 * @description
 */
public class AllPathsSourceTarget {


    private List<List<Integer>> ans;
    private boolean[] visited;
    private int[][] graph;

    private void DFS(List<Integer> path, int cur, int target) {

        // 访问cur
        visited[cur] = true;
        path.add(cur);

        if (cur == target) {
            ans.add(new ArrayList<>(path));
        } else {
            // DFS邻接点
            for (int adjNode : graph[cur]) {
                if (visited[adjNode]) continue;
                DFS(path, adjNode, target);
            }
        }

        // 离开cur
        path.remove(new Integer(cur)); // 注意直接使用cur，会被当作删除对象的索引
        visited[cur] = false;
    }

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {

        ans = new ArrayList<>();
        visited = new boolean[graph.length];
        this.graph = graph;

        DFS(new ArrayList<>(), 0, graph.length - 1);

        return ans;
    }

    public static void main(String[] args) {
        int[][] graph = {{1, 2}, {3}, {3}, {}};
        AllPathsSourceTarget s = new AllPathsSourceTarget();
        System.out.println(s.allPathsSourceTarget(graph));
    }
}
