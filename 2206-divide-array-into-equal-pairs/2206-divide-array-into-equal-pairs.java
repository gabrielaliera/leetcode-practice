class Solution {
    public boolean divideArray(int[] nums) {
        int[] count = new int[500];
        for(int num : nums){
          //  System.out.println(num);
            count[num - 1]++;
        }
        
        for(int num : count){
            //System.out.print(num + " ");
            if(num % 2 != 0){
                return false;
            }
        }
        return true;
        
    }
}