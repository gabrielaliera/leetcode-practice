class Solution {
    public int firstUniqChar(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
     
        
        //count char occurance
        for(int i=0; i < s.length(); i++){
            Character c = s.charAt(i);
            
            if(!map.containsKey(c)){
                map.put(c,1);
        
            } else {
                map.put(c,map.get(c)+1);
            }
            
        }
        
        //find index for all occurance = 1
        for(int i=0; i < s.length(); i++){
            Character c = s.charAt(i);
            
            if(map.get(c) == 1){
                return i;
            } 
        }
        
       
        return -1;
    }
}