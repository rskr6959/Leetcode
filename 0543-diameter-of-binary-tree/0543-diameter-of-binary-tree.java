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
    private int diameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null)
        return 0;
        dfs(root);
        return diameter;
    }
    public int dfs(TreeNode node){
        if(node.left == null && node.right == null)
        return 0;
        int ht = 0;
        int dia = 0;
        if(node.left != null){
            int leftHt = 1 + dfs(node.left);
            dia = leftHt;
            ht = Math.max(leftHt, ht);
        }
        if(node.right != null){
            int rightHt = 1 + dfs(node.right);
            dia = dia + rightHt;
            ht = Math.max(rightHt, ht);
        }
        diameter = Math.max(dia, diameter);
        return ht;
    }
}