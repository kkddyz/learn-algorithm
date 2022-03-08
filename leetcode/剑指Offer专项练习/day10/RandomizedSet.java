package leetcode.剑指Offer专项练习.day10;

import java.util.*;

/**
 * @author kkddyz
 * @date 2022/2/15
 * @description
 */
public class RandomizedSet {

    private List<Integer> list;
    private Map<Integer, Integer> dict;


    public RandomizedSet() {
        list = new ArrayList<>();
        dict = new HashMap<>();
    }

    public boolean insert(int val) {

        // 如果该元素已经存在
        if (dict.containsKey(val)) {
            return false;
        }

        // 先加入map,因为如果先加入list,size会增大
        dict.put(val, list.size());
        //新元素置于list末尾
        list.add(list.size(), val);

        return true;
    }

    public boolean remove(int val) {

        // 确保元素存在

        if (!dict.containsKey(val)) {
            return false;
        }


        // 如果不交换,之后元素的下标会自动前移,这样与Map就对不上了
        Integer removeIndex = dict.get(val); // 删除元素的下标
        Integer swapVal = list.get(list.size() - 1); // 用于交换的元素的值

        // 在list中将删除元素与swapElement交换,并删除末尾元素
        list.set(removeIndex, swapVal);
        list.remove(list.size() - 1);



        // 更新map:删除val,修改swapVal的下标为删除元素下标removeIndex
        dict.put(swapVal, removeIndex); // put在remove之前,否则如果只有一个元素,先删除后put会导致没有删掉
        dict.remove(val);


        return true;
    }

    public int getRandom() {
        Random r = new Random();
        return list.get(r.nextInt(list.size()));
    }

    public static void main(String[] args) {
        RandomizedSet randomizedSet = new RandomizedSet();
        randomizedSet.insert(-1);
        randomizedSet.remove(-2);
        randomizedSet.insert(-2);
        randomizedSet.remove(-1);
        randomizedSet.insert(-2);

    }
}
