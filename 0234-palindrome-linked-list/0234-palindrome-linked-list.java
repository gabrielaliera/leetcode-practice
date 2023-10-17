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
    
    public boolean isPalindrome(ListNode head) {
        
        //edge case head null
        
        //Use fast and slow to find middle
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        //reverse second half
        ListNode prev = null;
        ListNode cur = slow;
        ListNode next = null;
        
        while(cur != null){
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        ListNode secondStart = prev;      
        //check if palidrome - start of head and 2ndstart head
        
        while( secondStart != null ){
            if(head.val != secondStart.val){
                return false;
            }
            head = head.next;
            secondStart = secondStart.next;
        }
        return true;
    }
    
    
     
    
    
    
    
    public boolean isPalindrome2(ListNode head) {
         //edge cases
        if (head == null || head.next == null){
          return true;
        }
        //Step one: find the mid point and end of lisy
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){
          slow = slow.next;
          fast = fast.next.next;
        }

        //Step 2 - Reach mid point begin reversing the 2nd half
        ListNode prev = null;
        ListNode cur = slow;
        ListNode next = null;
        while(cur != null){
          next = cur.next;
          cur.next = prev;
          prev = cur;
          cur = next;
        }
        

      
        ListNode secondHalf = prev;
        //Step 3 Comapre start and end of linkedlist
        while( secondHalf != null){
          if(head.val != secondHalf.val){
            return false;
          }
          head = head.next;
          secondHalf = secondHalf.next;
        }


        return true;
    }
        
    
}