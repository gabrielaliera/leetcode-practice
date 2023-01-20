/*
use hashmpap with number of occurance of letter

iterate through string 1 to create hashmamp
if letter exist
   update count
else 
   add to hashmap

iterate through 2nd string 
if letter in second string doesnt exist
    return false

CCCA
CCAA

return true
TIME: O(n+m)
Space O(n)


Sort
Time O(nlogn)
Space O(1)


Base case
string not equal return flase
*/


class Solution {
    public boolean isAnagram(String s, String t) {
        //Basse case
        if ( s.length() != t.length()) {return false;}
        
        
        //Create hashmap
        HashMap<Character, Integer> map = new HashMap<>();
        
        //Iterate through string s to create map
        for(Character c : s.toCharArray()){
            if(map.containsKey(c)){
                //update count
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        
        //Iterate through 2nd string to check for similar letters
        for (Character c : t.toCharArray()){
            //doenst exist
            if(!map.containsKey(c)){
                return false;
            //exist and update count
            } else if (map.get(c) == 0){
                return false;
            //exist and update count
            } else {
                 map.put(c, map.get(c)-1);
            }
        }
        
        return true;
        
    }
}

/*
To do:
      - cobine return false if statements in 2nd for loop

*/