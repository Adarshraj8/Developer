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
    HashMap<Node,Node> map = new HashMap<>();
    public Node cloneGraph(Node node) {
        
        if(node==null) return null;
       //already cloned return copy
        if(map.containsKey(node))
        return map.get(node);
        // Line C: Create brand-new copy & save in map BEFORE visiting neighbors
        Node cloneNode = new Node(node.val);
        map.put(node,cloneNode);
       
       //loop through original neighbour and attach their clones
       for(Node neighbor:node.neighbors){
        Node clonedNeighbors = cloneGraph(neighbor);
        cloneNode.neighbors.add(clonedNeighbors);
       }
      return cloneNode;
    }
}