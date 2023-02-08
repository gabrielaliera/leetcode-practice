class Node{
    String val;
    Node next;
    Node prev;
    
    Node(){}
    
    Node(String url){
        this.val = url;
    }
}



class BrowserHistory {

    int size;
    Node head;
    Node currentURL;
    
    public BrowserHistory(String homepage) {
       
       this.head = new Node(homepage);        
       this.currentURL = head;   
    }
    
    public void visit(String url) {
        Node toVisit = new Node(url);
        
        toVisit.next = null;  
        toVisit.prev = currentURL;
        
        currentURL.next = toVisit;
        
        currentURL = toVisit;
    }
    
    public String back(int steps) {
        
        Node cur = currentURL;
    
        while(steps > 0 &&  cur != head ){
            cur = cur.prev;
            steps--;
        }
        
        // if(cur.val.equals("")){
        //     currentURL = head.next;
        //     return head.next.val;
        // }
        
        currentURL = cur;
     
        return cur.val;
        
    }
    
    public String forward(int steps) {
        
        Node cur = currentURL;
    
        
        while(steps > 0 && cur.next != null){
            cur = cur.next;
            steps --;
        }
        
        if(cur == null){
            cur = cur.prev;
        }
    
        //Reset currentURL
        currentURL = cur;
        
      //  print(this.head);
        return cur.val;
        
        
    }
    
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 // public void print(Node head){
    //     System.out.println();
    //     while(head != null){
    //         System.out.print(head.val+" ");
    //         head = head.next;
    //     }
    // }
 */