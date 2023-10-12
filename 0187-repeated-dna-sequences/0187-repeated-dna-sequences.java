class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        // Your code will replace this placeholder return statement
        HashSet<String> unique = new HashSet<>();
        HashSet<String> repeated = new HashSet<>();

        int end = 10 - 1;

        for(int start = 0; end <s.length(); start++){
           String substring = s.substring(start, end + 1);

           if(unique.contains(substring)){
              repeated.add(substring);
           } else {
             unique.add(substring);
           } 

           end++;
        }
        
        List<String> result = new ArrayList<>();
        for(String entry: repeated){
            result.add(entry);
        }
        return result;
   }
        
}
