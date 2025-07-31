/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node == null) return null;
        Queue<Node> q = new LinkedList<>();
        Map<Node, Node> visited = new HashMap<>();
        // Node first = new Node(node.val, new ArrayList<>());
        // visited.put(node, first);
        q.offer(node);
        while(!q.isEmpty()){
            Node current = q.poll();
            // Node clonedCurrent = visited.get(current);
            if(!visited.containsKey(current)){
            Node clonedCurrent = new Node(current.val, new ArrayList<>());
            visited.put(current, clonedCurrent);
            }
            Node clonedCurrent = visited.get(current);
            for(Node neighbor : current.neighbors){
                if(!visited.containsKey(neighbor)){
                    Node clonedNeighbor = new Node(neighbor.val, new ArrayList<>());
                    visited.put(neighbor, clonedNeighbor);
                    q.offer(neighbor);
                }
                Node clonedNeighbor = visited.get(neighbor);
                clonedCurrent.neighbors.add(clonedNeighbor);
            }
        }
    return visited.get(node);  
    }
}