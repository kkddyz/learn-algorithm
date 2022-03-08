package leetcode.剑指Offer专项练习.day17;

import leetcode.剑指Offer专项练习.util.TreeNode;

/**
 * @author kkddyz
 * @date 2022/3/5
 * @description
 */
public class Test2 {


    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        // 记录当前比 p 节点大的节点
        TreeNode ans = null;
        // 在二叉搜索树中进行搜索
        while (root != null) {
            // 如果当前节点 > p，则更新当前比 p 节点大的节点 ans , 同时去左子树进行搜索
            if (root.val > p.val) {
                ans = root;
                root = root.left;
            } else {// 如果当前节点 <= p , 则到右子树进行搜索
                root = root.right;
            }
        }
        // 当搜寻结束后，ans 保存的就是最近的比 p 节点大的节点。
        return ans;
    }


    public static void main(String[] args) {
        TreeNode node = TreeNode.deserialize("5,3,2,1,None,None,None,4,None,None,6,None,None,");

        Test2 s = new Test2();
        s.inorderSuccessor(node,new TreeNode(3));
    }

}
