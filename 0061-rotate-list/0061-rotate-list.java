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
Rotate: means move last node to head
Happy: K = 2
1 2 3 4 5 
5 1 2 3 4 
4 5 1 2 3 Ans

Can k be 0?
Can linked list be 0 or 1?
What is only 1 node, can k = 3, ans = 1 node

Match:
 two pointer - head and tail
 Temp node to hold head

 Plan:
 
 find lenght
 set k = k % lenght
 while(k > 0)
  find last
  move tail
  rename 
 
*/
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        
        //Edge case
        if(head == null || head.next == null) return head;
       
        //find lenght
        ListNode curr = head;
        int size = 0;
        while(curr != null){
            curr = curr.next;
            size++;
        }
        k = k % size;
               
        
        while(k > 0){
            //Find tail
            ListNode tail  = head.next;
            ListNode prev = head;
        
            while (tail.next != null){
                prev = tail;
                tail = tail.next;
            }

            //Once at end, move tail to head
            tail.next = head;
            prev.next = null;

            //Rename
            head = tail;
            tail = prev;
            k--;
        }
        
        return head;
        
    }
}