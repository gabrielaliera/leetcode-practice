class MinStack {

    public Stack<Integer> stack;
    public Stack<Integer> minStack;
   
    
    public MinStack() {
         stack = new Stack<>();
         minStack = new Stack<>();
    }
    
    public void push(int val) {
        stack.push(val);
        
        if(minStack.isEmpty() || val <= minStack.peek()){
            minStack.push(val);
            //System.out.println("minStack "+val);
        }
    }
    
    public void pop() {
        // System.out.println("pop "+minStack.peek());
          //System.out.println("popSt "+stack.peek());
        if ((int) minStack.peek() == (int) stack.peek()){
         //  System.out.println("REmoveminStack "+minStack.peek());
            minStack.pop();
        }
        stack.pop();
      
    }
    
    public int top() {
        return stack.peek();
        
    }
    
    public int getMin() {
        return minStack.peek();
           
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */