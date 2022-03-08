package leetcode.剑指Offer专项练习.day12;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author kkddyz
 * @date 2022/3/4
 * @description https://leetcode-cn.com/problems/iIQa4I/
 */
public class 每日温度 {

    public int[] dailyTemperatures(int[] temperatures) {

        int[] answer = new int[temperatures.length];
        // 使用Deque实现Stack
        Deque<Integer> stack = new LinkedList<>();

        // 确保stack单调递减(非严格)

        for (int i = 0; i < temperatures.length; i++) {


            /**
             * deque.peek() 相当于 peekFirst()
             * Deque代表的不论是Stack还是Queue,peeK()都是peekFirst(),因为Queue,Stack的差别在于insert，remove的位置
             */

            //// 如果当前元素满足非严格递减，入栈
            //if (stack.isEmpty() || element <= stack.peek()) {
            //    stack.push(i);
            //} else {
            //    // 否则，新元素即是栈顶元素的更高温度
            //    Integer popInteger = stack.pop(); // 抛出该元素
            //    answer[popInteger] = i - popInteger; // 记录answer
            //
            //}

            // 由于当前元素可能比多个栈顶元素都大，因此需要循环执行

            // 如果当前元素不满足非严格递减，循环出栈栈顶元素
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                Integer popInteger = stack.pop(); // 抛出该元素
                answer[popInteger] = i - popInteger; // 记录answer
            }
            stack.push(i);
        }
        return answer;
    }

}
