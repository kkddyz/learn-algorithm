package leetcode.剑指offer.第二天链表;

/**
 * @author kkddyz
 * @date 2021/11/23
 * @description
 */

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }

    @Override
    public String toString() {
        return "Node{" +
                "val=" + val +
                '}';
    }
}

class Solution {
    public Node copyRandomList(Node head) {

        if (head == null){
            return null;
        }
        Node cur = head;
        Node newNode = null;
        Node temp = null;
        // 1. 拼接链表

        while (cur != null){

            // 创建新节点
            newNode = new Node(cur.val);

            // 插入到cur后面
            temp = cur.next;
            newNode.next = cur.next;
            cur.next = newNode;
            cur = temp;
        }

        // 2. 拷贝random
        cur = head;
        while(cur != null){
            if (cur.random != null){
                cur.next.random = cur.random.next;
            }else {
                // cur.next.random = null ; 但是初始化的值就是null，所以不需要做
            }
            cur = cur.next.next;
        }


        // 3. 拆分
        Node pre = head;
        cur = head.next;
        Node newHead = head.next;
        while(cur.next != null){

            // 拆分
            pre.next = pre.next.next;
            cur.next = cur.next.next;

            // 指针后移
            pre = pre.next;
            cur = cur.next;
        }

        // 最后一轮cur.next = null, cur.next.null.null 会报空指针异常
        pre.next = null;
        // 4. 返回头部
        return newHead;
    }

    public static void main(String[] args) {
        Node node7 = new Node(7);
        Node node13 = new Node(13);
        Node node11 = new Node(11);
        Node node10 = new Node(10);
        Node node1 = new Node(1);
        node7.next = node13;
        node13.next = node11;
        node11.next = node10;
        node10.next = node1;

        node13.random = node7;
        node11.random = node1;
        node10.random = node11;
        node1.random = node7;

        Solution s = new Solution();
        Node res = s.copyRandomList(node7);

    }
}