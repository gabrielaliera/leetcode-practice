class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        HashMap<String,List<String>> map = new HashMap<>();
        List<List<String>> list = new ArrayList<>(); 
        
        for(String str : strs){
            
            //Sort each str to check if anagrams
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String word = new String(chars);
            
            if(!map.containsKey(word)){
                //create list to hold anagrams
                List<String> anagrams = new ArrayList<>();
                //add orginal string
                anagrams.add(str);
                //add list to map
                map.put(word,anagrams);
               
            } else {
                //find list containing word and append
                List<String> oldAnagramList = map.get(word);
                oldAnagramList.add(str);
                //re-add new wordlist
                map.put(word, oldAnagramList);
            }
        }
        //Make list from hashmap
        for(Map.Entry<String,List<String>> entry : map.entrySet()){
            list.add(entry.getValue());
        }
        
        
        return list;
    
    }
}