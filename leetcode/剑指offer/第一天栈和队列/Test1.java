package leetcode.剑指offer.第一天栈和队列;

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * @author kkddyz
 * @date 2021/11/22
 * @description
 */

class CQueue {


    /**
     * 入队栈
     */
    private Deque<Integer> stack_A = new LinkedList<>();
    /**
     * 出队栈
     */
    private Deque<Integer> stack_B = new LinkedList<>();


    /**
     * deque实现栈操作
     * deque.addFirst();   入栈
     * deque.removeFirst();出栈
     */
    public CQueue() {
    }


    public void appendTail(int value) {
        // 元素都加入到A
        stack_A.addFirst(value);
    }

    public int deleteHead() {

        // 1. 当前出队栈不空
        if (!stack_B.isEmpty()) {
            // 出栈
            return stack_B.removeFirst();
        } else if (stack_A.isEmpty()) {
            // 2. B空栈，且A没有元素，返回-1
            return -1;
        } else {
            // 3. B空栈，A不空 -- A出栈，B入栈
            Iterator<Integer> a_iter = stack_A.iterator();
            while (a_iter.hasNext()) {
                stack_B.addFirst(stack_A.removeFirst());
            }
            return stack_B.removeFirst();
        }
    }
}


public class Test1 {
    public static void main(String[] args) {
        CQueue cQueue = new CQueue();
        int value = 1;
        cQueue.appendTail(1);
        cQueue.appendTail(2);
        cQueue.appendTail(3);

        System.out.println(cQueue.deleteHead());
        System.out.println(cQueue.deleteHead());
        System.out.println(cQueue.deleteHead());
    }

}
