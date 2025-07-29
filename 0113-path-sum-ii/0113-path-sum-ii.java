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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
    List<List<Integer>> result = new ArrayList<>();
    if(root == null)
    return result;
    List<Integer> slate = new ArrayList<>();
    dfs(root, targetSum, slate, result);
    return result;        
    }
    private void dfs(TreeNode node, int target, List<Integer> slate, List<List<Integer>> result)
    {
        slate.add(node.val);
        target = target - node.val;
        if(node.left == null && node.right == null){
            if(target == 0)
            result.add(new ArrayList<>(slate));
        }
        if(node.left != null)
        dfs(node.left, target, slate, result);
        if(node.right != null)
        dfs(node.right, target, slate, result);
        slate.remove(slate.size() - 1);
    }
}

