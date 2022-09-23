package leetcode.程序员金典;

import leetcode.剑指offer.第二天链表.ListNode;

/**
 * @author kkddyz
 * @date 2022/4/21
 * @description
 */
public class Demo4 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        int val;
        int next = 0;

        ListNode dummyNode = new ListNode(0);
        ListNode tail = dummyNode;

        while (l1 != null || l2 != null) {

            // 计算当前value与进位值
            val = getVal(l1) + getVal(l2) + next;
            next = val / 10;
            val %= 10;

            // 创建结点 尾插法
            ListNode node = new ListNode(val);
            tail.next = node;
            tail = tail.next;

            // 指针后移
            l1 = next(l1);
            l2 = next(l2);
        }

        // l1 == null && l2 == null --> val = next
        ListNode node = new ListNode(next);
        tail.next = node;


        return dummyNode.next;
    }

    private int getVal(ListNode node) {
        return node == null ? 0 : node.val;
    }

    private ListNode next(ListNode node) {
        return node == null ? null : node.next;
    }

    public static void main(String[] args) {

        ListNode node7 = new ListNode(7);
        ListNode node5 = new ListNode(5);

        node7.addNext(1).addNext(9);
        node5.addNext(9).addNext(2);

        Demo4 demo4 = new Demo4();
        demo4.addTwoNumbers(node5,node5);

    }
}
