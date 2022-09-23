package algorithm_ZJU.tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author kkddyz
 * @date 2022/9/22
 * @description
 */
public class PreorderTraversal {

    private List<Integer> result = new ArrayList<>();

    public List<Integer> preTraversal(TreeNode root) {

        Deque<TreeNode> stack = new LinkedList<>();


        // cur表示当前访问的节点
        TreeNode cur = root;

        // 访问当前结点，然后压入左枝
        pushLeft(cur, stack);


        // 抛出栈顶元素(抛出该元素表示其左子树访问完成)
        while ((cur = stack.pollFirst()) != null) {

            // 压入cur.right的左枝
            pushLeft(cur.right, stack);
        }

        return result;

    }

    // 压入左枝(也就是node node.left node.left.left)
    private void pushLeft(TreeNode node, Deque<TreeNode> stack) {
        while (node != null) {
            // 在入栈前访问
            result.add(node.val);

            // 将结点入栈
            stack.addFirst(node);
            node = node.left;
        }
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);

        node1.right = node2;
        node2.left = node3;

        List<Integer> list = new PreorderTraversal().preTraversal(node1);
        System.out.println(list);
    }
}

