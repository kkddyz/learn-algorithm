package leetcode.剑指offer.链表操作;

import leetcode.剑指offer.第二天链表.ListNode;


/**
 * @author kkddyz
 * @date 2021/12/1
 * @description 很像mergeSort
 */
public class MergeTwoLists {


    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode dum = new ListNode(0);
        ListNode tail = dum;
        ListNode newNode;

        // 循环插入l1,l2的较小结点
        while (l1 != null && l2 != null) {

            // 选择newNode
            if (l1.val <= l2.val) {
                newNode = l1;
                l1 = l1.next;
            } else {
                newNode = l2;
                l2 = l2.next;
            }

            // 插入newNode
            tail.next = newNode;
            tail = newNode;
        }

        // 处理剩余部分
        // 如果 l1 == null,l2整体接到tail后面
        tail.next = (l1 == null) ? l2 : l1;

        return dum.next;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        node1.next = node2;


        ListNode node3 = new ListNode(1);
        ListNode node4 = new ListNode(4);
        node3.next = node4;

        MergeTwoLists s = new MergeTwoLists();
        ListNode node = s.mergeTwoLists(node1, node3);

        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }
}
