package algorithm_ZJU.graph;

/**
 * @author kkddyz
 * @date 2021 /10/29
 * @descriptor 图的表示 邻接矩阵中的邻点 AdjNode只记录边相关的信息 邻点的编号，距离。
 */
public class AdjNode {

    /**
     * 相邻结点的下标 -- VertexNode保存在数组中的下标
     */
    protected int index;

    /**
     * 权重
     */
    protected int weight;

    /**
     * 指向下一个邻点
     */
    protected AdjNode next;

    public AdjNode(int index, int weight) {
        this.index = index;
        this.weight = weight;
    }
}
