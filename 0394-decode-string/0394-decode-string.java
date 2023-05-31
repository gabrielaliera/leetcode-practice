/*

change to charArray to iterate

if char[i] == isNumber

 find substring - 
    add char to string
    look for closing ]
    
add substring to main string


*/


class Solution {
    
    public String decodeString(String s) {
        
       
        String str = "";
        Stack<Integer> numStack = new Stack<>();
        Stack<String> stringStack = new Stack<>();
        int num = 0;
 
        for(int i = 0; i < s.length() ;  i++){
            char ch = s.charAt(i);
            
            if(Character.isDigit(ch)){
                //
                // currentCount = currentCount * 10 + (ch - '0'); solution from dicussion
                num = num *10 + Character.getNumericValue(ch); //need to deal with  
                
            } else if ( ch == '['){
                numStack.push(num);
                stringStack.push(str);
                str = "";
                num = 0;
            } else if (ch ==']'){
                 // add substring to ans
                int count = numStack.pop();
                String temp = str;
                str = stringStack.pop();
                
                while( count > 0){
                    str += temp;
                    count--;
                }
            } else {
                str += ch;
            }
            
           
        }   
             return str;
      
    }
}