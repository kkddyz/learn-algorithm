package algorithm_ZJU.graph_structure;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author kkddyz
 * @date 2021/10/29
 * @description 使用二维数组(权重表)实现图
 */
public class MapFileGraph extends FileGraph {
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
    public MapFileGraph(File file) {
        super(file);
    }

    /**
     * 定义插入Vertex的实现
     */
    @Override
    public void insertVertex(Vertex v) {
        vertexInfos[v.index] = v.date;
    }


    /**
     * 定义插入Edge的实现
     */
    @Override
    public void insertEdge(Edge e) {
        weights[e.from][e.to] = e.weight;
    }

    @Override
    public void initChildrenFields() {
        vertexInfos = new String[vertexNum];
        weights = new int[vertexNum][vertexNum];
        // -1,表示没有边; 0表示自回路
        for (int i = 0; i < weights.length; i++) {
            for (int j = 0; j < weights[0].length; j++) {
                if (i == j) continue;
                weights[i][j] = -1;
            }
        }
    }

    @Override
    public void print() {
        for (int i = 0; i < vertexNum; i++) {
            for (int j = 0; j < vertexNum; j++) {
                String from = vertexInfos[i];
                String to = vertexInfos[j];
                int weight = weights[i][j];
                System.out.print(from + "与" + to + "，距离为" + weight + "       ");
            }
            System.out.println();
        }
    }

    @Override
    public List<Vertex> getAdjNodes(int from) {// 顶点编号

        List<Vertex> adjNodeList = new ArrayList<>();

        for (int i = 0; i < weights[from].length; i++) {

            int weight = weights[from][i];

            // 如果 weight[from][i]不是0/-1,说明存在边。
            // i对应的vertex就是from对应vertex的邻接点
            if (weight != 0 && weight != -1) {
                adjNodeList.add(new Vertex(i, vertexInfos[i]));
            }
        }

        return adjNodeList;
    }

    public static void main(String[] args) {
        MapFileGraph graph = new MapFileGraph(new File("F:\\algorithm\\src\\algorithm_ZJU\\graph_structure\\graph.txt"));
        graph.print();
        System.out.println("---------------------------------------------------------------------");

        // 打印A的邻接点
        List<Vertex> adjNodes = graph.getAdjNodes(0);
        System.out.println(Arrays.toString(new List[]{adjNodes}));
    }
}
