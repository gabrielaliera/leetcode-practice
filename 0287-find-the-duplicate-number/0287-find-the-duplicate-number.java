class Solution {
    public int findDuplicate(int[] nums) {
         int slow = nums[0];
      int fast = nums[0];

      while(true){
         //move slow once
         slow = nums[slow];

         //move fast once
         fast = nums[fast];

         //move fast 2nd time
         fast = nums[fast];

         if(slow == fast){
            break;
         }
      }

      slow = nums[0];

      while(slow != fast){
         slow = nums[slow];
         fast = nums[fast];
      }
      
      return fast;
   }
        
    
}