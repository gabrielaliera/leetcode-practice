/*

sort lex: 3 30 34 5 9 91

how to deal with 3 and 30

953 4 3 30
953 3 4 30
954 4 3 31
     30
34 3 31
   3 32
   3 33 
   34 3
   next digit is equal or less than put right
   
34 3 300
34 3 003
34 3 305
34 3 053
idea: 
 maxheap fo strings

*/


class Solution {
    public String largestNumber(int[] nums) {
        
        //Convert to string and sort lexugraphically
        String[] numStrings = new String[nums.length];
        int i = 0;
        for(int n : nums){
            String s = String.valueOf(n);
            numStrings[i++] = s;
        }
        
        Arrays.sort(numStrings, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                String n1 = s1 + s2;
                String n2 = s2 + s1;
                return n2.compareTo(n1);
            }
        });
        
        //Edge case
        if(numStrings[0].equals("0")) return "0";
       
       StringBuilder res = new StringBuilder();
            
        //Greedy
        for(int j = 1; j < numStrings.length; j += 2){
            String a = numStrings[j - 1];
            String b = numStrings[j];
            
       
            if((a + b).compareTo( b + a) > 0){
                  res.append( a + b);        
            } else {
                res.append(b + a);
            }
        }
        // Handle the case when the number of elements is odd
        if (numStrings.length % 2 != 0) {
            res.append(numStrings[numStrings.length - 1]);
        }
        
        return res.toString();
    }
}