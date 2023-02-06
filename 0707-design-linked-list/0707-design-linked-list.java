
public class Node{
    int val;
    Node next;
    Node prev;
    Node(){};
    
    Node(int x){
        val = x;
    }
}

class MyLinkedList {

     
    int size;
   
    Node head;
    Node tail;
        
    
    public MyLinkedList() {
       size = 0;
       this.head = new Node(0);
       this.tail = new Node(0);
       head.next = tail;
       tail.prev = head;
    }
    
    public int get(int index) {
        
        if(index < 0 || index >= size){ return -1;}
        
        Node cur = head.next;
        
        while(cur != null && index > 0){
            cur = cur.next;
            index --;
        }
        return cur.val;
        
    }
    
    public void addAtHead(int val) {
        Node toAdd = new Node(val);
        
        Node next = head.next;
        Node prev = head;
        
        
        toAdd.next = next;
        toAdd.prev = prev;
        
        prev.next = toAdd;
        next.prev = toAdd;
        
        size++;
      //  System.out.println("head: "+ head.next.val);
        
    }
    
    public void addAtTail(int val) {
        Node toAdd = new Node(val);
        
        Node next = tail;
        Node prev = tail.prev;
        
        toAdd.next = next;
        toAdd.prev = prev;
        
        prev.next = toAdd;
        next.prev = toAdd;
         
        size++;
        //System.out.println("tail: "+ tail.prev.val);
      
    }
    
    public void addAtIndex(int index, int val) {
        
        //System.out.print("add at index size:"+ size);
        
        //edge cases
        if(index < 0 || index > size){
            //System.out.println("out of range add at index");
            return;}
        
        //create new node
        Node toAdd = new Node(val);
        
        
        Node cur = head.next;
        
        if(index == 0){
            addAtHead(val);
        } else if (index == size){
            addAtTail(val);
        
        } else{
            
             
            //Iterate to find cur at index
            for(int i = 0; i < index ; i++){
                cur = cur.next;
                System.out.println(i+" "+cur.val);
            } 
            
            Node before = cur.prev;
            
            toAdd.prev = before;
            toAdd.next = cur;
            
            before.next = toAdd;
            cur.prev = toAdd;
            size++;
            
        }
    }
    
    public void deleteAtIndex(int index) {
       
        
        if(index > -1 && index >= size){ 
            return;
        } else{
            Node toDelete = head.next;
        
            //Iterate to find cur at index
            for(int i = 0; i < index ; i++){
              //  System.out.println(toDelete.val+"  ");
                toDelete = toDelete.next;
            } 
            //System.out.println(head.next.val);
          //  System.out.println(head.next.next.val);
           // System.out.println(head.next.next.next.val);
            //System.out.println("fgsf"+toDelete.val);
            
            Node before = toDelete.prev;
            Node after = toDelete.next;
            
            before.next = after;
            after.prev = before;
            
            toDelete.next = null;
            toDelete.prev = null;
           // System.out.println("Delete: "+ toDelete.val);
            
        }
             
        size--;
        
    }
    
  
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */