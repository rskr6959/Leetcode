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
    public int maxDepth(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int level = 0;
        if(root == null)
        return 0;
        while(!q.isEmpty()){
            level = level + 1;
            int numNodes = q.size();
            for(int i = 0; i < numNodes; i++){
                TreeNode node = q.poll();
                if(node.left != null){
                    q.add(node.left);
                }
                if(node.right != null)
                q.add(node.right);
            }
        }
        return level;
    }
}