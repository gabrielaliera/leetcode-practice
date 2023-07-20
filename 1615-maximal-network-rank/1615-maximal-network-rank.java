/*
1 .Use a hashtable of size n which stores sets for each city.
Members of the sets are cities which are directly connected to the city the set corresponds to. 
2. Then, examine all unique pairs (city_1, city_2) and sum up the edges of both cities. 
3.//If there is an edge between both cities, 
    //the sum needs to be reduced by one since the edge is counted twice.
//We store the highest sum of edges and return it.


*/
class Solution {
        
    public int maximalNetworkRank(int n, int[][] roads) {
       
        //Build graph- adj list
        Map<Integer, Set<Integer>> adj = new HashMap<>();
        
        //Build intitial map with empty roads
        for(int i= 0; i < n ; i++){
            adj.put(i, new HashSet<>());
        }
        for(int[] road : roads){
            int cityA = road[0];
            int cityB = road[1];
            
            adj.get(cityA).add(cityB);
            adj.get(cityB).add(cityA);
           
        }
        
        //Calcuate the maximal network ranks by trying all possible pairs of ciites
        int maxNetworkRank = 0;
        
         for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                 int cityA = i;
                 int cityB = j;
                
                 int networkRank = 0;
                
                int roadsInA = adj.get(cityA).size(); //The amount of roads connected to cityA
                int roadsInB = adj.get(cityB).size(); //The amount of raods connected to cityB
                
                if(adj.get(cityA).contains(cityB)){ //IF citys connect, minus the duplicated road
                    networkRank = roadsInA + roadsInB - 1; 
                } else {
                    networkRank = roadsInA + roadsInB;
                }
                
                maxNetworkRank = Math.max(maxNetworkRank, networkRank);
            }    
        }
        return maxNetworkRank;
    }
}