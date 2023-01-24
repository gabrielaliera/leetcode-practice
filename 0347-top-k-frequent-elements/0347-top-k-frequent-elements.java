/*

Already sort?


HashMap - count frequencies
how to hold top frequencies- stack - 

for num in array
  add num to map or increment value

iterate again map entry set
   stack push max
  if top > freg
    pop and push
    
    
----- 2nd hashmap  


*/


class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        //num, count
        HashMap<Integer, Integer> map = new HashMap<>();
        
        //Add Freq to hashmap
        for(int num : nums){
            if (map.containsKey(num)){
                map.put(num , map.get(num)+1);
            } else{
                map.put(num,1);
            }
                
        }
                
       // Push hashmap entries into max heap       
      PriorityQueue<Map.Entry<Integer,Integer>> heap = new PriorityQueue<>( (a, b) -> b.getValue() - a.getValue());
        
       for(Map.Entry<Integer,Integer> entry : map.entrySet()){
           heap.add(entry);
       }
        
       // Create kth most elements []
        int[] res = new int[k];
        for(int i = 0; i < k ; i++){
            res[i] = heap.poll().getKey();
        }
    
        return res;
    }
}