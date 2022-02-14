//package algorithm_ZJU.graph_algorithm;
//
//import algorithm_ZJU.graph_structure.AdjNode;
//import algorithm_ZJU.graph_structure.LinkedGraph;
//
//import java.util.Stack;
//
///**
// * @ClassName Dijkstra
// * @Description
// * @Date 2020/12/22 9:25
// * 提供solution函数，需要一个初始化过的图,由于需要一些变量保存路径，所以不能声明为static
// * 使用LGraph作为操作对象
// **/
//public class Dijkstra {
//    private LinkedGraph graph;
//    private int[] dist; // 存放源点到所有Vertex的距离
//    private boolean[] collected;
//    private int[] path; // 记录路径
//
//
//    public Dijkstra(LinkedGraph graph) {
//        this.graph = graph;
//        init();
//    }
//
//
//    // 生成路径
//    public void generatePath(int start) {
//        init();
//        // 初始化
//        dist[start] = 0;
//        collected[start] = true;
//
//        // 从图中获取start的邻接点 (不好封装接口 所以直接去操作)
//        AdjNode adjNode = graph.adjList[start].first;
//        while (adjNode != null) {
//            // 修改dist 需要记录路径
//            dist[adjNode.index] = adjNode.weight; // 赋权
//            path[adjNode.index] = start; // 将from设为源点
//            adjNode = adjNode.next;
//        }
//
//        //
//
//        // 贪心遍历
//        for (int i = 0; i < graph.vertexNum - 1; i++) {
//            int v = min();// 从dist中选出最小值的下标
//            collected[v] = true;// 收录v
//
//            // relaxation
//            AdjNode w = graph.adjList[v].first;// 获取v的每一个邻接点W
//            while (w != null) {
//                // 这里v只是一个int，但是w是AdjNode
//                if (collected[w.index] == false && dist[v] + w.weight < dist[w.index]) {
//                    dist[w.index] = dist[v] + w.weight;// 如果 dist[v] + cost<v,w> < dist[w] 更新dist[w]
//                    path[w.index] = v; //记录路径
//                }
//                w = w.next;
//            }
//        }
//    }
//
//    // path[]中的-1表示无法到达 from-1这个不存在的
//    // 获取
//    public String getPath(int from, int to) {
//        // 不同的 from 生成的
//        generatePath(from);
//        // 读取距离
//        int distance = dist[to];
//        // 路径 从 to 开始回溯 path[to] -> p1
//        Stack<Integer> stack = new Stack<>();
//        int temp = to;
//        stack.push(to);
//        while (temp != from) {
//            // 如果temp不是from，就把temp的前驱压入
//            stack.push(path[temp]);
//            temp = path[temp];
//        }
//        // temp == from 已经把from压入
//
//        //输出stack
//
//        String prefix = "shortest path " + "from " + from + " to " + to + ": {";
//        StringBuilder sb = new StringBuilder(prefix);
//        while (!stack.isEmpty()) {
//            // 读取顶点信息
//            sb.append(graph.adjList[stack.pop()].data);
//            sb.append(",");
//        }
//        sb.append("}");
//        sb.append(" total: ").append(distance);
//
//        return sb.toString();
//    }
//
//    // 获取未收录顶点最小值下标
//    // 该下标未收录
//    private int min() {
//        int min = Integer.MAX_VALUE;
//        int index = 0;
//        for (int i = 0; i < dist.length; i++) {
//            if (!collected[i] && dist[i]<min){
//                min = dist[i];
//                index = i;
//            }
//        }
//
//        return index;
//    }
//
//    // 抹除数据
//    private void init() {
//        final int INFINITY = Integer.MAX_VALUE;
//        // 初始化
//        dist = new int[graph.vertexNum];
//        collected = new boolean[graph.vertexNum];
//        path = new int[graph.vertexNum];
//        for (int i = 0; i < graph.vertexNum; i++) {
//            dist[i] = INFINITY;
//            collected[i] = false;
//            path[i] = -1;// -1表示没有from 这个点就是source
//        }
//    }
//
//    public static void main(String[] args) {
//        System.out.println("你好");
//        LGraph graph = LGraph.buildGraph();
//        Dijkstra dijkstra = new Dijkstra(graph);
//        System.out.println(dijkstra.getPath(0, 5));
//
//    }
//}
