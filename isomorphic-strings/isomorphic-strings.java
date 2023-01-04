
class Solution {
    public boolean isIsomorphic(String s, String t) {
        
        HashMap<Character,Integer> mapS = new HashMap<>();
        HashMap<Character,Character> mapT = new HashMap<>();
        HashMap<Character,Character> map = new HashMap<>();
        //Add characters to map
        for(int i = 0; i < s.length(); i++){
            char a =  s.charAt(i);
            char b =  t.charAt(i);
          
            //No mapping exist
            if(!map.containsKey(a)){
                map.put(a,b);
            }
            
            if (!mapT.containsKey(b)){
                mapT.put(b,a);
            }
            
            
            if(!map.get(a).equals(b) || !mapT.get(b).equals(a)){
             return false;
            }     
          
        }
        return true;
       
        
    }
}