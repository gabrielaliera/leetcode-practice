class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        
        HashMap<String,Integer> map = new HashMap<>();
        HashMap<String,Integer> duplicate = new HashMap<>();
        ArrayList<String> answer = new ArrayList<>();
        int leastSum = Integer.MAX_VALUE;
        
        for(int i = 0; i < list1.length ; i++){
            String s1  = list1[i];
            map.put(s1,i);
        }
        
        
        for(int i = 0; i < list2.length ; i++){
          
            String s2  = list2[i];
            //duplicate exist
            if(map.containsKey(s2)){
                int sum  = i +  map.get(s2);
                duplicate.put(s2,sum);
                leastSum = Math.min(sum, leastSum);
            } else {
                map.put(s2,i);
            }
            
            
        }
        
        for(Map.Entry<String,Integer> pair : duplicate.entrySet()){
           // System.out.println(pair +" " +leastSum);
            if(pair.getValue() ==  leastSum){
                answer.add(pair.getKey());
            }
        }
        
        return answer.toArray(new String[answer.size()]);
        
    }
}