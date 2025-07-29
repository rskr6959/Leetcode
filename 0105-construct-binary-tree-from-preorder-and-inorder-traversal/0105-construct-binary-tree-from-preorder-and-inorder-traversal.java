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
    HashMap<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i = 0; i < inorder.length ; i++){
        map.put(inorder[i], i);
    }
        return helper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
        
    }
    public TreeNode helper(int[] preorder, int startP, int endP,int[] inorder, int startI, int endI){
        if(startP > endP)
        return null;
        if(startP == endP)
        return new TreeNode(preorder[startP]);
        TreeNode rootNode = new TreeNode(preorder[startP]);
        int rootIndex = map.get(preorder[startP]);
        int numLeft = rootIndex - startI;
        int numRight = endI - rootIndex;
        rootNode.left = helper(preorder, startP+1, startP + numLeft, inorder, startI, rootIndex - 1);
        rootNode.right = helper(preorder, startP + numLeft + 1, endP, inorder, rootIndex + 1, endI);
        return rootNode;
    }
}