package leetcode.剑指Offer专项练习.day20;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * @author kkddyz
 * @date 2022/3/8
 * @description
 */
public class TopKFrequent {
    public int[] topKFrequent(int[] nums, int k) {

        // K为数字，V为出现次数
        HashMap<Integer, Integer> map = new HashMap();
        // 统计词频
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // 使用堆记录前k个词频的数字
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return map.get(a) - map.get(b);
            }
        });


        for (Integer key : map.keySet()) {
            if (pq.size() < k) {
                pq.offer(key);
            } else if (map.get(key) > map.get(pq.peek())) {
                pq.poll();
                pq.offer(key);
            }
        }

        // 取出最小堆的元素
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = pq.poll();
        }

        return res;


    }
}