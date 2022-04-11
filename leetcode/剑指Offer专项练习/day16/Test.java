package leetcode.剑指Offer专项练习.day16;

import leetcode.剑指Offer专项练习.util.TreeNode;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int pathSum(TreeNode root, int sum) {
        // key是前缀和, value是大小为key的前缀和出现的次数
        Map<Integer, Integer> prefixSumCount = new HashMap<>();
        // 前缀和为0的一条路径
        prefixSumCount.put(0, 1);
        // 前缀和的递归回溯思路
        return recursionPathSum(root, prefixSumCount, sum, 0);
    }

    /**
     * 前缀和的递归回溯思路
     * 从当前节点反推到根节点(反推比较好理解，正向其实也只有一条)，有且仅有一条路径，因为这是一棵树
     * 如果此前有和为currSum-target,而当前的和又为currSum,两者的差就肯定为target了
     * 所以前缀和对于当前路径来说是唯一的，当前记录的前缀和，在回溯结束，回到本层时去除，保证其不影响其他分支的结果
     *
     * @param node           树节点
     * @param map 前缀和Map
     * @param target         目标值
     * @param currSum        当前路径和(父节点的前缀和)
     * @return 满足题意的解
     */
    private int recursionPathSum(TreeNode node, Map<Integer, Integer> map, int target, int currSum) {
        // 1.递归终止条件
        if (node == null) {
            return 0;
        }
        // 2.该节点要做的事情
        int res = 0;
        // 当前路径上的和
        currSum += node.val;

        //---核心代码
        // 看看root到当前节点这条路上是否存在节点前缀和加target为currSum的路径
        // 当前节点->root节点反推，有且仅有一条路径，如果此前有和为currSum-target,而当前的和又为currSum,两者的差就肯定为target了
        // currSum-target相当于找路径的起点，起点的sum+target=currSum，当前点到起点的距离就是target
        res += map.getOrDefault(currSum - target, 0);
        // 更新路径上当前节点前缀和的个数
        map.put(currSum, map.getOrDefault(currSum, 0) + 1);
        //---核心代码

        // 3.递归子节点
        res += recursionPathSum(node.left, map, target, currSum);
        res += recursionPathSum(node.right, map, target, currSum);

        // 4.退出该节点之前，去除当前节点的前缀和数量
        map.put(currSum, map.get(currSum) - 1);
        return res;
    }


    public static void main(String[] args) {
        String s = "10,5,3,3,None,None,-2,None,None,2,None,1,None,None,-3,None,11,None,None,";
        TreeNode root = TreeNode.deserialize(s);
        Solution solution = new Solution();
        solution.pathSum(root,0);


    }
}

