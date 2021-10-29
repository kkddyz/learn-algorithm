package algorithm_ZJU.graph;


/**
 * @ClassName Edge
 * @Description 边
 * @date  2021/10/29
 **/

public class Edge {
    /**
     * 有向边<from,to>
     */
    protected int from, to;

    /**
     * 边的权重
     */
    protected int weight;

    public Edge(int from, int to, int weight) {
        this.from = from;
        this.to = to;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Edge{" +
                "from=" + from +
                ", to=" + to +
                ", weight=" + weight +
                '}';
    }
}
