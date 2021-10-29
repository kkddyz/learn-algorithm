package algorithm_ZJU.graph;

import java.io.File;

/**
 * @author kkddyz
 * @date 2021/10/29
 * @description 使用邻接表实现图
 */
public class LinkedGraph extends Graph {
    /**
     * 邻接表 本质就是一个VertexNode数组
     */
    protected VertexNode[] adjList;

    public LinkedGraph(File file) {
        super(file);
    }

    /**
     * 插入顶点数据
     */
    @Override
    public void insertVertex(Vertex v) {

        // 创建VertexNode
        VertexNode vertexNode = new VertexNode(v.date, null);

        // 挂到对应的数组单元
        adjList[v.index] = vertexNode;
    }

    @Override
    public void insertEdge(Edge e) {

        // 创建AdjNode
        AdjNode newAdjNode = new AdjNode(e.to, e.weight);

        // 找到对应的vertexNode
        VertexNode vertexNode = adjList[e.from];

        AdjNode head = vertexNode.first;
        // 插入链表
        if (head == null) {
            vertexNode.first = newAdjNode;
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
            AdjNode cur = vertexNode.first;
            while (cur != null) {
                System.out.println(adjList[cur.index].data + "距离为" + cur.weight);
                cur = cur.next;
            }

        }
    }

    @Override
    public void initChildrenFields() {
        adjList = new VertexNode[vertexNum];
    }

    public static void main(String[] args) {
        LinkedGraph linkedGraph = new LinkedGraph(new File("F:\\algorithm\\src\\algorithm_ZJU\\graph\\graph.txt"));
        linkedGraph.print();
    }

}
