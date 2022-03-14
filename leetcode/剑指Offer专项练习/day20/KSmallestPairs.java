package leetcode.剑指Offer专项练习.day20;

import java.util.*;

/**
 * @author kkddyz
 * @date 2022/3/10
 * @description
 */
public class KSmallestPairs {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {

        // 优先队列中存放所有最小的元素{1,2,3}，peek()得到的是其中最大的元素3。cur < peek()，add(cur)
        // 因此队列是一个最大堆,降序排列

        // 堆中的元素是长度为2的数组arr sum = arr[1]+arr[2]
        PriorityQueue<List<Integer>> pq = new PriorityQueue<>(
                // 定义比较器 a-b增序 b-a降序
                (a, b) -> b.get(0) + b.get(1) - a.get(0) - a.get(1)
        );


        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                // 将元素对{nums1[i],nums2[j]}入堆
                if (pq.size() < k) {
                    pq.offer(Arrays.asList(nums1[i], nums2[j]));
                } else {
                    if (nums1[i] + nums2[k] < pq.peek().get(0) + pq.peek().get(1)) {
                        pq.poll();
                        pq.offer(Arrays.asList(nums1[i], nums2[j]));
                    }
                }
            }
        }

        // 将qp元素放入list
        LinkedList<List<Integer>> ans = new LinkedList<>();
        while (!pq.isEmpty()) {
            List<Integer> integerPairs = pq.poll();
            ans.addLast(integerPairs);
        }
        return ans;
    }

    public static void main(String[] args) {
        KSmallestPairs s = new KSmallestPairs();
        int[] nums1 = {1,7,11};
        int[] nums2 = {2,4,6};
    }
}
