package algorithm_ZJU.graph;

/**
 * @author kkddyz
 * @date 2021/10/29
 * @descriptor 图的表示 邻接矩阵中的顶点
 */
public class VertexNode {
    /**
     * 顶点保存的数据
     */
    protected String data;

    /**
     * 顶点的第一个邻点
     * first == null; // 说明没有邻点
     */
    protected AdjNode first;

    public VertexNode(String data, AdjNode first) {
        this.data = data;
        this.first = first;
    }
}
