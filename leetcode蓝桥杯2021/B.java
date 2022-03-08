package leetcode蓝桥杯2021;

/**
 * @author kkddyz
 * @date 2022/2/23
 * @description
 */
/*
基本思路 ：

从1开始枚举，记录需要的卡片数量，当超过2021时停止。

使用数组cnt记录当前卡片数量。

枚举到的数字 n 可以使用%+/算出每一位数字

现在小蓝手里有 0 到 9 的卡片各 2021 张，共 20210 张，请问小蓝可以从 1 拼到多少？
 */
public class B {

    public static void main(String[] args) {

        int[] cnt = new int[10];
        for (int i = 0; i < 10; i++) {
            cnt[i] = 2021;
        }


        //

        for (int j = 1; true; j++) {

            // 获取当前数字的各位数字

            int[] nums = getNums(j);

            // 从cnt中减去nums需要的数字，如果出现cnt出现负数 返回 j-1

            for (int i = 0; i < nums.length; i++) {
                int num = nums[i];
                cnt[num]--;

                if (cnt[num] < 0) {
                    System.out.println(j - 1);
                    return;
                }
            }
        }
    }

    private static int[] getNums(int j) {

        String s = j + "";
        int[] nums = new int[s.length()];

        for (int i = 0; i < nums.length; i++) {
            nums[i] = s.charAt(i) - '0';
        }

        return nums;
    }


}
