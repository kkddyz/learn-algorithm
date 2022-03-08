package leetcode蓝桥杯2021;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kkddyz
 * @date 2022/2/23
 * @description
 */
/*
在平面直角坐标系中，两点可以确定一条直线。如果有多点在一条直线上， 那么这些点中任意两点确定的直线是同一条。

给定平面上 2 × 3 个整点 {(x, y)|0 ≤ x < 2, 0 ≤ y < 3, x ∈ Z, y ∈ Z}，
即横坐标 是 0 到 1 (包含 0 和 1) 之间的整数、纵坐标是 0 到 2 (包含 0 和 2) 之间的整数 的点。
这些点一共确定了 11 条不同的直线。

给定平面上 20 × 21 个整点 {(x, y)|0 ≤ x < 20, 0 ≤ y < 21, x ∈ Z, y ∈ Z}，
即横 坐标是 0 到 19 (包含 0 和 19) 之间的整数、纵坐标是 0 到 20 (包含 0 和 20) 之 间的整数的点。
请问这些点一共确定了多少条不同的直线。
 */
public class C {

    public static void main(String[] args) {

        Long n = 2021041820210418L;
        List<Long> list = new ArrayList<>();

        // 求出所有因子 放入HashMap
        for (long i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                list.add(i);
                list.add(n / i);
            }
        }

        list.sort(Long::compare);

        // 从中寻找3个数

        int cnt = 0;
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.size(); j++) {
                for (int k = 0; k < list.size(); k++) {
                    if (list.get(i) * list.get(j) * list.get(k) == n) {
                        cnt++;
                    }
                }
            }
        }

        System.out.println(cnt);


    }
}
