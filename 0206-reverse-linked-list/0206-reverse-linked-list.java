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
        
        // ListNode cur = head;
        // int num = head.val;
        // while(cur.next != null){
        //     cur = cur.next;
        // }
        // int temp = cur.val;
        // cur.val = num;
        // head.val = temp;
        
        
        return withStack(head);
    }
}