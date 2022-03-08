package leetcode.剑指Offer专项练习.day16;

import leetcode.剑指Offer专项练习.util.TreeNode;

/**
 * @author kkddyz
 * @date 2022/3/5
 * @description
 */
public class SumNumbers {
    private int sum = 0;


    // 将当前val拼接到str,交给子节点
    // str是父节点传过来的值
    private void recurse(TreeNode root, String str) {

        // s是算上当前节点的路径数字
        String s = str + root.val;

        // 遇到叶结点 计算和
        if (root.left == null && root.right == null) {
            sum += Integer.parseInt(s);
        }

        // 否则传递给子节点
        if (root.left != null) {
            recurse(root.left, s);
        }

        if (root.right != null) {
            recurse(root.right, s);
        }

    }

    public int sumNumbers(TreeNode root) {
        // 使用字符串的拼接,每次调用下一层将当前已经得到的字符串传递

        recurse(root, "");

        return sum;
    }

    public static void main(String[] args) {
        SumNumbers s = new SumNumbers();
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        node1.left = node2;
        node1.right = node3;
        System.out.println(s.sumNumbers(node1));
    }
}
