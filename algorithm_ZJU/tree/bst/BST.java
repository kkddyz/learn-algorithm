package algorithm_ZJU.tree.bst;


import algorithm_ZJU.tree.TreeNode;

/**
 * @author kkddyz
 * @date 2022/9/23
 * @description
 */

public class BST {

    public TreeNode deleteNode(TreeNode root, int key) {

        // key不存在，递归终止
        if (root == null) return null;

        if (key < root.val) {
            root.left = deleteNode(root.left, key);
            return root;
        } else if (key > root.val) {
            root.right = deleteNode(root.right, key);
            return root;
        } else {
            // 删除

            // 1. 叶子结点 直接删除
            if (root.left == null && root.right == null) {
                return null;
            } else if (root.left != null && root.right != null) {
                // 2. 两个child
                // 2.1 寻找右子树的最小值作为successor
                TreeNode successor = root.right;
                while (successor.left != null) {
                    successor = successor.left;
                }
                // 2.2 删除successor (让successor.right代替successor)
                root.right = deleteNode(root.right, successor.val);

                // 2.3 successor代替root
                successor.right = root.right;
                successor.left = root.left;

                return successor;
            } else {
                // 3. 一个child 使用child代替删除结点位置
                return (root.left != null) ? root.left : root.right;
            }
        }


    }

    public static void main(String[] args) {

        TreeNode node5 = new TreeNode(5);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);

        TreeNode node6 = new TreeNode(6);
        TreeNode node4 = new TreeNode(4);
        TreeNode node7 = new TreeNode(7);


        node3.left = node2;
        node3.right = node4;

        node6.right = node7;

        node5.left = node3;
        node5.right = node6;


        new BST().deleteNode(node5,3);
    }
}