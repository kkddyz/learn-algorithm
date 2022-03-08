package leetcode.剑指Offer专项练习.day16;

import leetcode.剑指Offer专项练习.util.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author kkddyz
 * @date 2022/3/5
 * @description
 */
public class BinTreeSerialize {

    public String serialize(TreeNode root) {
        String str = "";
        if (root == null) {
            str += "None,";
        } else {
            str += root.val + ",";
            str += serialize(root.left);
            str += serialize(root.right);
        }
        return str;
    }


    public TreeNode deserialize(String str) {

        String[] nodes = str.split(",");

        // String[] -> ArrayList<String> -> LinkedList<String>
        // 使用LinkedList原因：相比于数组，链表的头部删除效率更高
        List<String> dataList = new LinkedList<>(Arrays.asList(nodes));

        // 通过递归实现
        return rdeserialize(dataList);


    }

    private TreeNode rdeserialize(List<String> dataList) {
        String curNodeVal = dataList.get(0);

        if ("None".equals(curNodeVal)) {
            dataList.remove(0);
            return null;
        } else {
            // parseInt返回int valueOf返回Integer
            TreeNode node = new TreeNode(Integer.parseInt(curNodeVal));
            // 移除当前结点
            dataList.remove(0);
            node.left = rdeserialize(dataList);
            node.right = rdeserialize(dataList);

            return node;
        }
    }

    public static void main(String[] args) {
        BinTreeSerialize s = new BinTreeSerialize();
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);

        node1.left = node2;
        node1.right = node3;
        node3.left = node4;
        node3.right = node5;

        TreeNode node = s.deserialize(s.serialize(node1));
        System.out.println(node);


    }
}
