import java.util.Stack;

class MyQueue {
   
   Stack<Integer> stackA;
   Stack<Integer> stackB;
   int size;
   int top;

    public MyQueue() {
         stackA = new Stack<>();
         stackB = new Stack<>();
         size = 0;
        
    }
    
    public void push(int x) {
        stackA.push(x);
        
        if(stackA.size() == 1){
            top = x;
        }
        size++;
    }
    
    public int pop() {
            //move all elements to 2nd stack
        if(stackA.size() == 1){
            size--;
            return stackA.pop();
        }
        
        while(!stackA.isEmpty()){
          stackB.push(stackA.pop());
        }
        //top of stackB is top of queue
        int ans = stackB.pop();
        size--;
        top = stackB.peek();

        //return all elements to 1st stack
        while(!stackB.isEmpty()){
          stackA.push(stackB.pop());
        }
        return ans;
        
    }
    
    public int peek() {
        return top;
    }
    
    public boolean empty() {
       return size == 0;
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */