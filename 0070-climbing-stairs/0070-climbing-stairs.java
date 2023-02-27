class Solution {
    public int climbStairs2(int n) {
        if(n <= 2){
            return n;
        }
         return climbStairs2(n-1) + climbStairs2(n-2);
        
    }
    
    public int climbStairs(int n){
         if(n <= 2){
            return n;
        }
        int prev1 = 2;
        int prev2 = 1;
        int current = 2;
            
        for(int i = 2; i < n ; i++){
            current = prev1 + prev2;
            prev2 = prev1;
            prev1 = current;
        }
        return current;
    }
}