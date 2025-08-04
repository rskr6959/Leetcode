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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode newNode = new TreeNode(val);
        TreeNode curr = root;
        TreeNode prev = curr;
        if (root == null)
        return newNode;
        while(curr != null){
            if(val < curr.val){
            prev = curr;
            curr = curr.left;
            }
            else{
            prev = curr;
            curr = curr.right;
            }
        }
        if (val < prev.val)
        prev.left = newNode;
        else
        prev.right = newNode;
    return root;
    }
}