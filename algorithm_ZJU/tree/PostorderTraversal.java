package algorithm_ZJU.tree;

import java.util.*;

/**
 * @author kkddyz
 * @date 2022/9/23
 * @description
 */

public class PostorderTraversal {

    // flags = false 没有访问cur的右子树，重新压入cur
    private Map<TreeNode, Boolean> flags = new HashMap<>();

    private List<Integer> result = new ArrayList<>();

    private Deque<TreeNode> stack = new LinkedList<>();

    public List<Integer> postorderTraversal(TreeNode root) {

        TreeNode cur;

        pushAllLeft(root);

        // 抛出栈顶元素
        while ((cur = stack.pollFirst()) != null) {
            // 如果没有访问右子树
            if (!flags.get(cur)) {
                // 将结点再次压入，开始访问右子树
                stack.addFirst(cur);
                pushAllLeft(cur.right);
                // 将标记置为true
                flags.put(cur, true);
            } else {
                // 访问了右子树，直接抛出
                result.add(cur.val);
            }

        }

        return result;

    }


    // 将左枝结点入栈
    private void pushAllLeft(TreeNode node) {
        while (node != null) {
            // 入栈前 初始化 : 没有访问右子树
            flags.put(node, false);
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

        List<Integer> list = new PostorderTraversal().postorderTraversal(node1);
        System.out.println(list);


    }

}
