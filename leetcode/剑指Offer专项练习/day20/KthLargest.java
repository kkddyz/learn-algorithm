package leetcode.剑指Offer专项练习.day20;

import java.util.PriorityQueue;

/**
 * @author kkddyz
 * @date 2022/3/8
 * @description
 */
public class KthLargest {

    private PriorityQueue<Integer> pq;
    private int size;

    public KthLargest(int k, int[] nums) {
        pq = new PriorityQueue<>();
        size = k;


        for (int num : nums) {
            add(num);
        }
    }

    public int add(int val) {

        pq.offer(val);
        if (pq.size() > size) {
            pq.poll();
        }

        return pq.peek();
    }

}
