/*

Recursion to check odd
use memo to call stack

if even
    operation = 0
    while(num > 1)
      num /2 
      operation ++
     return operation
else if odd

    operation = n +1
    operation = n- 1
    
    return Math.min(op1, op2)

helper (num)
    
    while(n > 1)
  
  return operation

*/




class Solution {
    public int integerReplacement(int n) {
        return checkOperations( (long) n , new HashMap<Long,Integer>());
    }
    
    
    public int checkOperations(long n, HashMap< Long, Integer> map){     
        
        if(map.containsKey(n)){
            return map.get(n);
        }
        
        int operations;
        
        //base
        if( n <= 1){
            return 0;
        } else {
            
            //even
            if(n % 2 == 0){
                
             operations = 1 + checkOperations(n/2, map);
                
            //odd
            } else{
                operations = 1 + Math.min(checkOperations(n -1,map), checkOperations(n+1, map));
            }
            
            map.put(n, operations);
            return operations;
            
        }
    
      
    }
}