package algorithm_ZJU.graph_structure;

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
    public Vertex[] getVertex(Vertex vertex) {
        // 1. 查找到对应的VertexNode
        VertexNode vertexNode = adjList[vertex.index];
        // 2. 循环遍历AdjNode查询数量,创建邻接点的数组
        AdjNode head = vertexNode.first;
        int adjNodeNum = 0;
        while (head != null) {
            head = head.next;
            adjNodeNum++;
        }
        Vertex[] adjArr = new Vertex[adjNodeNum];


        // 3.循环遍历AdjNode，填入adjArr
        head = vertexNode.first;
        int i = 0;
        while (head != null) {
            int index = head.index;
            int weight = head.weight;
            head = head.next;

        }

        // 需要一个新的数据结构表示邻点。
        return adjArr;

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
