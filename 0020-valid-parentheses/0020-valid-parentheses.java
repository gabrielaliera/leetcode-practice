class Solution {
    public boolean isValid(String s) {
//         final String opening = "({[";
//         final String closing = ")}]";

//         Stack<String> myStack = new Stack<>();
    
//         //basecase if string is not even
//         if(s.length() % 2 != 0) return false;
        
        
//         String[]  array = s.split("");

//         for(String c : array){
          
//           if(opening.indexOf(c) != -1){ //Symbol found in opening string
//               myStack.push(c);
          
//           } else if( closing.indexOf(c) != -1){ //Symbol found in closing string

//             if(myStack.empty()){
//               return false;
//             }

//             if(opening.indexOf(myStack.pop()) != closing.indexOf(c)){ //Compare top of stack w/ current c
//               return false;
//             }
//           } //if symbol not found in opening/closing string (ie a,+,b,etc) skip to next element in array
//         }//end for
//         return myStack.empty();
       
        
        
        //Sol #2 with hashmap
        HashMap<Character, Character> brackets =  new HashMap<>();
        brackets.put('}','{');
        brackets.put(']','[');
        brackets.put(')','(');
        
        Stack<Character> stack = new Stack<>();
        for(Character c : s.toCharArray()){
            
            //if has closing bracket
            if(brackets.containsKey(c)){
                
                if(stack.isEmpty()){return false;}
                
                //if opening bracket doenst match top of stack
                if(brackets.get(c) != stack.peek()){
                    return false;
                } else{
                    stack.pop();
                }
                
            } else {
                //is opening
                stack.push(c);
            }
        }
        
        return stack.isEmpty();
        
    }
}