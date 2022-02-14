package leetcode.剑指offer.day5;

/**
 * @author kkddyz
 * @date 2021/11/27
 * @description 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如，数组[3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。
 */
public class MinArray {
    public int minArray(int[] numbers) {


        int left = 0;
        int right = numbers.length - 1;
        // 如果逆序的数量取0，不存在numbers[left] >= numbers[right]
        if (numbers[left] < numbers[right]) {
            return numbers[left];
        }
        int mid;
        while (left <= right) {
            mid = (left + right) / 2;

            // 检查逆序是否存在

            // mid要么比left大，要么比right小
            // numbers[mid] >= numbers[left] >= numbers[right]
            if (numbers[mid] >= numbers[left]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println("left:"+left);
        System.out.println("right:"+right);
        // 收缩的本质：维持一个表达式关系的前提下，缩小范围
        // 逆序导致 arr[left] > left[right]
        // mid的本质：随机选择的元素替换left,right使得原有的表达式不变。

        // 当循环结束 表达式不成立 即有 arr[left] < left[right]

        return numbers[left];
    }

    public static void main(String[] args) {
        int[] arr = {2,2,2,0,1};
        MinArray s = new MinArray();
        s.minArray(arr);
    }
}
