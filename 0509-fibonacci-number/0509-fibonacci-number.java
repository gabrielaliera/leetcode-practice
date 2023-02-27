class Solution {
    public int fib2(int n) {
        if(n <= 1){
            return n;
        }
        
        return fib2(n-1) + fib2(n-2);
        
    }
    
    public int fib(int n){
      
        if(n <= 1){
            return n;
        }
        
        
        int x = 1;
        int y = 0;
        int current = 0;
        
        for( int i = 2; i <= n ; i++){
            current = x + y;
            y =  x;
            x = current;
        }
        
        
        return current;
    }
}