import java.util.Queue;
import java.util.HashMap;

class Solution {
    //BFS
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        //Create a hasmap to store edges
        HashMap<Integer,List<Integer>> graph = new HashMap<>();
        
        for(int[] edge : edges){
            int a = edge[0];
            int b = edge[1];
            
            graph.computeIfAbsent(a, val -> new ArrayList<Integer>()).add(b);
            graph.computeIfAbsent(b, val -> new ArrayList<Integer>()).add(a);
        }
        
      
         boolean[] seen = new boolean[n];
        seen[source] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(source);
        
        while(!queue.isEmpty()){
            int node = queue.poll();
            
            if(node == destination){
                return true;
            }
            
            for(int nextNode : graph.get(node)){
                if(!seen[nextNode]){
                    seen[nextNode] = true;
                    queue.add(nextNode);
                }
            }
        }
        
        return false;
        
        
        //DFs
        
    }
    //DFS
//      public boolean validPath(int n, int[][] edges, int source, int destination) {
//         int i = 0;
//         int j = 0;
        
        
//     }
}