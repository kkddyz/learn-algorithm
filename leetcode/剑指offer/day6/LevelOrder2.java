package leetcode.剑指offer.day6;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author kkddyz
 * @date 2021/11/28
 * @description
 */

/**
 * 层序遍历的区别在于需要将不同层的数值存到不同的list中
 * 我的思路是定义一个last指向每一层的最后一个元素
 * 每当元素出队时检查是否时last,如果last出队，需要计算新的last
 * 每当遇到last就新建一个list，后来的元素就存入新的list中
 */
public class LevelOrder2 {
    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> lists = new LinkedList<>();
        int level = 0; // lists存储的二叉树的层数 lists.get(i)存储第i层，root在第0层。

        if (root == null) {
            return lists;
        }
        // 队列
        Queue<TreeNode> queue = new LinkedList<>();

        // 初始化
        TreeNode last = root; // 初始化last
        TreeNode nextLast = null; // 下一层的last
        queue.offer(root); // 将root加入队列
        lists.add(new LinkedList<>());// 第0层的list

        while (!queue.isEmpty()) {

            // 取出元素
            TreeNode cur = queue.poll();

            // 将元素加入lists的第level层
            lists.get(level).add(cur.val);

            // 子节点入队
            if (cur.left != null) {
                queue.offer(cur.left);
            }
            if (cur.right != null) {
                queue.offer(cur.right);
            }

            /*
             * 更新last
             * 由于如果在队列中B在A之后出队，则B的孩子一定在A的孩子后面出队。
             * 下一层的last是上一层最后一个出队元素的孩子；
             * 所以，每当元素出队，就更新last，当最后一个有孩子的元素出队后，last就确定了
             */
            if (cur.left != null) {
                nextLast = cur.left;
            }
            if (cur.right != null) {
                nextLast = cur.right;
            }


            // 如果是last,并创建新的list，更新level
            if (cur.val == last.val) {
                // 更新last
                last = nextLast;

                // 新一层的last!=null
                if (nextLast != null) {
                    // 创建新一层的list,并且level++
                    lists.add(new LinkedList<>());
                    level++;
                }
                // nextLast对于每一个新层一开始都是null
                nextLast = null;
            }
        }
        return lists;
    }

    public static void main(String[] args) {
        LevelOrder2 s = new LevelOrder2();
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
