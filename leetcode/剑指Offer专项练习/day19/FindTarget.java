package leetcode.剑指Offer专项练习.day19;

import leetcode.剑指Offer专项练习.util.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author kkddyz
 * @date 2022/3/8
 * @description
 */
public class FindTarget {

    // 循环入栈左子结点
    private void pushLeftToStack(TreeNode root, Deque<TreeNode> stack){
        // 中序
        while (root != null){
            stack.push(root);
            root = root.left;
        }
    }

    // 循环入栈右子结点
    private void pushRightToStack(TreeNode root,Deque<TreeNode> stack){
        // 反中序
        while (root != null){
            stack.push(root);
            root = root.right;
        }
    }

    private class BSTIterator{

        // 辅助栈 iStack == inorderQueue,rStack == reverseOrderStack
        private Deque<TreeNode> iStack,rStack;

        public BSTIterator(TreeNode root){

            // 初始化辅助栈
            iStack = new LinkedList<>();
            rStack = new LinkedList<>();

            // 将root分别入栈
            TreeNode temp = root;
            pushLeftToStack(temp,iStack);
            pushRightToStack(root,rStack);
        }

        // iStack出栈
        public int getLeftNext(){
            // 出栈node
            TreeNode node = iStack.pop();

            // 入栈node.right所有左子结点
            pushLeftToStack(node.right,iStack);

            return node.val;
        }

        // rStack出栈
        public int getRightNext(){
            // 出栈node
            TreeNode node = rStack.pop();

            // 入栈node.left所有右子节点
            pushRightToStack(node.left,rStack);

            return node.val;
        }
    }
    public boolean findTarget(TreeNode root, int k) {

        BSTIterator iterator = new BSTIterator(root);

        int a = iterator.getLeftNext();
        int b = iterator.getRightNext();
        while (a < b){
            if(a + b < k ){
                a = iterator.getLeftNext();
            }else if(a + b > k){
                b = iterator.getRightNext();
            }else{
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {

        String str = "8,6,5,None,None,7,None,None,10,9,None,None,11,None,None,";
        TreeNode node = TreeNode.deserialize(str);
        FindTarget f = new FindTarget();
        f.findTarget(node,22);
    }
}
