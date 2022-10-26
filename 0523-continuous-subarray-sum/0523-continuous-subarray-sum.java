class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
       
       HashMap<Integer,Integer> map = new HashMap<>(); //reminder, end index
       int sum = 0;
       map.put(0,-1);
       
        for(int i=0; i<nums.length;i++){
           sum += nums[i];
            
           int remainder = sum % k;
            
           if(!map.containsKey(remainder)){
               map.put(remainder, i);
               
           } else if (i- map.get(remainder) > 1){
               return true;
           }
        }
        return false;
       
        
        
    }
}


//sliding window doesnt work

//  public boolean checkSubarraySum(int[] nums, int k) {
//         boolean multipleK = false;
//         int sum = nums[0];
//         int front = 0;
//         int back = 1;
        
//         if(nums.length< 2){
//             return false;
//         }
        
//         while (back < nums.length){
//             sum += nums[back];
//             back++;
            
//             if (sum % k == 0){
//                 return true;
//             }
            
//         }
        
//         if(sum %k == 0){
//             return true;
//         }
       
        
//         while(front < back-2){
//             sum-= nums[front];
//             front++;
//              if (sum % k == 0){
//                 return true;
//             }
            
//         }
        

    
//          while(back> front && front > 0){
           
            
//            front--;
//            sum+= nums[front];
//              if(sum %k ==0){
//                 return true;
//             }
//         }
      
        
//         return false;
        
//     }
// }