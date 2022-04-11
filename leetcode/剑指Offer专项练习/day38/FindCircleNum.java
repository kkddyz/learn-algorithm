package leetcode.剑指Offer专项练习.day38;

/**
 * @author kkddyz
 * @date 2022/3/28
 * @description
 */
public class FindCircleNum {

    private int[] parent;

    // 省份数量
    private int groupSize;

    public int findCircleNum(int[][] isConnected) {

        parent = new int[isConnected.length];
        groupSize = isConnected.length;

        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < isConnected.length; i++) {
            for (int j = 0; j < isConnected[0].length; j++) {
                // 如果两个城市相邻，且不在一个集合，合并所在集合
                if (isConnected[i][j] == 1 && i != j && find(i) != find(j)) {
                    union(i, j);
                }
            }
        }

        return groupSize;
    }

    // 查询元素所属的集合
    public int find(int index) {
        if (parent[index] != index) {
            return find(parent[index]);
        }

        return index;
    }

    // 合并元素搜所属集合
    public void union(int index1, int index2) {
        parent[find(index1)] = find(index2);

        // 每次合并，集合数量-1
        groupSize--;
    }

    public static void main(String[] args) {
        FindCircleNum s = new FindCircleNum();
        int[][] graph = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        System.out.println(s.findCircleNum(graph));
    }
}
