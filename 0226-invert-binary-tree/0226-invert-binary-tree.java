/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

/*
stack

post order: LR P :   1 3 2 6 9 7 add Top

pop: pre order
    add left  add right parent
   
          




*/
class Solution {
    public TreeNode invertTree(TreeNode root) {
        
        //Edge case
        if(root == null) return null;
        
        //Add to queue
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
    
        while( !queue.isEmpty()){
            
            TreeNode current = queue.poll();
            
           //Swap left and right children
            TreeNode temp = current.left;
            current.left = current.right;
            current.right = temp;
            
            if(current.left != null){
                queue.add(current.left);
            }
            if(current.right != null){
                queue.add(current.right);
            }
            
        }
        return root;
        
    }
}