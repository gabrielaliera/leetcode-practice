/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
/*
U: cycle mean never ending
edge case: zero node return false
edge case: 1 node return false
Min for cycle: 2 nodes

Match:
    hashmap : time o(n) space O(n)
    two pointer: fast and slow: time o(n) space o(1)
    
plan
    creat fast and slow pointer to head
    
    step 2
        iternate until slow  = null mean hit end of list
        
    step 3
        check if fast == slow
            Yes: return true
        NO:: continue
            slow ++
            fast += 2
            
    
*/
public class Solution {
    //old solution from before 
    public boolean hasCycle(ListNode head) {
        
        if(head == null || head.next == null){return false;} 
       
       ListNode slow = head;
       ListNode fast = head.next;
         
        while(slow != fast){
            
            if(fast == null || fast.next == null){
                return false;
            }
             slow = slow.next;
             fast = fast.next.next;
         }
         return slow  == fast;
    }
    
    //Incorrect
    public boolean hasCycle2(ListNode head){
        
        //Edge case
        if ( head == null || head.next == null) {return false;}
        
        ListNode slow = head;
        ListNode fast = head.next;
        
        while(fast != null || fast.next != null){
            
            if(slow.val == fast.val){
                return true;
            } else {
                slow = slow.next;
                fast = fast.next.next; // issues with [1, 2] fast.next is null so cant go to fast.next
            }
        }
        return false;
    }
}

/*
[] expect false - edge case
[1] expect false - edge case
[1, 2] -1  Expect false
[1, 2] 0   1 2  2 2 expect true
*/