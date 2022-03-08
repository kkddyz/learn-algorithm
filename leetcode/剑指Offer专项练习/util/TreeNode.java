package leetcode.剑指Offer专项练习.util;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author kkddyz
 * @date 2022/3/5
 * @description
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) {
        val = x;
    }

    public static TreeNode deserialize(String str) {

        String[] nodes = str.split(",");

        // String[] -> ArrayList<String> -> LinkedList<String>
        // 使用LinkedList原因：相比于数组，链表的头部删除效率更高
        List<String> dataList = new LinkedList<>(Arrays.asList(nodes));

        // 通过递归实现
        return rdeserialize(dataList);


    }

    private static TreeNode rdeserialize(List<String> dataList) {
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
}
