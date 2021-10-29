package algorithm_ZJU.graph;

import java.io.File;

/**
 * @author kkddyz
 * @date 2021/10/29
 * @description 使用二维数组(权重表)实现图
 */
public class MapGraph extends Graph {
    /**
     * 使用数组存储顶点信息
     */
    String[] vertexInfos;

    /**
     * 使用二维数组存储边信息
     */
    int[][] weights;

    /**
     * 通过文件创建对象,传入自己的空参构造的graph
     */
    public MapGraph(File file) {
        super(file);
    }

    /**
     * 插入顶点信息
     */
    @Override
    public void insertVertex(Vertex v) {
        vertexInfos[v.index] = v.date;
    }

    @Override
    public void insertEdge(Edge e) {
        weights[e.from][e.to] = e.weight;
    }

    @Override
    public void initChildrenFields() {
        vertexInfos = new String[vertexNum];
        weights = new int[vertexNum][vertexNum];
    }

    @Override
    public void print() {
        for (int i = 0; i < vertexNum; i++) {
            for (int j = 0; j < vertexNum; j++) {
                String from = vertexInfos[i];
                String to = vertexInfos[j];
                int weight = weights[i][j];
                System.out.print(from + "与" + to + "相连，距离为" + weight+"       ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        MapGraph graph = new MapGraph(new File("F:\\algorithm\\src\\algorithm_ZJU\\graph\\graph.txt"));
        graph.print();
    }
}
