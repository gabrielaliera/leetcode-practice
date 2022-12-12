//Idea
//Boyer moyer - last occurance of patten but this is more for substring
//hashmap - letters of string (letter, index)
//two pointer-O(N2)

//HashMap
/*
1) iterate through string 1 and add char, index to hashmap
2) iterate through string 2
    check it char string 2 is exist in hashmap
  
    if char doesnt exist
        return false
    else
         check next char, make sure previous char index is smaller
         if larger
            return false
    return true
    Space O(n)
    Time O(n+m)
*/
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

class Solution {
    public boolean isSubsequence(String s, String t) {
        
        if(s.length()<1){return true;} //Base case

        HashMap<Character,ArrayList<Integer>> map = new HashMap<>();
        char[] t1 = t.toCharArray();
        
        for(int i=0;i<t1.length;i++){
            char c = t1[i];

            //Add new indices to map
            if(map.containsKey(c)){
                ArrayList<Integer> list = map.get(c);
                list.add(i);
                map.put(c,list);
            } else { //otherwise add new char to map
                ArrayList<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(c,list);  //issue duplicate letters-- assume all unqiue, then adjust for duplicates
            }
           
        }

        int prevIndex =-1;
        for(int j=0;j<s.length();j++){
            
            char c = s.charAt(j);
            if(!map.containsKey(c)){ //map doesnt contain letter in source
                return false;
            }
           
           boolean matchFound= false;
           for(int index: map.get(c)){
               if(index > prevIndex){
                   prevIndex = index;
                   matchFound = true;
                   break;
                }
            }
            if(!matchFound){
                return false;
            }    
        }
        return true;
    }
}