package leetcode.剑指Offer专项练习.day12;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author kkddyz
 * @date 2022/3/4
 * @description
 */
public class 后缀表达式 {
    public int evalRPN(String[] tokens) {


        Deque<String> stack = new LinkedList<>();

        for (String token : tokens) {

            // 对于每个字符串 如果是操作数 直接入栈，
            if (!isOperator(token)) {
                stack.push(token);
            } else {
                // 如果是运算符 从栈中抛出两个操作数运算,将运算后的结果入栈
                stack.push(calculate(token, stack.pop(), stack.pop()) + "");
            }
        }

        // 最后返回 栈顶元素
        return Integer.parseInt(stack.peek());
    }


    private int calculate(String operator, String num1, String num2) {
        int b = Integer.parseInt(num1);
        int a = Integer.parseInt(num2);

        // java12的特性 java 8用不了
        switch (operator) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return a * b;
            case "/":
                return a / b;
        }

        return 0;
    }

    private boolean isOperator(String s) {
        return "+".equals(s) || "-".equals(s) || "*".equals(s) || "/".equals(s);
    }

    public static void main(String[] args) {
        后缀表达式 s = new 后缀表达式();
        String[] ss = {"4", "13", "5", "/", "+"};
        s.evalRPN(ss);
    }
}
