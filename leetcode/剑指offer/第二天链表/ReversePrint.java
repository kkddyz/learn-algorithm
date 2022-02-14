package leetcode.剑指offer.第二天链表;

import java.util.Arrays;

/**
 * @author kkddyz
 * @date 2021/11/22
 * @description
 */


public class ReversePrint {

    public int[] recurse(int pos, ListNode cur) {

        // 特殊情况 链表为空
        if (cur == null){
            return new int[0];
        }

        // 正常情况
        // 递归出口 pos == list.size() - 1
        if (cur.next == null) {
            int[] arr = new int[pos + 1];
            // pos是正确的位置，recursePos是倒置的位置
            int recursePos = arr.length - 1 - pos;
            arr[recursePos] = cur.val;
            return arr;
        } else {
            /*
             * 首先，需要保证pos之后的数组位置都被赋值
             */
            int[] arr = recurse(pos + 1, cur.next);

            // 递归结束 把自己的cur赋值好
            int recursePos = arr.length - 1 - pos;
            arr[recursePos] = cur.val;

            return arr;
        }
    }

    public int[] reversePrint(ListNode head) {

        return recurse(0, head);
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        head.addNext(1).addNext(2).addNext(3).addNext(4);
        head.print();

        ReversePrint s = new ReversePrint();
        int[] ints = s.recurse(0, head);
        System.out.println(Arrays.toString(ints));
    }
}