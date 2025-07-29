/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null){
            return false;
        }
        boolean[] flag = new boolean[1];
        dfs(root, targetSum, flag);
        return flag[0];
    }
    private void dfs(TreeNode node, int target, boolean[] flag)
    {
        target = target - node.val;
        if(node.left == null && node.right == null){
            if(target == 0)
            flag[0] = true;
        }
        if(node.left != null)
        dfs(node.left, target, flag);
        if(node.right != null)
        dfs(node.right, target, flag);
    }
    }
