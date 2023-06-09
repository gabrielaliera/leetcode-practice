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
/*
U:
even swap 12 34 56
old swap 12 3
[] = [] - edge
1 = 1 -edge
12 = 21 -happy
return head -> temp/dummy heaed

match: 
 2 pointer - swap
 
 plan
  create temp head
  
  //edge 
  if head = null or head.next = null  return head
  
  Step 1 : create first and second
  first 
  second
        what if pointer = null
            return head
  step 2: swap
  
  Step 3 : move pointers
  
  
*/
class Solution {
    public ListNode swapPairs(ListNode head) {
       
        //edge case
        if (head == null || head.next == null) return head;
        
        //temp head
        ListNode result = new ListNode(0);
        result.next = head; //one
        
        ListNode prev = result;
             
        
        //Swap iteration
        while(head != null && head.next != null){
            
            //Create pointers
            
            ListNode first = head;
            ListNode second = head.next;
                                  
            //Swap
            prev.next = second;
            first.next = second.next;
            second.next = first;
            
            
            //Move pointers
            prev = first;
            head = first.next;
        }
        return result.next;
    }
}