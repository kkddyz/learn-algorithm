package algorithm_ZJU.tree.heap;

/**
 * @author kkddyz
 * @date 2022/9/23
 * @description 最大堆
 */
public class MaxHeap {

    // 当前数中元素个数
    private int size;

    // 容量 : 元素最大个数
    private int cap;

    private int[] arr;

    public MaxHeap(int cap) {
        size = 0;
        this.cap = cap;
        // index=0 不存数据
        arr = new int[cap + 1];
    }

    public boolean isFull() {
        return size == cap;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 插入元素
     * 初始 size = 0,cap,插入位置在size+1
     * space指向空位
     */
    public void insert(int val) {

        if (size + 1 > cap) {
            return;
        }

        int space = ++size;

        // 1. 将小于val的元素向下移动到空位 （space/2最小是1）
        // arr[space/2] ==> parent
        // arr[space] ==> child
        while (space / 2 >= 1 && arr[space / 2] < val) {
            arr[space] = arr[space / 2];
            space /= 2;
        }

        // 移动结束后 arr[space/2] >= val 空位处填入新结点
        arr[space] = val;
    }

    /**
     * 返回最大值
     */
    public int remove() {
        int maxVal = arr[1];

        if (!isEmpty()) {

            // 将val移动到root位置
            int val = arr[size--];
            int space = 1;
            // space向下沉到正确的位置(其他元素的位置都正确)
            // 在空位的左右子节点中选择较大的移动到空位,直到space大于子节点

            while (space * 2 + 1 <= size && val < Math.max(arr[space * 2], arr[space * 2 + 1])) {

                // 左结点更大，将左节点移动到space
                if (arr[space * 2] > arr[space * 2 + 1]) {
                    arr[space] = arr[space * 2];
                    space = space * 2;
                } else {
                    arr[space] = arr[space * 2 + 1];
                    space = space * 2 + 1;
                }
            }

            // 位置调整好后 填入val
            arr[space] = val;
        }
        return maxVal;
    }

    public static void main(String[] args) {
        MaxHeap maxHeap = new MaxHeap(10);

        maxHeap.insert(8);
        maxHeap.insert(9);
        maxHeap.insert(2);
        maxHeap.insert(1);
        maxHeap.insert(7);
        maxHeap.insert(3);
        maxHeap.insert(6);
        maxHeap.insert(4);
        maxHeap.insert(5);

        while (!maxHeap.isEmpty()) {
            int i = maxHeap.remove();
            System.out.println(i);
        }
    }

}
