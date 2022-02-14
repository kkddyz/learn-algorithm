package algorithm_ZJU.graph_structure;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * The type Graph.
 *
 * @author kkddyz
 * @date 2021 /10/29
 * @description 使用流创建graph对象
 */
public abstract class Graph {
    /**
     * 顶点数量
     */
    protected int vertexNum;

    /**
     * 边数量
     */
    protected int edgeNum;

    /**
     * 初始化子类的成员
     */
    public abstract void initChildrenFields();

    /**
     * 插入顶点
     */
    public abstract void insertVertex(Vertex v);

    /**
     * 插入边
     */
    public abstract void insertEdge(Edge e);

    /**
     * 打印图
     */
    public abstract void print();

    /**
     * 获取邻接点
     */
    public abstract Vertex[] getVertex(Vertex vertex);


    /**
     * 使用File创建图的流程，子类通过实现抽象方法，完成对象创建。
     */
    public Graph(File file) {
        try {
            // 读取文件流
            Scanner in = new Scanner(new FileInputStream(file));

            // 读取vertexNum edgeNum
            int vertexNum = in.nextInt();
            int edgeNum = in.nextInt();

            // 创建空图
            this.vertexNum = vertexNum;
            this.edgeNum = edgeNum;

            //  初始化变量(子类可能会需要这两个变量初始化他们自己的成员变量)
            initChildrenFields();

            //  插入顶点数据 -- 先插入顶点，不然使用邻接表的时候，AdjNode没地方挂
            for (int i = 0; i < vertexNum; i++) {
                //i是Vertex的下标
                Vertex vertex = new Vertex(i, in.next());
                insertVertex(vertex);
            }

            // 插入边数据 -- 默认无向图
            for (int i = 0; i < edgeNum; i++) {
                int from = in.nextInt();
                int to = in.nextInt();
                int weight = in.nextInt();
                Edge edge1 = new Edge(from, to, weight);
                Edge edge2 = new Edge(to, from, weight);
                insertEdge(edge1);
                insertEdge(edge2);
            }


        } catch (FileNotFoundException e) {
            System.out.println("未找到初始化文件 '" + file + "' ，请检查路径");
        }
    }
}

