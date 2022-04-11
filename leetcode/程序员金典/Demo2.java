package leetcode.程序员金典;

import leetcode.剑指offer.第二天链表.ListNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author kkddyz
 * @date 2022/4/11
 * @description 排序链表结点
 */
public class Demo2 {


    /**
     * 对节点值排序，然后重建list
     */
    public ListNode sortList1(ListNode head) {

        ListNode cur = head;
        List<Integer> vals = new ArrayList<>();

        // 获取vals
        while (cur != null) {
            vals.add(cur.val);
            cur = cur.next;
        }

        // 降序排序
        vals.sort(Collections.reverseOrder());

        // 创建虚拟结点
        ListNode vNode = new ListNode(0);


        // 循环头插入
        for (Integer e : vals) {
            ListNode node = new ListNode(e);
            node.next = vNode.next;
            vNode.next = node;
        }

        return vNode.next;
    }

    /**
     * 并归排序list
     * <p>
     * 并归排序步骤
     * 1. 确定递归的终止条件，返回基本情况
     * 2. 将list分割为左右部分，递归排序左右部分
     * 3. 将左右部分排序，然后返回整体
     */
    public ListNode sortList(ListNode head) {

        // 递归出口
        if (head == null || head.next == null) {
            return head;
        }

        // 分割结点 head,newHead为子节点的head
        ListNode newHead = splitList(head);

        // 递归排序子list
        ListNode list1 = sortList(head);
        ListNode list2 = sortList(newHead);

        // 返回合并后的list
        return mergeLists(list1, list2);
    }

    private ListNode splitList(ListNode head) {
        ListNode fast = head.next;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        // 以slow为分割点
        ListNode newHead = slow.next;
        slow.next = null;

        return newHead;
    }

    // 返回合并后的list
    private ListNode mergeLists(ListNode list1, ListNode list2) {

        // 使用尾插法合并 头尾插法都需要虚拟结点
        ListNode vNode = new ListNode(0);
        ListNode tail = vNode;

        // 如果list1.val == list2.val list1在前
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                tail.next = list1;
                list1 = list1.next;
            } else {
                tail.next = list2;
                list2 = list2.next;
            }
            tail = tail.next;
        }

        // 将剩余链表，连接到tail后面
        if (list1 == null) {
            tail.next = list2;
        } else {
            tail.next = list1;
        }
        return vNode.next;
    }

    public static void main(String[] args) {
        Demo2 s = new Demo2();
        ListNode head = new ListNode(3);
        head.addNext(4).addNext(2).addNext(1);
        ListNode node = s.sortList(head);
        System.out.println(node);
    }
}
