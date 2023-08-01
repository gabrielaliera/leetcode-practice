/*

1 1 2 


*/

class Solution {
     HashMap<Integer, Integer> cache = new HashMap<>();
    
    public int climbStairs(int n ) {
       
        
        return climbStairsMemo(n -1) + climbStairsMemo(n-2);
    }
    
    public int climbStairsMemo(int n) {
        
        if( n < 0){
            return 0;
        }
        if( n  == 0 || n== 1) {
            cache.put(n, 1);
            return cache.get(n);
        }
        
        if(cache.containsKey(n)){
            return cache.get(n);
        }
        
        
        int sum = climbStairsMemo(n - 1) + climbStairsMemo(n - 2);
        cache.put(n, sum);
        
        return cache.get(n);
        
        
    }
}