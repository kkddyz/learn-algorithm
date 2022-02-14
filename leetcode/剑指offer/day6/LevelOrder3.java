package leetcode.剑指offer.day6;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author kkddyz
 * @date 2021/11/28
 * @description
 */
public class LevelOrder3 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> lists = new LinkedList<>();
        if (root == null) {
            return lists;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            //int level = 0; 不需要level，因为level == lists.size()
            LinkedList<Integer> list = new LinkedList<>();

            for (int i = queue.size(); i > 0; i--) {
                TreeNode cur = queue.poll();

                // 偶数层正序加到list,奇数层逆序加到list
                if (lists.size() % 2 == 0) {
                    list.addFirst(cur.val);
                } else {
                    list.addLast(cur.val);
                }

                // 加入左右结点
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
            }
            lists.add(list);
        }
        return lists;
    }

    public static void main(String[] args) {
        LevelOrder3 s = new LevelOrder3();
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;

        List<List<Integer>> lists = s.levelOrder(node1);
        for (List<Integer> list : lists) {
            System.out.println(list);
        }
    }
}