package algorithm_ZJU.tree;

import java.util.Arrays;

/**
 * @author kkddyz
 * @date 2021/11/29
 * @description 最大堆
 */
public class MaxHeap {
    int size;
    int capacity;
    int[] elements;

    /**
     * 创建最大堆
     */
    public MaxHeap(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        // 数组的0位置不放元素，root从1开始
        elements = new int[capacity + 1];
    }

    public boolean isEmpty(){
        return size == 0;
    }
    public MaxHeap(int capacity, int[] arr) {
        // arr长度len,说明元素数量size = len-1
        // capacity 最大元素个数 = elements.len - 1
        this.capacity = capacity;
        this.size = arr.length - 1;
        elements = Arrays.copyOf(arr, capacity + 1);
        sort(elements, elements[1]);
    }

    /**
     * 调整rootIndex为根的树
     */
    private void sort(int[] elements, int rootIndex) {
        // 调整左子树
        if (rootIndex * 2 <= size) {
            sort(elements, rootIndex * 2);
        }

        // 调整右子树
        if (rootIndex * 2 + 1 <= size) {
            sort(elements, rootIndex * 2 + 1);
        }

        // 与删除不同，temp就是自己
        int temp = elements[rootIndex];

        // 调整自己：向下过滤rootIndex
        int parent, child;
        for (parent = rootIndex; parent * 2 <= size/*保证parent有child*/; parent = child) {

            // child指向较大的子节点
            child = parent * 2;
            if (child + 1 <= size && elements[child + 1] > elements[child]) {
                child++;
            }

            // space = max(elements[child],temp) || space == parent
            if (elements[child] > temp) {
                elements[parent] = elements[child];
            } else {
                break;
            }
        }

        // 循环结束，填入temp
        elements[parent] = temp;
    }


    /**
     * 插入数据
     */
    void insert(int item) {  // item是要插入最大堆的元素

        // heap满了
        if (size == capacity) {
            throw new IllegalStateException("堆栈满了");
        }

        int i = size++; // 指向数组的最后一个元素(index=0不放元素)，模拟树的新插入结点


        // 如果父节点小于item，向下移动到space
        for (; elements[i / 2] < item; i /= 2) {
            elements[i] = elements[i / 2];
        }

        // 移动结束后i依旧指向space,填入item即可
        elements[i] = item;
    }

    /**
     * 返回最大值
     */
    int remove() {
        if (size == 0) {
            throw new IllegalStateException("堆栈为空");
        }


        int maxItem = elements[1]; //  取出根节点最大值
        int temp = elements[size--]; // temp是堆中最后一个元素

        int parent, child;
        // parent 指向 space
        for (parent = 1; parent * 2 <= size/*确保parent有child*/; parent = child/*space从parent移动到child*/) {

            // child指向parent的最大子节点
            child = parent * 2;
            if (child != size && elements[child] < elements[child + 1]) {
                child++; // child指向较大的左右子节点
            }

            // space = max(elements[child],temp)
            if (elements[child] > temp) {
                elements[parent] = elements[child];
            } else {
                // 循环结束
                break;
            }
        }

        elements[parent] = temp;

        // 返回最大值
        return maxItem;
    }

    public static void main(String[] args) {
        //// 第一个不存数据
        //int[] arr = {-1,1,2,3,7,6,5};
        //MaxHeap maxHeap = new MaxHeap(10,arr);
        //
        //while (!maxHeap.isEmpty()){
        //    System.out.println(maxHeap.remove());
        //}

        MaxHeap maxHeap = new MaxHeap(10);
        for (int i = 1; i < 10; i++) {
            maxHeap.insert(i);
        }

        while (!maxHeap.isEmpty()){
            System.out.println(maxHeap.remove());
        }
    }
}
