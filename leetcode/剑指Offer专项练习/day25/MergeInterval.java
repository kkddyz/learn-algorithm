package leetcode.剑指Offer专项练习.day25;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author kkddyz
 * @date 2022/3/14
 * @description
 */
public class MergeInterval {
    public int[][] merge(int[][] intervals) {
        // 排序数组
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        List<int[]> mergedList = new ArrayList<>();
        int cur;
        for (cur = 0; cur + 1 < intervals.length; ) { // next = cur + 1
            // 初始化
            int[] mergedInterval = {intervals[cur][0], intervals[cur][1]};
            int[] nextInterval = {intervals[cur + 1][0], intervals[cur + 1][1]};
            // 循环合并
            while (mergedInterval[1] >= nextInterval[0]) {
                // 合并区间
                mergedInterval = new int[]{mergedInterval[0], Math.max(mergedInterval[1], nextInterval[1])};
                // 后移nextInterval,继续合并
                cur++;

                // 可能会出现一直合并到结尾，next越界,对该情况直接终止
                if (cur + 1 == intervals.length) {
                    break;
                } else {
                    nextInterval = new int[]{intervals[cur + 1][0], intervals[cur + 1][1]};
                }
            }
            // 直到next不与cur重合，加入mergedInterval
            mergedList.add(new int[]{mergedInterval[0], mergedInterval[1]});
            // 此时cur指向合并的最后元素，next指向下一轮的cur
            cur++;
        }
        // 1. 合并到末尾 cur == len 2. 没有合并到末尾 cur = len -1
        if (cur == intervals.length - 1) {
            mergedList.add(new int[]{intervals[intervals.length - 1][0], intervals[intervals.length - 1][1]});
        }
        return mergedList.toArray(new int[0][0]);
    }

    public static void main(String[] args) {
        MergeInterval s = new MergeInterval();
        int[][] intervals = {{1, 4}, {4, 5}};
        int[][] mergedArr = s.merge(intervals);
        for (int[] ints : mergedArr) {
            System.out.println(Arrays.toString(ints));
        }


    }
}
