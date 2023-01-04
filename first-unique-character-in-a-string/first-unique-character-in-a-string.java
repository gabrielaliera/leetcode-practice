class Solution {
    public int firstUniqChar(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        HashMap<Character,Integer> unique = new HashMap<>();
        
        int index = Integer.MAX_VALUE;
        
        //count char occurance
        for(int i=0; i < s.length(); i++){
            Character c = s.charAt(i);
            
            if(!map.containsKey(c)){
                map.put(c,1);
                unique.put(c,i);
        
            } else {
                map.put(c,map.get(c)+1);
                unique.remove(c);
            }
            
        }
        
        //find index for all occurance = 1
        for(int i=0; i < s.length(); i++){
            Character c = s.charAt(i);
            
            if(map.get(c) == 1 && index > i){
                index = i;
            } 
        }
        
        if(index == Integer.MAX_VALUE){return -1;}
       
        return index;
    }
}