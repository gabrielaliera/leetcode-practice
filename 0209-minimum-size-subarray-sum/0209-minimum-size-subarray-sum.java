class Solution {
    public int minSubArrayLen(int target, int[] nums) {
         if( nums == null || nums.length == 0 ){
            return 0;
        }

        int start  = 0;
        int minLength = Integer.MAX_VALUE;
        int sum = 0;
        for(int end = 0; end < nums.length ; end++){
            sum += nums[end];

            //Calculate if window sum is greater than target, determine if smallest window
            while(sum >= target){

                int windowLength = end - start + 1;
                minLength = Math.min(minLength, windowLength);

                //Remove start from sum
                sum -= nums[start];
                start++;


            }
        }
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
        
    }
}