package leetcode.剑指offer.链表操作;

import leetcode.剑指offer.第二天链表.ListNode;

/**
 * @author kkddyz
 * @date 2021/12/1
 * @description
 */
public class GetIntersectionNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode A = headA;
        ListNode B = headB;

        // A B 重合循环结束
        while (A != B){
            A = (A.next != null) ? A.next : headB;
            B = (B.next != null) ? B.next : headA;
        }

        return A;
    }

    public static void main(String[] args) {




    }
}
