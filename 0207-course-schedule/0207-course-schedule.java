class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //Build adj list
        HashMap<Integer, Set<Integer>> adj = new HashMap<>();
        
        for(int i= 0; i < numCourses ; i++){
            adj.put(i, new HashSet<>());
        }
        
        for(int[] course : prerequisites){
            adj.get(course[0]).add(course[1]);
        }
        
        boolean[] visited = new boolean[numCourses];
        boolean[] inStack = new boolean[numCourses];        
        for (int i = 0; i < numCourses; i++) {
            if (dfs(adj, visited, i, inStack)) {
                return false;
            }
        }
        
        
        return true;
    }
    
    public boolean dfs(HashMap<Integer, Set<Integer>> adj, boolean[] visited, int node, boolean[] inStack){
        
         // If the node is already in the stack, we have a cycle.
        if (inStack[node]) {
            return true;
        }
        if (visited[node]) {
            return false;
        }
        // Mark the current node as visited and part of current recursion stack.
        visited[node] = true;
        inStack[node] = true;
        
        for (int neighbor : adj.get(node)) {
            if (dfs(adj, visited, neighbor, inStack)) {
                return true;
            }
        }
        // Remove the node from the stack.
        inStack[node] = false;
        return false;
        
    }
}