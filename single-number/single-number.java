class Solution {
    public int singleNumber(int[] nums) {
        int answer;
        Set<Integer> hashset = new HashSet<>();
        
        for (int key : nums) {
            if (hashset.contains(key)) {
                hashset.remove(key);
            } else{
               hashset.add(key);
            }
           
          
        }
        
        answer = (int)hashset.toArray()[0];
        
        return answer;
    

    }
}