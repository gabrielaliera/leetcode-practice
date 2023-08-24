/*
U:

input: gurantee to have 3 ints

output: list of list - ArrayList<List>
Edge: [0,1,0] = [] empty array
edge: [0, 0 ,0] = [[0,0,0]]

triplets are values not index


Plan:
 Brute - 3 for loops O(n^3)
 
 in twoSum = use hashmap to find  target - num[i]
   2 for  loops then look for target
 -- Issue with hashmap hard top add unique triplets
 num0 num1 num2 = -1 0 1 
 num1 num2 num4 = 0 1 -1  - both use same values with differnet index only add once to result
 
 
*/




class Solution {
    
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length && nums[i] <= 0; ++i)
            if (i == 0 || nums[i - 1] != nums[i]) {
                twoSumII(nums, i, res);
            }
        return res;
    }
    void twoSumII(int[] nums, int i, List<List<Integer>> res) {
        int lo = i + 1, hi = nums.length - 1;
        while (lo < hi) {
            int sum = nums[i] + nums[lo] + nums[hi];
            if (sum < 0) {
                ++lo;
            } else if (sum > 0) {
                --hi;
            } else {
                res.add(Arrays.asList(nums[i], nums[lo++], nums[hi--]));
                while (lo < hi && nums[lo] == nums[lo - 1])
                    ++lo;
            }
        }
    }
    
    public List<List<Integer>> threeSumNOTWorking(int[] nums){
      //Step 1 -Sort in ascending order - nlogn
      Arrays.sort(nums);
        
      List<List<Integer>> result = new ArrayList<>();

     //Step 2 iterate through entire array
        for(int i = 0; i < nums.length - 2; i++){
            
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue; // Skip duplicates for numA
            }
            
            int numA = nums[i];   
            int left = i + 1;
            int right = nums.length - 1;
            
            while(left < right){
                int target = numA + nums[left] + nums[right];
                
                if(target == 0){
                    //found
                    List<Integer> triplet = new ArrayList<Integer>(Arrays.asList(nums[i] , nums[left], nums[right]));
                    result.add(triplet);
                    
                    //Move duplicates
                    while (left < right && nums[left] == nums[left + 1]){
                        left++;
                    }
                    
                    while (left < right && nums[right] == nums[right - 1]) {
                    right--; // Skip duplicates for right
                    }
                
                } else if ( target > 0 ){
                    right --;
                } else {
                    left++;
                }
            }
        }
      return result;
    }
}
    
    
  