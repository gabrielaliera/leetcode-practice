/*
iterate through all with index1A

    when find first letter index1a == index2
       keep iterate with until find last letter
       
      find shortest backbaward
      
      reset with last pointer 
        

*/

class Solution {
    public String minWindow(String s1, String s2) {
        
        
        int size1 = s1.length();
        int size2 = s2.length();
        
        int indexS1 = 0;
        int indexS2 = 0;
        
        int start = 0;
        int end = 0;
        
        int minSubLen = Integer.MAX_VALUE;
        String minSubseq = "";
        
        while(indexS1 < size1){
            
            
            //Found letter
            if(s1.charAt(indexS1) == s2.charAt(indexS2)){
                
                indexS2 += 1;
               
                //found all letter
                if(indexS2 == size2){
                    
                    start = indexS1;
                    end = indexS1;
                    
                    //Decrement in reverse loop
                    indexS2 -= 1;
                    while(indexS2 >= 0){
                        if(s1.charAt(start) == s2.charAt(indexS2)){
                            indexS2 -= 1;
                        }
                        start -= 1;
                    }
                    start += 1;
                    
                    //Check for minsub
                    if(( end - start + 1) < minSubLen){
                        minSubLen = end - start + 1;
                        
                        minSubseq = s1.substring(start, end + 1);
                    }
                
                    indexS1 = start;
                    indexS2 = 0;
                }
            }
            indexS1 += 1;
        }
        
        return minSubseq;
    }
}