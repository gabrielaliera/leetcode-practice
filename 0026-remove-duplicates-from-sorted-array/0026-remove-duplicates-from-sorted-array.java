class Solution {
    public int removeDuplicates(int[] nums) {
        //int reader = 0;
        int writer = 1;
        for( int i = 1; i < nums.length ; i++){
            
            if(nums[i-1] != nums[i]){
                nums[writer] = nums[i];
                writer++;
            }
        }
        return writer;
    }
}