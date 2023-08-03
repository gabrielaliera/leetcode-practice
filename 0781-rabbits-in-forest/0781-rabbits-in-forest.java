/*

Understand:
dont know # of rabbits so all rabbits are not asked
rabbits asked twice?

input:

idea:
hashmap to collection values occurs


count is even
 1 : 2  -> 2   RR rabbits
 1 : 4  -> 4  RR GG
1:   6 -> 6   RR GG CC

1: 3 -> 3 
1: 5-> 
*/


class Solution {
    public int numRabbits(int[] answers) {
        HashMap<Integer, Integer> sameColor = new HashMap<>();
        
        //Get count
        for(int num : answers){
            if(!sameColor.containsKey(num)){
                //add 
                sameColor.put(num, 1);
            } else {
                sameColor.put(num , sameColor.get(num) + 1);
            }
        }
        
         int minRabbits = 0;

        // Calculate the minimum number of rabbits based on the answers
        for (Map.Entry<Integer, Integer> entry : sameColor.entrySet()) {
            int answer = entry.getKey();
            int count = entry.getValue();
            // Each group of rabbits with the same color has 'answer + 1' members
            // We add (count + answer) / (answer + 1) to get the minimum number of groups
            // and then multiply by (answer + 1) to get the minimum number of rabbits
            minRabbits += (count + answer) / (answer + 1) * (answer + 1);
        }

        return minRabbits;
        
    }
}