package leetcode.剑指Offer专项练习.day17;

import leetcode.剑指Offer专项练习.util.TreeNode;

import java.util.HashMap;

/**
 * @author kkddyz
 * @date 2022/3/5
 * @description
 */
public class Test1 {

    //List<TreeNode> list = new ArrayList<>();
    //
    //public void recurse(TreeNode root){
    //
    //    if (root.left != null){
    //        recurse(root.left);
    //    }
    //
    //    list.add(root);
    //
    //    if (root.right != null){
    //        recurse(root.right);
    //    }
    //
    //}
    //
    //public TreeNode increasingBST(TreeNode root) {
    //
    //    // 1. 中序遍历 将遍历到的结点，依次放入列表
    //    recurse(root);
    //
    //    // 2. 遍历list
    //    TreeNode head = new TreeNode(0);
    //    TreeNode cur = head;
    //    for (TreeNode node : list){
    //        cur.right = node;
    //        cur = cur.right;
    //    }
    //
    //    return head.right;
    //}


    // 新链表的tail
    private TreeNode tail;


    public TreeNode increasingBST(TreeNode root) {

        // dummyNode 虚拟结点 我用head表示
        // resNode类似于pre(反转链表的tail)
        TreeNode head = new TreeNode(-1);
        tail = head;
        inorder(root);
        return head.right;
    }

    public void inorder(TreeNode node) {
        if (node == null) {
            return;
        }
        inorder(node.left);

        // 在中序遍历的过程中修改节点指向

        // 将node.left置空时，因为使用中序遍历，此时不需要用到left，所以不会有印影响
        tail.right = node;
        node.left = null;
        tail = node;

        inorder(node.right);

        HashMap<Object, Object> map = new HashMap<>();
    }

    public static void main(String[] args) {
        Test1 s = new Test1();
        TreeNode node = TreeNode.deserialize("5,3,2,1,None,None,None,4,None,None,6,None,None,7,None,None,9,None,None,");
        s.increasingBST(node);
    }
}
