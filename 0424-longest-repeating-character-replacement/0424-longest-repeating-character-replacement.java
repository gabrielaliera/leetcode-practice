/*
U
return: longest substring of SAME letter AAAA not ABAB 
How many letters can be ? 26 
edge case: k = s.lenght return k

Match:
sliding window

Plan
 edge case:
  if k == s
  
  window = end - start + 1

*/

class Solution {
    
public int characterReplacement(String s, int k) {
        
        //Edge
        if(s.length() == k){ return k;}
        
               
        //Initize map and result
        int start = 0;
        HashMap<Character, Integer> letterFreq = new HashMap<>();
        int maxLetter = 0;
        int maxSubstring = 0;
        
        //Iterate with first pointer
        for(int end = 0; end < s.length(); end++){
                     
          //Get letter
          char letter = s.charAt(end);
            
           //Update letterFreq
          if(!letterFreq.containsKey(letter)){
              letterFreq.put(letter, 1);
          } else {
              letterFreq.put(letter, letterFreq.get(letter)+ 1);
          }
          
          //Update most freq letter
          maxLetter = Math.max(maxLetter, letterFreq.get(letter));
          
          
          int windowLength = end - start +1;

          //Window is invalid
          //Remove letter, decrease freq, move start
          if(!(windowLength - maxLetter <= k)){
            
            char outgoing = s.charAt(start);
            
            //Remove letter at index i from letterFreq
            letterFreq.put(outgoing, letterFreq.get(outgoing) - 1); 

            start++;
          }

          maxSubstring = end - start + 1;          
          
        }
              
        return maxSubstring;
    }


}