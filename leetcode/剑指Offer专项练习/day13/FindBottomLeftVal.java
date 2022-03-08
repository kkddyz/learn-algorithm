package leetcode.剑指Offer专项练习.day13;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author kkddyz
 * @date 2022/3/4
 * @description
 */


public class FindBottomLeftVal {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public int findBottomLeftValue(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int leftVal = root.val;
        while (!queue.isEmpty()) {
            // 记录每一层最左边节点的值

            leftVal = queue.peek().val;
            for (int i = queue.size(); i > 0; i--) {
                TreeNode cur = queue.poll();
                if (cur.left != null) queue.offer(cur.left);
                if (cur.right != null) queue.offer(cur.right);

            }
        }

        return leftVal;

    }

    public static void main(String[] args) {
        FindBottomLeftVal s = new FindBottomLeftVal();
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);

        node1.left = node2;
        node1.right = node3;

        System.out.println(s.findBottomLeftValue(node1));
    }
}