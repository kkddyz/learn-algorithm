package leetcode.dp;

/**
 * @author kkddyz
 * @date 2021/12/10
 * @description
 */
public class CanJump {

    /**
     * 跳跃游戏1.0 解法1
     */
    public static boolean canJump1(int[] nums) {

        // 递推的基础是，如果 一个位置所有可能到他的前置位置都不可达那么，它就不可达。否则就是ture
        boolean[] dp = new boolean[nums.length];
        dp[0] = true;

        // 如果不实记录每个节点的前置，那就需要遍历全部i 算法复杂度 O(N^2)
        for (int i = 1; i < nums.length; i++) {
            //遍历所有前置位,并且j可以到达i

            for (int j = i - 1; j >= 0; j--) {
                if (j + nums[j] >= i && dp[j]) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[nums.length - 1];
    }

    /**
     * 使用BFS的思路改良,剪枝
     * 当BFS遍历结束后，从邻接点中使得maxLen最大的位置开始
     */
    public static boolean canJump3(int[] nums) {
        boolean[] accessible = new boolean[nums.length];
        accessible[0] = true;
        int next;
        // 遍历所有结点i 终点不需要遍历 循环结束条件是 1，到终点 i == len -1 2.进行BFS的结点没有邻接点，即nums[i] == 0
        for (int i = 0; i < nums.length- 1; i = next) {

            // 没有邻接点 BFS被迫结束(重点在另一颗树中)
            if (nums[i] == 0){
                break;
            }
            // 下一次BFS起点
            next = i + nums[i];

            // 遍历i的每一个相连结点j
            for (int j = i + nums[i]; j > i; j--) {
                // 保证j < nums.length 跳数++
                if (j < nums.length && !accessible[j]) { // 未到达
                    accessible[j] = true;
                }
            }
        }

        return accessible[nums.length - 1];
    }

    /**
     * 跳跃游戏1.0 解法2 贪心
     */
    public static boolean canJump2(int[] nums) {
        int maxLen = 0;

        for (int i = 0; i < nums.length; i++) {
            // 保证i可达，才能通过i跟新maxLen
            if (i <= maxLen && i + nums[i] > maxLen) {
                maxLen = i + nums[i];
            }
        }
        // maxLen代表最大可达下标
        return maxLen >= nums.length - 1;
    }

    /**
     * 一定可达，求最小跳数
     */
    public static int jump(int[] nums) {
        int[] step = new int[nums.length];

        // 遍历所有结点i
        for (int i = 0; i < nums.length; i++) {
            // 遍历每一个相连结点j 保证j < nums.length
            for (int j = i + nums[i]; j > i; j--) {
                // 跳数++
                if (j < nums.length && step[j] == 0) { // 未到达
                    step[j] = step[i] + 1;
                }
            }
        }

        return step[nums.length - 1];
    }


    /**
     * 效率低的原因：重复访问已经访问过的结点(类似于重复子结构)
     * <p>
     * 剪枝处理 对于i BFS所有邻接点j, 此时 [i.j]都遍历过了 i应该从j开始BFS
     */
    public static int jump1(int[] nums) {
        int[] step = new int[nums.length];
        int next;
        // 遍历所有结点i
        for (int i = 0; i < nums.length; i = next) {
            // 下一次BFS的起点
            next = i + nums[i];
            // 遍历每一个相连结点j 保证j < nums.length
            for (int j = i + nums[i]; j > i; j--) {
                // 跳数++
                if (j < nums.length && step[j] == 0) { // 未到达
                    step[j] = step[i] + 1;
                }
            }
        }

        return step[nums.length - 1];
    }


    public static void main(String[] args) {
        int[] arr = {2,5,0,0};
        System.out.println(canJump3(arr));
    }
}

