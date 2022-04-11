package leetcode.剑指Offer专项练习.day37;

import java.util.*;

/**
 * @author kkddyz
 * @date 2022/3/25
 * @description
 */
public class LadderLength {


    // 使用nodes记录结点信息, edges记录边信息
    // 使用Map而不是数组是因为，需要通过Node名找到对应的id || 动态增加结点
    private Map<String, Integer> nodes = new HashMap<>();

    // edges.get(i) 索引为i的结点的邻节点list
    private List<List<Integer>> edges = new ArrayList<>();

    // 不能使用nodes.size() 不考虑虚拟结点
    private int nodeNum = 0;

    /**
     * 返回结点对应的索引，如果不存在返回-1
     */
    private int getNodeId(String node) {
        if (nodes.containsKey(node)) {
            return nodes.get(node);
        }

        return -1;
    }

    /**
     * 将结点加入map,返回其索引
     */
    private int addNode(String word, Map<String, Integer> map) {
        if (!map.containsKey(word)) {
            map.put(word, map.size());
            // 添加结点时,初始化邻接点list
            edges.add(map.get(word), new ArrayList<>());
        }

        return map.get(word);
    }

    /**
     * 初始化结点信息,将wordList和beginWord加入nodes集合
     * wordList中的单词都不重复，但是beginWord可能会和wordList中的单词重复
     * 编号从0开始
     */
    private void initNodes(List<String> wordList, String beginWord) {
        for (String word : wordList) {
            addNode(word, nodes);
        }
        addNode(beginWord, nodes);
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        // 初始化结点
        initNodes(wordList, beginWord);

        if (!nodes.containsKey(endWord)) {
            // 如果endWord不在图中，直接返回false
            return 0;
        }

        // 创建node与其虚拟结点的边
        addEdges();


        // 初始化BFS信息,dis用来记录到start的距离

        int beginId = getNodeId(beginWord);
        int endId = getNodeId(endWord);

        return BFS(beginId, endId);
    }

    /**
     * 从begin开始BFS到end,返回距离
     * 保证end存在图中，所以会返回 dis , dis > 0
     */
    private int BFS(int beginId, int endId) {
        // 记录每个node到begin的距离，初始为Integer.MAX_VALUE，表示无法到达
        int[] dis = new int[nodes.size()];
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[beginId] = 0;

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(beginId);

        // 从begin开始BFS
        while (!queue.isEmpty()) {
            // 每次抛出一个结点v
            int v = queue.poll();
            // 检查是否是end
            if (v == endId) {
                return dis[endId] / 2 + 1;
            }
            //  将所有邻接点w入队
            for (int w : edges.get(v)) {
                // 还没有被访问过，更新dis，入队
                if (dis[w] == Integer.MAX_VALUE) {
                    dis[w] = dis[v] + 1;
                    queue.offer(w);
                }
            }
        }

        return 0;
    }

    /**
     * 据朴素的思路，我们可以枚举每一对单词的组合，判断它们是否恰好相差一个字符，以判断这两个单词对应的节点是否能够相连。
     * <p>
     * 但是这样效率太低，我们可以创建虚拟节点，优化建图，
     * 对于单词 `hit`，我们创建三个虚拟节点 `*it`、`h*t`、`hi*`，并让 `hit` 向这三个虚拟节点分别连一条边即可。
     * 如果一个单词能够转化为 `hit`，那么该单词必然会连接到这三个虚拟节点之一。
     * 比如hot，他连接的虚拟节点是`*ot`,`h*t`,`ho*`，于是`hot`,`hit`通过虚拟结点`h*t连接`
     * <p>
     * 所以具体的做法是：对于每一个单词，我们枚举它连接到的虚拟节点，把该单词对应的 `id` 与这些虚拟节点对应的 `id` 相连即可。
     * <p>
     * 在foreach中不允许修改容器，因此需要在创建新容器temp存放所有结点信息。
     * addEdges()结束后返回temp，将成员
     *
     * @return
     */
    private void addEdges() {

        // 遍历每一个node(不需要枚举虚拟结点)
        // 遍历的node属于nodes.keySet(),后加入的虚拟结点不会被考虑


        Map<String, Integer> temp = new HashMap<>(nodes);

        for (String node : nodes.keySet()) {
            char[] chars = node.toCharArray();

            // 循环创建word对应的虚拟结点
            for (int i = 0; i < chars.length; i++) {
                char c = chars[i];
                chars[i] = '*';
                String virtualNode = new String(chars);
                // 添加edge(vNode,node)
                addEdge(virtualNode, node, temp);

                chars[i] = c;
            }
        }

        // 更新nodes
        this.nodes = temp;
    }


    /**
     * 创建虚拟结点与当前结点的边,将结点信息存入temp
     */
    private void addEdge(String virtualNode, String node, Map<String, Integer> temp) {

        int vid = addNode(virtualNode, temp); // 虚拟结点索引
        int id = getNodeId(node); // 当前结点索引

        // 添加边
        edges.get(id).add(vid);
        edges.get(vid).add(id);
    }


    public static void main(String[] args) {

        List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");

        String beginWord = "hit";
        String endWord = "cog";

        LadderLength s = new LadderLength();
        System.out.println(s.ladderLength(beginWord, endWord, wordList));
    }
}
