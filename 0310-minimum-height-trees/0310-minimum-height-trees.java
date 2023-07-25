/*
Tree - no cycles

Height - distance from roots

Output: the root node with the MHT


*/


class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
    
      List<Integer> res = new ArrayList<>();
  
      if(n <= 0) return res;
      if (n == 1){
        res.add(0);
        return res;
      }
  
        int degree[] = new int[n];
        List<Set<Integer>> adj = new ArrayList<>(n);
        for (int i = 0; i < n; ++i) adj.add(new HashSet<>());
        for (int[] edge : edges) {
          degree[edge[0]]++;
          degree[edge[1]]++;
          adj.get(edge[0]).add(edge[1]);
          adj.get(edge[1]).add(edge[0]);
        }

        Queue<Integer> q = new LinkedList<>();

        for(int i= 0; i< n; i++){
          if (degree[i] == 1){
            q.add(i);
          }
        }

        while (n > 2) {
          int size = q.size();  
          n -= size;
            while(size-- > 0){
              int v = q.poll();
              for(int i : adj.get(v)){
                degree[i] --;
                if(degree[i] == 1){
                  q.add(i);
                }
              }
            }
        }
        res.addAll(q);
        return res;
    }
    
   public List<Integer> findMinHeightTrees2(int n, int[][] edges) {
    if (n == 1) return Collections.singletonList(0);

    List<Set<Integer>> adj = new ArrayList<>(n);
    for (int i = 0; i < n; ++i) adj.add(new HashSet<>());
    for (int[] edge : edges) {
        adj.get(edge[0]).add(edge[1]);
        adj.get(edge[1]).add(edge[0]);
    }

    List<Integer> leaves = new ArrayList<>();
    for (int i = 0; i < n; ++i)
        if (adj.get(i).size() == 1) leaves.add(i);

    while (n > 2) {
        n -= leaves.size();
        List<Integer> newLeaves = new ArrayList<>();
        for (int i : leaves) {
            int j = adj.get(i).iterator().next();
            adj.get(j).remove(i);
            if (adj.get(j).size() == 1) newLeaves.add(j);
        }
        leaves = newLeaves;
    }
    return leaves;
    }
}