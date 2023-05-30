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

//Understand

Input: l1 = [9,9,9,9,9,9,9], 
       l2 = [9,9,9,9]
             8 9 9 9 0 0 0 1
           Output: [8,9,9,9,0,0,0,1]
           
Input: l1 = [9,9,9,9,9,9,9], 
       l2 = [9,9,9,9]
             8 9 
    Output: [8,9,9,9,0,0,0,1]
    
//move point
if(x = null) set to 0
if y == null set to 0

//find total
total = num1 + num2 + total


/* if total under ten
  result.val = total
  remainder = 0  
  
  if total over ten
  result.val = total - 10; to get single digit
  remainder = 1

*/

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    
    ListNode x = l1;
    ListNode y = l2;
    
    ListNode result = new ListNode();
    ListNode cur = result;
    int remainder = 0;
    int num1;
    int num2;
    
    while(x != null || y != null || remainder == 1){
        
        
        if(x == null){
          num1 = 0;
        } else {
          num1 = x.val;
          x = x.next;
        }
        
        if(y == null){
            num2 = 0;
        } else{
           num2 = y.val;
           y = y.next;
        }
         
         //Find total
        int total = num1 + num2 + remainder;
        ListNode node = new ListNode();
        
        //Total over ten
        if(total >= 10){
            remainder = 1;
            node.val = total - 10;
       
       //total under ten
       } else {
           node.val = total;
           remainder = 0;
           
        }
        //move to next digit
        cur.next = node;
        cur = cur.next;
        
    }
        
        return result.next;
        
    }
}