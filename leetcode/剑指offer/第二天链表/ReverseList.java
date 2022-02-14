package leetcode.剑指offer.第二天链表;

/**
 * @author kkddyz
 * @date 2021/11/22
 * @description
 */
public class ReverseList {
    public ListNode recurse(ListNode cur) {

        // 边界条件
        if (cur.next == null) {
            // 返回反转链表的尾部
            return cur;
        } else {
            ListNode head = recurse(cur.next);
            // 实现当前的反转
            ListNode tail = cur.next;
            tail.next = cur;
            cur.next = null;
            return head;
        }
    }


    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        return traverse(head);

    }

    /**
     * 1 -> 2 -> 3 -> 4
     * 每次将 cur的next指向pre 最后一轮 cur = 4,pre = 3 后移 变成 cur = null , pre = 4
     *
     */
    public ListNode traverse(ListNode head) {

        ListNode cur = head;
        ListNode pre = null;
        ListNode temp; // 用于移动双指针


        while (cur != null) {

            temp = cur.next;

            // 1 -> null
            cur.next = pre;


            pre = cur;
            cur = temp;
        }

        return pre;

    }

    public static void main(String[] args) {
        ListNode list = new ListNode(1);
        list.addNext(2).addNext(3);

        ReverseList solution = new ReverseList();
        ListNode reverseList = solution.reverseList(list);
        reverseList.print();
    }

}
