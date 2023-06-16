/*

 U: 
 
 input: 
  diff guarrent to be 1
  nums guarantee to be at least 3 nums
 j - i =  diff
 k - j = diff
 
 Happy:
 [0,1,4,6,7,10] dif = 3
 
 i = 1     i = 4
 j = 4     j = 7
 k = 7     k = 10
 
 Output 2
 
 Edge: [0,0,0]
 output 0
 
 M:
   brute: 3 loops to iterate => O(n^3)
   hashmap to store diff
   2 binary search

Plan:
    [0,1,4,6,7,10] dif = 3
    
    diff3 map
      01
      1 - 10   mid 6  6-1 = 5 n0
  
     binary search helper (start, end, arr diff,)
     return index
     if -1 didnt find num
     
     do 2nd b-search to find 3rd

Plan 2 - hashset
 x = nums[i]
 y = nums[j]
 z = nums[k]
 
 y = x + diff
 
 z = y + diff
 
 =>  z = x + diff +diff
     z = x + 2diff
     
if hashset find if contains x+diff and x+2diff
*/



class Solution {
   
   /*Brute
    public int arithmeticTriplets(int[] nums, int diff) {
        
        int count = 0;
        
        for(int i = 0; i < nums.length; i++){
            for(int j = i + 1; j < nums.length; j++){
                 for(int k = j + 1; k < nums.length; k++){
                       if( nums[j] - nums[i] == diff && nums[k] - nums[j] == diff){
                           count++;
                       }
                }
            }
        }
        return count;
        
    }
    */
    
    //optimized for binary search
    public int arithmeticTriplets(int[] nums, int diff) {
        
        int count = 0;
        
        HashSet<Integer> set = new HashSet<>();
        //add all numbers to set
        for(int num : nums){
            set.add(num);
        }
        
        //check if has number
        for(int x : nums){
            if( set.contains(x + diff) && set.contains(x +  2 * diff) ){
                count++;
            }
        }
        return count;
        
    }
    
    
}