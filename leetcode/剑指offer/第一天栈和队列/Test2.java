package leetcode.剑指offer.第一天栈和队列;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author kkddyz
 * @date 2021/11/22
 * @description
 */
public class Test2 {
}

class MinStack {

    Deque<Integer> stack;
    Deque<Integer> minStack;

    public MinStack() {
        stack = new LinkedList<>();
        minStack = new LinkedList<>();
    }

    /**
     * 注意入栈条件 x <= min()
     * 当堆栈为空时也直接入栈
     */
    public void push(int x) {
        stack.push(x);
        if (minStack.isEmpty() || x <= min()) {
            minStack.push(x);
        }
    }

    public void pop() {
        int cur = stack.pop();
        // 如果当前元素是minStack栈顶元素
        if (cur == min()) {
            minStack.pop();
        }
    }


    /**
     * 返回栈顶元素
     */
    public int top() {
        return stack.peek();
    }

    /**
     * @return stack最小值
     */
    public int min() {
        return minStack.peek();
    }

    public static void main(String[] args) {
        MinStack stack = new MinStack();
        stack.push(0);
        stack.push(1);
        stack.push(0);
        System.out.println(stack.min()); // -3
        stack.pop(); // -2 0
        System.out.println(stack.top()); // -2
        System.out.println(stack.min()); // -2

    }
}


