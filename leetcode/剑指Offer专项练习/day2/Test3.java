package leetcode.剑指Offer专项练习.day2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author kkddyz
 * @date 2022/2/4
 * @description
 */
public class Test3 {

    public int[] twoSum(int[] numbers, int target) {


        int[] res = new int[2];

        // 对于元素nums[i] 应该在Map中寻找是否存在V=target-nums[i];

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            // 我们只能根据数组值在Map中找到对应的index
            map.put(numbers[i], i);
        }

        // 存在重复元素，那么Map只会存入一个，这个是后面一个
        // 最后数组中的索引是相同的，题目中保证只存在一组符合条件的索引，所以重复元素数量只能为2

        for (int j = 0; j < numbers.length; j++) {
            if (map.containsKey(target - numbers[j])) {
                res[1] = j;
                res[0] = map.get(target - numbers[j]);

                // members[] 存在重复元素，那么Map只会存入后面一个（题目中保证只存在一组符合条件的索引，所以重复元素数量只能为2）
                // 所以如果最后数组中的索引是相同的，res[0]--
                if (res[0] == res[1]) {
                    res[0]--;
                }
            }
        }


        return res;

    }

    public static void main(String[] args) {
        Test3 test = new Test3();
        int[] numbers = {0, 0, 3, 4};
        int target = 0;
        int[] ints = test.twoSum(numbers, target);
        System.out.println(Arrays.toString(ints));
    }
}
