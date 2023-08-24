/*

Understand: Integer overload , 

Brute - iterate all pairs 0(n^2)

with hashmap

a + b = target
b = target - a

Step 1: create hashmap

Step 2: iterate through array

Step 3: add num to hashmpa

Step 4 check if target is in hashmap
  of yes, return index
add values, index to hashmap

Else retunr empty

duplicates:


*/


class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        int[] result = new int[2];
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0 ; i < nums.length ; i ++){
            
                      
            int b = target - nums[i];           
            
            if(map.containsKey(b)){
                result[1] = i;
                result[0] = map.get(b);
            }
             
            map.put(nums[i] , i);
        }
        
        return result;
        
    }
}