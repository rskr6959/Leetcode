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
    public int widthOfBinaryTree(TreeNode root) {
        if(root == null){
            return 0;
        }
        int maxWidth = 0;
        Deque<AnnotatedNode> q = new ArrayDeque<>();
        q.offer(new AnnotatedNode(root, 1));
        while(!q.isEmpty()){
            int first = 0;
            int last = 0;
            int numNodes = q.size();
            for(int i = 0; i < numNodes; i++){
                AnnotatedNode an = q.poll();
                TreeNode node = an.node;
                int id = an.index;
                last = id;
                if(i == 0)
                first = id;
                if(node.left != null)
                q.offer(new AnnotatedNode(node.left, 2 * id));
                if(node.right != null)
                q.offer(new AnnotatedNode(node.right, 2 * id + 1));
            }
        maxWidth = Math.max(maxWidth, last - first + 1);
        }
    return maxWidth;
    }
    private static class AnnotatedNode {
        final TreeNode node;
        final int index;
        AnnotatedNode(TreeNode node, int index) {
            this.node  = node;
            this.index = index;
        }
    }
}