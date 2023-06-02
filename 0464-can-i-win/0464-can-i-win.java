/*
Understand:
  integer - not 0   1  to max
  win- first to >= 100
  No reuse
  Return force win
  
  Optmally - not mean pick highest
  
  happy case
  max =10 total = 0
  First player always win - true
  
  max = 10 total = 1
  true
  
  max=10 total - 11
  false , if 
  
  
  max -10 total - 12
  1 2 
  Match
  Hashmap - track of numbers
  
  
  Plan
   edge case
   
   creat hashmamp
   
   helper function
  

*/


class Solution {
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
       
        //Edge case
        if( desiredTotal <= 1){ return true;}
        
        // If the sum of all possible integers is less than desiredTotal, no one can win
        int sum = (maxChoosableInteger * (maxChoosableInteger + 1)) / 2;
        if (sum < desiredTotal) {
            return false;
        }
               
        HashMap<Integer, Boolean> memo = new HashMap<>();
        
        return helper(0, maxChoosableInteger, desiredTotal, memo);
    }
      
     private boolean helper(int used, int maxChoosableInteger, int desiredTotal, HashMap<Integer, Boolean> memo) {
        
        // If the current game configuration has already been calculated, return the result from the memo
        if (memo.containsKey(used)) {
            return memo.get(used);
        }
        
        // Iterate through all possible choices
        for (int i = 1; i <= maxChoosableInteger; i++) {
            int mask = (1 << i);
            // If the current number has not been used yet
            if ((used & mask) == 0) {
                // If the desiredTotal can be reached by choosing the current number,
                // or the opponent cannot force a win in the next turn
                if (i >= desiredTotal || !helper(used | mask, maxChoosableInteger, desiredTotal - i, memo)) {
                    memo.put(used, true);
                    return true;
                }
            }
        }
        
        // If no winning move is found, the current player cannot force a win
        memo.put(used, false);
        return false;
    }
}