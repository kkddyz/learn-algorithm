package leetcode.other;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kkddyz
 * @date 2022/2/23
 * @description
 */
public class KthFactory {

    public static int kthFactor(int n, int k) {

        // 按顺序求N的因子 由于Deque不能根据索引获取值，所以使用两个List模拟


        // 第三个
        // before 正序 1 2
        // after  倒序 8 4
        List<Integer> before = new ArrayList<>();
        List<Integer> after = new ArrayList<>();


        // 将因子放入list
        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                before.add(i);
                if (i * i != n) {
                    after.add(n / i);
                }
            }
        }


        if (k <= before.size()) {
            return before.get(k);
        } else if (k <= before.size() + after.size()) {
            // reverseAfterIndex 返回值在after的倒数第几个
            int reverseAfterIndex = k - before.size();
            return after.get(after.size() - reverseAfterIndex);
        } else {
            return -1;
        }
    }


    public static void main(String[] args) {
        System.out.println(kthFactor(16, 4));
    }
}
