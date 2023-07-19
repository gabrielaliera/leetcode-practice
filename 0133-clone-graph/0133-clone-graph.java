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
    
     HashMap<Node, Node> map = new HashMap<>();
    
    public Node cloneGraph(Node node) {
        
        if( node == null){
             return null;
        }
        //Step 1: Create a new node with the same data as original root
        Node cloneNode = new Node(node.val , new ArrayList());
        
        //Step2: Add to hashmap <Originial, clone>
        map.put(node, cloneNode);
        
        //Step 3: ITernate through neighbors of root node
        for(Node cur : node.neighbors){
                       
            if(!map.containsKey(cur)){
                cloneNode.neighbors.add( cloneGraph(cur) );
            } else {
                
                cloneNode.neighbors.add( map.get(cur));
            }
        }
        
        return cloneNode;
    }
}