package leetcode.剑指offer.第四天查找;

/**
 * @author kkddyz
 * @date 2021/11/25
 * @description
 */
public class Search {
    /**
     * @return target在数组中出现的某个下标
     */
    private int findTargetStart(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int mid = (start + end) / 2;

        // 遍历2分
        while (start <= end) {
            // 检查mid
            if (nums[mid] == target) {
                // 刚好找到了就结束循环
                break;
            } else {
                // 如果没有找到 收缩 start，end，更新mid
                if (target > nums[mid]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
                mid = (start + end) / 2;
            }
        }

        if (start > end) {
            // 没找到
            return -1;
        } else {
            return mid;
        }
    }

    public int search(int[] nums, int target) {
        int targetStart = findTargetStart(nums, target);
        int beforeCount = 0;
        int afterCount = 0;


        if (targetStart == -1) {
            return 0;
        } else {
            // 统计前后出现的次数

            for (int i = targetStart + 1; i < nums.length && nums[i] == target; i++) {
                afterCount++;
            }

            for (int i = targetStart - 1; i >= 0 && nums[i] == target; i--) {
                beforeCount++;

            }
        }

        return beforeCount + afterCount + 1;
    }
}
