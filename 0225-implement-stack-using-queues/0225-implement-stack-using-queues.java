class MyStack {

    Queue<Integer> q;
    int top;
    
    public MyStack() {
        q = new LinkedList();
    }
    
    public void push(int x) {
        q.add(x);
        top = x;    
    }
    
    public int pop() {
        int count=1;
        int newTop=0;
        while( count <q.size()){
            newTop = q.peek();
            q.add(q.remove());
            count++;
            
        }
        top = newTop;
        return q.remove();
    }
    
    public int top() {
        return top;
    }
    
    public boolean empty() {
        return q.size() == 0;
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */