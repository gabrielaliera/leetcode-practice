/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    
    /*
    ideas: find the last/tail of the list O(n)
    2 pointer - switch values until left pointer = right pointer
    issues no prev pointer in node
    
    idea 2: use external ds to store values
    iterate and switch values - like stack
    
    */
    public ListNode withStack(ListNode head){
        Stack<Integer> stack = new Stack<>();
        ListNode cur = head;
        while(cur != null){
            System.out.println(cur.val);
            stack.push(cur.val);
            cur = cur.next;
        }
        cur = head;
        while(cur != null){
            cur.val = stack.pop();
            cur = cur.next;
        }
        
        return head;
        
    }
  
    
    public ListNode reverseList(ListNode head) {
        //base case
        if(head == null){ return head;}
     
        ListNode prev = null;
        ListNode cur = head;
        
        while(cur != null ){
            //save cur.next to not lose
            ListNode temp = cur.next;
            //reserve the pointer
            cur.next = prev;
            //move prev pointer
            prev = cur;
            //move cur pointer
            cur = temp;
            
        }
        head = prev;
        
        return head;
    }
}