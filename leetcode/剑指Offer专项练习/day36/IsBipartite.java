package leetcode.剑指Offer专项练习.day36;

/**
 * @author kkddyz
 * @date 2022/3/24
 * @description
 */
public class IsBipartite {

    private boolean ans = true;

    // 0表示没有放入集合,1,-1表示两个不同的集合
    private int[] set;

    private boolean[] visited;

    public boolean isBipartite(int[][] graph) {

        set = new int[graph.length];
        visited = new boolean[graph.length];

        for (int i = 0; i < graph.length; i++) {
            if (!visited[i]) {
                set[i] = 1;
                BFS(graph, i);
            }
        }


        return ans;
    }

    public void BFS(int[][] graph, int v) {
        if (!ans) {
            return;
        }

        visited[v] = true;

        for (int w : graph[v]) {
            // set[v] != 0 && set[w] != 0 有里两种可能
            // 1. 重复边 之前出现(v,w)，这里是(w,v)
            // 2. 验证   之前出现(v,a) (v,b) 这里是(a,b) 需要验证(a,b)是否在同一集合中
            if (set[v] != 0 && set[w] != 0 && set[v] != set[w]) {
                // 发现不存在BiGraph
                ans = false;
                return;
            }
            // 确定w的值，继续BFS
            if (set[w] == 0) {
                set[w] = -set[v];
                BFS(graph, w);
            }
        }
    }

    public static void main(String[] args) {
        IsBipartite s = new IsBipartite();
        int[][] graph = {{1, 2, 3}, {0, 2}, {0, 1, 3}, {0, 2}};
        System.out.println(s.isBipartite(graph));
    }
}
