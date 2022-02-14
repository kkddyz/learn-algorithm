package leetcode.剑指offer.day6;

/**
 * @author kkddyz
 * @date 2021/11/29
 * @description
 */
public class IsSubTree {
    // 找到相同的TreeNode,判断B是否是A的子树
    // B是A的子树，意味着B可以缺失部分叶节点
    // 在A中匹配B,当B==null，说明匹配结束返回ture
    // null是A的子树
    private boolean recurse(TreeNode A, TreeNode B) {
       if (B == null){
           return true;
       }

       // 这时 B!=null
       if (A == null){
           return false;
       }
       if (A.val != B.val){
           return false;
       }

       return recurse(A.left,B.left) && recurse(A.left,B.left);

    }

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        // 特例
        if (A == null || B == null) {
            return A == B;
        }

        // A!=null && B!=null

        return recurse(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);

    }

    public static void main(String[] args) {


        TreeNode node3 = new TreeNode(3);
        TreeNode node6 = new TreeNode(6);
        TreeNode node8 = new TreeNode(8);
        TreeNode node10 = new TreeNode(10);
        TreeNode node11 = new TreeNode(11);
        TreeNode node12 = new TreeNode(12);

        node10.left = node12;
        node10.right = node6;

        node12.left = node8;
        node12.right = node3;

        node6.left = node11;



        IsSubTree s = new IsSubTree();
        //System.out.println(s.isSubStructure(node4_1, node4_2));
    }
}
