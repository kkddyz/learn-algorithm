package leetcode.sort;

import java.util.Arrays;

/**
 * @author kkddyz
 * @date 2022/3/22
 * @description
 */
public class SortAPI {


    public static void main(String[] args) {

        // 使用Arrays.sort()对数组排序
        int[] nums = {1, 3, 5, 4, 8};

        // 由于compareTo比较的是两个对象，因此必须将int[]转换成Integer[]

        // mapToObj需要一个IntFunction,用于将创建指定长度的数组
        Integer[] integers = Arrays.stream(nums).boxed().toArray(Integer[]::new);

        // 使用sort进行快排
        Arrays.sort(integers, (a, b) -> b - a);

        // 将Integer[] -> int[],参数是Integer,方法体是从integer中获取对应的int
        int[] ints = Arrays.stream(integers).mapToInt(Integer::intValue).toArray();
        System.out.println(Arrays.toString(ints));
    }

}
