/*
U:
input - array of array
   inner array can be different lenghts
   wall min is 1 row
   
  Output: min of brick cross
  
 M:
   hashmap - freq of edgges ( edge num : count)
   max heap - add edges ( parin)
   
   
 Plan
   
   1) calculate brick end at each row
   2) find max edges
   3) row - edges = min number of crossed bricks
*/
class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        
        HashMap<Integer,Integer> edges = new HashMap<>();
        
        //Iterate through wall
        for(List<Integer> row : wall){
            
            int edgeSum = 0;
            
            //iterate through bricks but not last one
            for(int brick = 0; brick < row.size() - 1; brick++){
                edgeSum += row.get(brick);
                edges.put(edgeSum, edges.getOrDefault(edgeSum, 0) + 1);
                     
            }
        }
        
        //Find max edge that meet up
        int maxCrossed = 0;
        for(int crossed: edges.values()){
            maxCrossed = Math.max(maxCrossed, crossed);
        }
      
        
        return wall.size() - maxCrossed;
    }
}