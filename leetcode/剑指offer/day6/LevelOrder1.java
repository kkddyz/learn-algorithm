package leetcode.剑指offer.day6;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author kkddyz
 * @date 2021/11/28
 * @description
 */
public class LevelOrder1 {
    public int[] levelOrder(TreeNode root) {

        if (root == null) {
            return new int[0];
        }

        List<Integer> list = new ArrayList<>();
        // 层序遍历
        Queue<TreeNode> queue = new LinkedList<>();

        // 预处理，将root入队
        queue.offer(root);

        // 循环取出元素
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            list.add(cur.val);

            // 将left,right入队
            if (cur.left != null) {
                queue.offer(cur.left);
            }

            if (cur.right != null) {
                queue.offer(cur.right);
            }
        }

        // List<Integer> ->int[]
        int[] res = new int[list.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}