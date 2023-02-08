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
        
      //  System.out.println(currentURL.prev.val +"-"+ currentURL.val);
       //System.out.println("head"+"-"+head.val);
       // print(this.head);
    }
    
    public String back(int steps) {
        
        Node cur = currentURL;
      //  System.out.println("\n"+cur.val+" "+cur.prev.val+steps);
        
        while(steps > 0 &&  cur != head ){
        //    System.out.println(steps);
            cur = cur.prev;
            steps--;
        }
        
        // if(cur.val.equals("")){
        //     currentURL = head.next;
        //     return head.next.val;
        // }
        
        currentURL = cur;
       // System.out.print("\nBack:"+cur.val);
      //  print(this.head);
        
        return cur.val;
        
    }
    
    public String forward(int steps) {
        
        Node cur = currentURL;
    
        
        while(steps > 0 && cur.next != null){
            System.out.print(cur.val+ " "+steps);
            cur = cur.next;
            steps --;
             System.out.print(cur.val+ " "+steps);
        }
        
        if(cur == null){
            cur = cur.prev;
        }
    // System.out.print("\nForward"+cur.val+" "+steps);
        
        //Reset currentURL
        currentURL = cur;
        
      //  print(this.head);
        return cur.val;
        
        
    }
    public void print(Node head){
        System.out.println();
        while(head != null){
            System.out.print(head.val+" ");
            head = head.next;
        }
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */