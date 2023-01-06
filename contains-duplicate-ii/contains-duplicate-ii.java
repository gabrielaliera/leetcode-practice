/*
1. Initialize hashmap - contains value, and index
2. Iterate through array
if nums is in hashmap
    check is map.get(num) - i <= k
       return true

else ( nums in hashmap)
   add num to hashmap

return false
*/


class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i= 0; i < nums.length ; i++){
            int j = nums[i];
            
            if(map.containsKey(j)){
                int diff = Math.abs(i- map.get(j));
                if(diff <= k){
                    return true;
                }                    
                map.put(j, diff);
            
            } else {
                map.put(nums[i],i);
            }
        }
       return false;
    }
}