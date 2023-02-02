class Solution {
    public int maxLength(List<String> arr) {
        
        return backtracking(arr,0 , new HashMap<Character, Integer>());
        
    }
    
    
    public int backtracking(List<String> arr, int pos, Map<Character,Integer> letters){
        
        //check for duplicate characters
        for(Integer val : letters.values()){
            if(val > 1){ return 0;}
        }
        
        
        //recurse through each possible next and check for best anseer
        int best = letters.size();
        
        for(int i = pos; i < arr.size(); i++){
            
            char[] str = arr.get(i).toCharArray();
            
            //add character to hashmap
            for(Character c : str){
                letters.put(c , letters.getOrDefault(c, 0) + 1);
            }
            best = Math.max(best, backtracking(arr, i+1, letters));
            
            
            //backtracking map before continue - need to delete add letters
            for(Character c: str){
                if(letters.get(c) == 1){
                    letters.remove(c);
                } else {
                    letters.put(c, letters.get(c) -1);
                }
                
            }
            
        }
        return best;
    }
}