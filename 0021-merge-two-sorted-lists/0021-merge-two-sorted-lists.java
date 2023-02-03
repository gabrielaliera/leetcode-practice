/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 
 inplace
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        
        ListNode cur1 = list1;
        ListNode cur2 = list2;
        
        //switch if val is smaller
        if(cur1 > cur2){
            ListNode temp = cur1;
            cur1 = cur2;
            cur2 = cur1;
        }
        
        while(cur1 != null){
            
            int nextVal = cur1.next;
            
            if(cur1.val == cur2.val){
                ListNode temp = cur1.next;
                cur1.next = cur2;
                cur2 = temp;  
                cur = cur.next;
            } else if(nextVal < cur2.val){
                ListNode temp = cur1.next;
                cur1.next = cur2;
                cur2 = temp;
                
                
            } else{ // cur1 < cur2
                cur1 = cur1.next;
            }
            //curr1 = cur1.next;
        }
        
    }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        
        ListNode cur1 = list1;
        ListNode cur2 = list2;
        
        ListNode ans = new ListNode();
        ListNode cur = ans;
      while(list1 != null && list2 != null){
          if(list1.val <= list2.val){
              cur.next = list1;
              list1 = list1.next;
          } else {
              cur.next = list2;
              list2 = list2.next;
          }
         cur = cur.next;
      }
      
      //set cur to the empty list
      if(list1 == null){
          cur.next = list2;
      }else{
          cur.next = list1;
      }
      return ans.next;
    }
}