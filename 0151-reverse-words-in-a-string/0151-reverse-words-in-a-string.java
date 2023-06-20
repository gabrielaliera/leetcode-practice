class Solution {
    public String reverseWords(String s) {
        //Step 1: Reverse the entire sentence
        s = s.replaceAll("\\s+", " "). trim();
        char[] reversed = s.toCharArray();
        int left = 0;
        int right = reversed.length -1;
        while(left < right){
            char temp = reversed[left];
            reversed[left] = reversed[right];
            reversed[right] = temp;
            left++; right--;
        }

       
        //Step2: Iterate over string
        int start = 0;
        for(int end = 1; end < reversed.length; end++){
            
            //Reverse word when end reaches space
            if(reversed[end] == ' ' || end + 1 == reversed.length){
               
                int cur = end - 1;
                
                if(end +1 == reversed.length){
                    cur = end;
                }
                //Reverse single word
                while( start < cur){
                    char temp = reversed[start];
                    reversed[start] = reversed[cur];
                    reversed[cur] = temp;
                    start++; 
                    cur--;
                }
                start = end + 1;
            }
        }



        return new String(reversed);
        
    }
}