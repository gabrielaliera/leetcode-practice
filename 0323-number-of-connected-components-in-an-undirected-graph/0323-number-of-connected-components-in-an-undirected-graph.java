/*
HashSet
Plan
Adj List
   0 : 1
   1 : 0 2
   2 : 1
   3 : 4
   4 : 3
   
  
   
*/

class Solution {
    
    
    
    public int countComponents(int n, int[][] edges) {
        
        //Step 1: Build graph
        HashMap<Integer, Set<Integer>> adj = new HashMap<>();
        
        //Create adj with empty sets
        for(int i = 0; i < n ; i++){
            adj.put(i , new HashSet<>());
        }
        
        //Add edges to adj 
        for(int[] edge : edges){
            int nodeA = edge[0];
            int nodeB = edge[1];
            
            adj.get(nodeA).add(nodeB);
            adj.get(nodeB).add(nodeA);           
        }
        
        //Step 2: Calculate number of components usign dfs -
        //dfs will change all connected nodes to visited 
        //Once dfs ends, if visited is false again, means a new component
        boolean [] visited = new boolean[n];
           
        int count=0;
          for(int i = 0; i < n; i++){
              if(visited[i] == false) {
                // apply dfs
                dfs(adj, visited, i);
                count++;
              }
          }
         return count;
    }
    
     // use dfs to traverse the graph to see if all the nodes can be covered
      private void dfs(HashMap<Integer, Set<Integer>> adj, boolean[] visited, int s){
          //Add node to visited
          visited[s] = true;
          
          for(int neighbor : adj.get(s)){
              if(visited[neighbor] == false){
                  dfs(adj,visited, neighbor);
              }
          }
      }
}