/*

U: 
  Input: array of letter of at least 1
     n  can be 0-100
     task is any order
     
Happy n = 2
 A B ide A   B idle A B  
 A  1 2  A
    B 1  2   B
             1  2  A   
                1  2  B 
                
                
Match:
   Hashmap to store task counts  A -3
                                 count , list of letters
   
   or Array of 26 letters with count
   
   Something to hold next task for letter
   Something to hold total unit of time
   
   Greedy Stategy -
      need to sort is decending letter freq
   
Plan ["A","A","A","B","B","B"], n = 2

    1) Create a hashmap and add letters and count  or Array of letter
       A - 3
       B - 3
       
      2) Max possible idle = maxFreq of letter - 1 * cooling period
      max idle = 3 - 1 * 2 => 2 * 2 = 4
      A _ _ A _ _A 
     
     3) sort Array
     
     
     iterate while all task not use
     find max task
     use task
     decrement task counter
     
                                
*/

class Solution {
    public int leastInterval(char[] tasks, int n) {
        
        //Create arr of letters O(N)
        int[] taskFrequencies = new int[26];
        for(char c : tasks){
            taskFrequencies[c - 'A'] ++;
        }
        
        //Sort array in ascending O(nlog)
        Arrays.sort(taskFrequencies);
       

        //Find max freq and max possible idle time
        int maxFreq = taskFrequencies[25];
        
        int idleTime = (maxFreq - 1) * n;
        
        //Iterate throufh frequecies from max to least not including 0
        for(int i = taskFrequencies.length - 2 ; i >= 0 && idleTime > 0; i--){
            idleTime -= Math.min(maxFreq - 1, taskFrequencies[i]);
        }
        
         idleTime = Math.max(0, idleTime);
        
        return idleTime + tasks.length;
        
        
    }
}