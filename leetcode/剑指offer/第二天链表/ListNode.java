package leetcode.剑指offer.第二天链表;

/**
 * @author kkddyz
 * @date 2021/11/22
 * @description
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    public ListNode addNext(int x) {
        next = new ListNode(x);
        return next;
    }

    public void print() {
        ListNode temp = this;
        while (temp != null) {
            System.out.print(temp.val + "，");
            temp = temp.next;
        }
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                '}';
    }
}
