class Solution {
    public int maxSubArray2(int[] nums) {
        
        int maxSum = Integer.MIN_VALUE;
        int size = nums.length;
            
        for(int i=0; i <size; i++){        
            for(int j=0; j<=i; j++){
                
                int sum = 0; 
                
                for(int k=j; k<=i;k++){
                    sum+= nums[k];
                }
                maxSum = Math.max(maxSum, sum);    
                
            }
            
        }
        return maxSum;
    }
    
    //O(n)
    public int maxSubArray(int[] nums){
        if(nums.length == 1){return  nums[0];}
        
        int max = Integer.MIN_VALUE;
        
        int sum = 0;
        
        for(int num : nums){
        
            sum += num;
            max = Math.max(max, sum);
            
            if(sum < 0){
                sum = 0;
            }
            
        }
     return max;
    }
}