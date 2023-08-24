/*
Understand:
Substtring - consecutive 

hashmap
sliding window

brute: 2 for loop with hashamp O(n^2)


*/


class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        if(s.length() < 1){ return 0;}
        
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
                     max = Math.max(max, letters.size());
                }
            }
            
        }
        return max;
    }
    
    //Optimzing 
    
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