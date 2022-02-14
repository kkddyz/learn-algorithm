package leetcode.剑指offer.第四天查找;

import java.util.Arrays;
import java.util.Random;

/**
 * @author kkddyz
 * @date 2021/11/25
 * @description
 */
public class RandomArr {
    /**
     * 在 [0,range-1]范围内生成长度len的数组
     */
    public int[] getRandomArr(int len,int range){
        // 初始化随机数组
        int[] randomArr = new int[len];
        Random r = new Random();

        for (int i = 0; i < len; i++) {
            randomArr[i] = r.nextInt(range);
        }

        return randomArr;
    }

    public static void main(String[] args) {
        int[] randomArr = new RandomArr().getRandomArr(3, 2);
        System.out.println(Arrays.toString(randomArr));

    }
}
