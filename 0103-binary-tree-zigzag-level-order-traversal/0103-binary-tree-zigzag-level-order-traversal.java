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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null){
            return result;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        boolean order = true;
        while(!q.isEmpty()){
            List<Integer> values = new ArrayList<>();
            int numNodes = q.size();
            for(int i = 0; i < numNodes; i++){
                TreeNode node = q.poll();
                if(order == true)
                values.add(node.val);
                else
                values.addFirst(node.val);
                if(node.left != null)
                q.add(node.left);
                if(node.right != null)
                q.add(node.right);
            }
            result.add(values);
            order = !order;
        }
    return result;
    }
}