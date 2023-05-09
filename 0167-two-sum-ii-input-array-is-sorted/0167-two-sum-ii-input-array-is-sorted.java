class Solution {
    public int[] twoSumOLD(int[] numbers, int target) {
        
        int result[] = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0 ; i < numbers.length; i++){
            
            if(map.containsKey(target - numbers[i])){
                result[1] = i + 1;
                result[0] = map.get(target- numbers[i]) + 1;
            } else {
                map.put(numbers[i], i);
            }
                
        }
        return result;
        
    }
    public int[] twoSum(int[] numbers, int target) {
        
        int result[] = new int[2];
        int l = 0;
        int r = numbers.length -1;
       
        while(l < r){
            int sum = numbers[l] + numbers[r];
            
            if(sum == target){
                break;
            } else if ( sum > target){
                r--;
            } else {
                l++;
            }
        }
        
        return new int[] { l + 1 , r + 1};
    }
}