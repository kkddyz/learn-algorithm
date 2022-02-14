package algorithm_ZJU.graph_structure;

/**
 * @author kkddyz
 * @date 2021/10/29
 * @descriptor 顶点
 */
public class Vertex {

    /**
     * 顶点编号
     */
    protected int index;

    /**
     * 顶点数据
     */
    protected String date;

    public Vertex(int index, String date) {
        this.index = index;
        this.date = date;
    }
}
