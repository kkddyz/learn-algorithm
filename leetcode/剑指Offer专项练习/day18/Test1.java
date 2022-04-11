package leetcode.剑指Offer专项练习.day18;

import leetcode.剑指Offer专项练习.util.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author kkddyz
 * @date 2022/3/6
 * @description
 */
public class Test1 {

    // 入栈时，循环压入左节点(模拟递归左子树)
    private void poll(Deque<TreeNode> queue,TreeNode root){
        TreeNode cur = root;
        // 将所有左结点入栈
        while (cur != null){
            queue.push(cur);
            cur = cur.left;
        }
    }


    public TreeNode convertBST(TreeNode root) {

        // 应该会使用栈，因为最先被访问到的结点，最后累加到最后才能知道值。

        // 先将所有结点入栈，出栈时，将值累加



        // 模拟中序遍历的递归
        Deque<TreeNode> queueA = new LinkedList<>();

        // 结点从A出栈后入栈B
        Deque<TreeNode> queueB = new LinkedList<>();

        // 中序遍历的模拟过程
        // 1. 入栈时，循环压入左节点(模拟递归左子树)
        // 2. 出栈时，(左递归结束)，将元素出栈（当前结点完成调用），
        // 2.1 right入栈（模拟递归右子树），循环压入right的所有左结点


        // 初始化 将root入栈
        poll(queueA,root);

        // 循环出栈(进入B)，出栈时压入right
        while (!queueA.isEmpty()){
            TreeNode node = queueA.pop(); // node出栈A
            queueB.push(node);            // node入栈B
            poll(queueA,node.right);      // node.right入栈A
        }

        int sum = 0;
        // 此时，依次修改B中的结点值

        while (!queueB.isEmpty()){
            TreeNode node = queueB.pop();
            sum += node.val;
            node.val = sum;
        }

        return root;
    }
}
