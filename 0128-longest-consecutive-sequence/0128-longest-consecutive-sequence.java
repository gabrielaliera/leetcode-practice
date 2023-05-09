class Solution {
    /*Brute Force
    
    sort - nlog
    
    two pointer
    
    */
    public int longestConsecutiveBrute(int[] nums) {
    
        if(nums.length == 0){
            return 0;
        }
        Arrays.sort(nums);
        
        int max = 1;
        int current = 1;
        
        for(int i = 1; i < nums.length ; i++){
            
          if(nums[i] != nums[i-1]){
            if(nums[i] == nums[i-1]+1){
                current ++;
            } else{
                max = Math.max(current, max);
                current = 1;
            }
          }
        }
        
        return Math.max(current, max);
    }
    
    //With hashmap
    public int longestConsecutive(int[] nums) {
    
        if(nums.length == 0){
            return 0;
        }
        
        HashSet<Integer> set = new HashSet<>();
        for(int num : nums){
            set.add(num);
        }
        
        
        
        int longest = 0;
   
        for(int num : set){
            
            if(!set.contains(num - 1)){
                int currentNum = num;
                int current  = 1;
                
                while(set.contains(currentNum+1)){
                    current++;
                    currentNum++;
                }
                longest = Math.max(current, longest);
            }
        }
        
        return longest;
    }
}