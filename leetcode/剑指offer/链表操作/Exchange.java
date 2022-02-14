package leetcode.剑指offer.链表操作;

/**
 * @author kkddyz
 * @date 2021/12/1
 * @description
 */
public class Exchange {
    private static void swap(int[] arr,int a,int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
    // 类似于快排 左边通过i维护一个奇数数组[0,i-1]奇数数组
    public static int[] exchange(int[] nums) {  
        for (int i = 0,j = 0; j < nums.length; j++) {
            // 如果搜索到奇数 swap(i,j)
            if (nums[j] % 2 == 1){
                swap(nums,i,j);
                i++;
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        int[] ints = exchange(arr);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }

}
