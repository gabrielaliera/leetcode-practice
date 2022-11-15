/*

Plan

create char array
set leftpoint to 0
set rightpoint to first whitespace

reserve word

reset pointers

recombine string
return string 



*/
class Solution {
    public String reverseWords(String s) {
        char[] charArray = s.toCharArray();
        
        int leftPtr= 0;
        int rightPtr=0;
        int lastPtr = charArray.length-1;
        
        while(rightPtr<= lastPtr){
            if(charArray[rightPtr] != ' '&& rightPtr !=lastPtr){
                rightPtr++;
            }else{
               
                int first= leftPtr;
                int last;
                if(rightPtr==lastPtr){
                    last = rightPtr;
                }else{
                    last = rightPtr-1;
                }
              
                
                while(first< last){
                    char temp = charArray[first];
                    charArray[first] = charArray[last];
                    charArray[last] = temp;
                    first++;
                    last--;
                }
                leftPtr = rightPtr+1;
                rightPtr++;
           
            }
            
            
            
        }
        
        return new String(charArray);
      
        
    }
}