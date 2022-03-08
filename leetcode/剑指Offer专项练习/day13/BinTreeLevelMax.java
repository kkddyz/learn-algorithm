package leetcode.剑指Offer专项练习.day13;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


/**
 * @author kkddyz
 * @date 2022/3/4
 * @description
 */
public class BinTreeLevelMax {


    public class TreeNode {
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

// 肯定是使用队列，层序遍历

    public List<Integer> largestValues(TreeNode root) {
        List<Integer> ans = new ArrayList<>();

        if (root == null) {
            return ans;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        
        while (!queue.isEmpty()) {
            // 遍历每一层
            int levelMax = queue.peek().val;
            for (int i = queue.size(); i > 0; i--) {
                // 出队元素
                TreeNode node = queue.poll();

                if (node.val > levelMax) {
                    levelMax = node.val;
                }

                // 子节点入队
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);

            }
            ans.add(levelMax);
        }
        return ans;
    }

}