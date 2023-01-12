
// #iterate and remove- brute force
// #count = nums size
// #loop through each element
// #if element == val  
// #   remove element
// # count --
// #   shift elements to fill space to left
// #continue loop
/*
What is swap value is equal to val?
- iteratie at star to ensure last index is value
-recheck index
*/

class Solution {
    
  
    public int removeElement(int[] nums, int val) {
       int reader = 0;
       int writer =0;
        for(int i = reader; i < nums.length ; i++){
            if(nums[i] != val){
                nums[writer] = nums[i];
                writer++;
            }
        }
        return writer;
    }
}