/*



*/


class Solution {
    public int[] productExceptSelf(int[] nums) {
        
        int[] Left = new int[nums.length];
        int[] Right = new int[nums.length];
    
       
        Left[0] = 1;
        for(int i = 1 ; i < nums.length ; i++){
             Left[i] = Left[i-1] * nums[i-1];
        }
        
        Right[nums.length - 1] = 1;
        for(int j = nums.length -2 ; j >= 0; j--){
           
            Right[j] = Right[j+1] * nums[j+1];
        }
        
        for(int k = 0 ; k < nums.length ; k++){
            nums[k] = Left[k] * Right[k];
        }
        
        
        return nums;
    }
}