package algorithm_ZJU.graph_structure;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author kkddyz
 * @date 2021/10/29
 * @description 使用邻接表实现图
 */
public class LinkedGraph extends FileGraph {
    /**
     * 邻接表实际上就是一个VertexNode数组
     */
    protected VertexNode[] adjList;

    public LinkedGraph(File file) {
        super(file);
    }

    @Override
    public void initChildrenFields() {
        adjList = new VertexNode[vertexNum];
    }

    @Override
    public void insertVertex(Vertex vertex) {

        // 创建VertexNode
        VertexNode vertexNode = new VertexNode(vertex.date, null);

        // 挂到对应的数组单元
        adjList[vertex.index] = vertexNode;
    }

    @Override
    public void insertEdge(Edge e) {

        // 创建AdjNode
        AdjNode newAdjNode = new AdjNode(e.to, e.weight);

        // 找到对应的vertexNode
        VertexNode vertexNode = adjList[e.from];

        // 插入到vertexNode后面
        AdjNode head = vertexNode.adjNode;
        // 插入链表
        if (head == null) {
            vertexNode.adjNode = newAdjNode;
        } else {
            // 使用头插法
            newAdjNode.next = head.next;
            head.next = newAdjNode;
        }
    }

    @Override
    public void print() {
        // 遍历VertexNode
        for (int i = 0; i < vertexNum; i++) {
            VertexNode vertexNode = adjList[i];
            String data = vertexNode.data;
            System.out.println("顶点" + data + "的邻接点有: ");

            // 遍历链表
            AdjNode cur = vertexNode.adjNode;
            while (cur != null) {
                System.out.println(adjList[cur.index].data + "距离为" + cur.weight);
                cur = cur.next;
            }

        }
    }

    @Override
    public List<Vertex> getAdjNodes(int vertexId) {

        List<Vertex> adjNodeList = new ArrayList<>();

        // 1. 找到对应的VertexNode
        VertexNode vertexNode = adjList[vertexId];

        // 2. 将VertexNode跟着的AdjNode封装成Vertex
        AdjNode adjNode = vertexNode.adjNode;
        while (adjNode != null) {
            // 邻接点的数据要到对应的vertexNode中寻找
            Vertex v = new Vertex(adjNode.index, adjList[adjNode.index].data);
            adjNodeList.add(v);
            adjNode = adjNode.next;
        }

        return adjNodeList;
    }

    public static void main(String[] args) {
        LinkedGraph linkedGraph = new LinkedGraph(new File("F:\\algorithm\\src\\algorithm_ZJU\\graph_structure\\graph.txt"));
        linkedGraph.print();

        System.out.println("---------------------------------------------");
        // 打印A的邻接点
        List<Vertex> adjNodes = linkedGraph.getAdjNodes(0);
        System.out.println(Arrays.toString(new List[]{adjNodes}));
    }

}
