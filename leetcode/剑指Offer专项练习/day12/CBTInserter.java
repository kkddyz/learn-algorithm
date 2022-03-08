package leetcode.剑指Offer专项练习.day12;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author kkddyz
 * @date 2022/3/4
 * @description
 */


class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class CBTInserter {

    private ArrayList<Integer> binTreeArr;


    public CBTInserter(TreeNode root) {

        binTreeArr = new ArrayList<>();
        binTreeArr.add(0);// 加入任意元素，使得root从1开始

        // 将BinTree写入数组
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {

            // 取出队首元素，加入数组
            TreeNode head = queue.remove();
            binTreeArr.add(head.val);

            // 子节点入队
            if (head.left != null) queue.add(head.left);
            if (head.right != null) queue.add(head.right);

        }
    }


    private TreeNode newNode(int nodeIndex) {
        TreeNode node = new TreeNode(binTreeArr.get(nodeIndex));

        // 创建左结点
        if (nodeIndex * 2 < binTreeArr.size()) {
            node.left = newNode(nodeIndex * 2);
        }

        // 创建右结点
        if (nodeIndex * 2 + 1 < binTreeArr.size()) {
            node.right = newNode(nodeIndex * 2 + 1);
        }

        return node;
    }

    public int insert(int v) {
        int fatherIndex = binTreeArr.size() / 2;
        binTreeArr.add(v);
        return binTreeArr.get(fatherIndex);
    }

    public TreeNode get_root() {
        return newNode(1);
    }

    public static void main(String[] args) {
        CBTInserter cbtInserter = new CBTInserter(new TreeNode(1));
        cbtInserter.insert(2);
        cbtInserter.insert(3);
        System.out.println(cbtInserter.get_root());
    }
}
