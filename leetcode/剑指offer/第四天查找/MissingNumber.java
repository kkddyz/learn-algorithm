package leetcode.剑指offer.第四天查找;

/**
 * @author kkddyz
 * @date 2021/11/25
 * @description
 */
public class MissingNumber {

    /**
     *
     * 由于查找的对象是缺失的元素，我们需要在进行2分查找前保证：该元素在[left,right范围内]
     * - 0缺失：{1},{1,2}
     * - n缺失{0}{0,1}
     * 这时由于目标元素在数组中不存在，所以最终会导致left > right
     *
     * 否则
     * @param nums
     * @return
     */
    public int missingNumber(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int mid;
        while (left <= right) {
            mid = (left + right) / 2;
            if (nums[mid] == mid) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }

        }
        return left;
    }


    public static void main(String[] args) {
        // 特殊用例
        int[] arr1 = {0,1};
        MissingNumber s = new MissingNumber();
        System.out.println(s.missingNumber(arr1));
    }
}
