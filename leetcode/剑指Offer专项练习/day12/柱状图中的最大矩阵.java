package leetcode.剑指Offer专项练习.day12;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author kkddyz
 * @date 2022/3/4
 * @description
 */
public class 柱状图中的最大矩阵 {

    /**
     * 对于每个柱子，向两边延展，枚举出所有可能的最大值
     */
    //public int largestRectangleArea(int[] heights) {
    //
    //    int maxS = 0;
    //    for (int i = 0; i < heights.length; i++) {
    //
    //        // 当前高度
    //        int curHeight = heights[i];
    //
    //        // 向左延展 左边存在，且左边的元素值不小于当前
    //        int left = i;
    //        while (left > 0 && heights[left - 1] >= curHeight) left--;
    //
    //        // 向右延展 右边存在，且右边的元素值不小于当前 最后情况 right + 1 = len -1，所以right < len - 1
    //        int right = i;
    //        while (right < heights.length - 1 && heights[right + 1] >= curHeight) right++;
    //
    //        int curS = (right - left + 1) * curHeight;
    //
    //        maxS = Math.max(curS, maxS);
    //    }
    //
    //    return maxS;
    //
    //
    //}
    public int largestRectangleArea(int[] heights) {


        int maxS = 0;
        // 单调栈 递增
        Deque<Integer> stack = new LinkedList<>();

        // 遍历heights数组
        for (int i = 0; i < heights.length; i++) {

            // 新元素小于栈顶元素，循环出栈
            while (!stack.isEmpty() && heights[i] < heights[stack.peek()]) {

                int curHeight = heights[stack.pop()];

                // 栈空, stack.peek() = -1 ==> i - stack.peek() - 1 == i
                int curLen = stack.isEmpty() ? i : i - stack.peek() - 1;

                int curS = curHeight * curLen;
                maxS = Math.max(curS, maxS);
            }
            // 如果大于栈底元素入栈(加入栈底)
            stack.push(i);
        }

        // 最后从入栈一个0，将所有元素清除
        while (!stack.isEmpty()) {
            int curHeight = heights[stack.pop()];
            // i = heights.length
            int curLen = stack.isEmpty() ? heights.length : heights.length - stack.peek() - 1;
            int curS = curHeight * curLen;
            maxS = Math.max(curS, maxS);
        }

        return maxS;
    }


    public static void main(String[] args) {
        int[] heights = {2, 1, 2};
        柱状图中的最大矩阵 s = new 柱状图中的最大矩阵();
        System.out.println(s.largestRectangleArea(heights));
    }
}
