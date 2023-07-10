/*

input: 2 array
 always same size???
 
output boolean

push: this is order
pop :  permuation

When not true?


MAtch
 two pointer
   push to stack 1 2 3 4
   when stack  peek equal 2nd pointer
   pop 4 move pointer
   pop 3 move pointer
   not equal check push
     push 5
     pop 5
 12
  false because at end of pop and stakc is not empty

*/

class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
      Stack<Integer> stack = new Stack<>();
      
      int j = 0;
     
        for (int x: pushed) {
            stack.push(x);
            while (!stack.isEmpty() && 
                   j < pushed.length && 
                   stack.peek() == popped[j]) {
                stack.pop();
                j++;
            }
        }

            
        
        
        return stack.isEmpty();
        
    }
}