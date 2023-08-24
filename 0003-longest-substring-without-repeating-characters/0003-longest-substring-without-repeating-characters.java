/*
Understand:
Substtring - consecutive 

hashmap
two pointer
sliding window



brute: 2 for loop with hashamp O(n^2)


Sliding window - abcab

Start at 5
  iterate until find repeat number
Decrease right pointer by one
Iterate with 4  
    abca 
    bcab
    
Iterate with 3
    abc - yes break
    bca
    cab


*/


class Solution {
    
    
    //Optimzing 
    public int lengthOfLongestSubstring(String s) {
        
        if(s.length() < 1){ return 0;}
        
        HashSet<Character> letters = new HashSet<>(); 
        int left = 0;
        int right = 0;
        int max = 0;
                
       while (right < s.length()) {
        if (!letters.contains(s.charAt(right))) {
            letters.add(s.charAt(right));   // Expand the window to the right
            max = Math.max(max, right - left + 1);   // Update the maximum length
            right++;   // Move the right pointer to the right
        } else {
            letters.remove(s.charAt(left));   // Shrink the window from the left
            left++;   // Move the left pointer to the right
        }
    }

    return max;
    }
    
    
    //Brute    
     public int lengthOfLongestSubstring2(String s) {
        
        int max = 1;
        
        for(int i = 0; i < s.length() ; i++){
            HashSet<Character> letters = new HashSet<>();
            
            letters.add(s.charAt(i));
            
            for(int j = i + 1;  j < s.length() ; j++){
            
                if(letters.contains(s.charAt(j))){
                    max = Math.max(max, letters.size());
                    
                    break;
                } else {
                    letters.add(s.charAt(j));
                }
            }
            
        }
        return max;
    }

}