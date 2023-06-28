/*

Understand:
Input : 
   no * or /
   extra spaces?? yes
   no empty string
Output
  return 32-bit integer

Match:
   stacks or queue
   use 2 queues
   
Plan
 2 stacks
    one for nums
    one for sign
    
while num stack not empty
  get next char
  check is num
  if num
    push to num
 else 
    push to operator stack



*/
class Solution {
    public int calculate(String s) {
      
        int num = 0; //Stores current num in string
        int sign = 1; //to change to negative
        int result = 0;
        Stack<Integer> stack = new Stack<>();

        //Loop through entire experssion
        for(int i = 0; i < s.length() ; i++){
            char c = s.charAt(i);

            if( Character.isDigit(c)){
                int digit = Character.getNumericValue(c); // convert to integer
                num = num * 10 + digit; //deal with numbers that are 2 spaces (ie 13 + 1)

            } else if ( c == '(') {
                stack.push(result);
                stack.push(sign);
                //reset values
                sign = 1;
                result = 0;

            } else if (c == '+' || c == '-') {
                //Store left side to result            
                result  += num * sign;
                //Reset values
                if(c == '-'){
                    sign = -1;
                } else {
                    sign = 1;
                }
                num =  0;

            } else if ( c == ')'){
                //Save current num to result
                result += num * sign;
                
                //Get values from stack
                int popSign  = stack.pop();
                int savedValue = stack.pop();

                result *= popSign;
                result += savedValue;

                //Reset operand
                num = 0;
            }           
        }
    
      return result + num * sign;  
    }
}