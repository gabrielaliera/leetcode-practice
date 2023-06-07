/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/*
U:

no access to head

given node: not last node, but can be head

1 > 2 > 3 > 4   ->  1  > 2 > 3

P: ( how to get previos node)- cant
copy the data
step 1 : set pointer to node
Step 2 copy data of next node to current node
step 3 set node next to node next next

*/
class Solution {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
        
    }
}