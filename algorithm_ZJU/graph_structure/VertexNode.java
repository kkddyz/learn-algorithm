package algorithm_ZJU.graph_structure;

/**
 * @author kkddyz
 * @date 2021/10/29
 * @description 图的表示--邻接矩阵中的顶点(链表头)
 */
public class VertexNode {
    /**
     * 顶点保存的数据
     */
    protected String data;

    /**
     * adjNode组成的链表的头节点
     * vertexNode.adjNode == null 说明没有邻点
     */
    protected AdjNode adjNode;

    public VertexNode(String data, AdjNode adjNode) {
        this.data = data;
        this.adjNode = adjNode;
    }
}
