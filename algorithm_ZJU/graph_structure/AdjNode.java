package algorithm_ZJU.graph_structure;

/**
 * @author kkddyz
 * @date 2021 /10/29
 * @description 图的表示--邻接矩阵中的邻点
 */
public class AdjNode {

    /**
     * 邻结点的索引
     */
    protected int index;

    /**
     * 权重 vertexNode到adjNode的距离
     */
    protected int weight;

    /**
     * 指向下一个AdjNode
     */
    protected AdjNode next;

    public AdjNode(int index, int weight) {
        this.index = index;
        this.weight = weight;
    }
}
