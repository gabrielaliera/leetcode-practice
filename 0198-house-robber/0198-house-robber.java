/*

1 2 3 1 
1 2 4 3

2 7 9 3 1
2 7 11 10 12

*/

class Solution {
    public int robA(int[] nums) {
        
        int N = nums.length;
        
        if(nums.length <= 1 ){
            return nums[0];
        }
        
        int[] robbed = new int[nums.length + 1];
        
        robbed[N] = 0;
        robbed[N- 1] = nums[N -1];
            
        for(int i = N-2 ; i >= 0; i-- ){
            robbed[i] = Math.max(robbed[i + 1], robbed[i + 2] + nums[i]);
        }
        
        return robbed[0];
        
    }
    
     public int rob(int[] nums) {
        
        int rob1 = 0;
         int rob2 =0 ;
         
         for(int n : nums){
             int temp = Math.max(n + rob1 , rob2);
             rob1 = rob2;
             rob2 = temp;
         }
         
         return rob2;
        
    }
}