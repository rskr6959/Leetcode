/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null)
        return result;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int numNodes = q.size();
            List<Integer> values = new ArrayList<>();
            for(int i = 0; i < numNodes ; i++){
                Node node = q.poll();
                values.add(node.val);
                for(Node child : node.children){
                    q.add(child);
                }
            }
            result.add(values);
        }
    return result;
    }
}