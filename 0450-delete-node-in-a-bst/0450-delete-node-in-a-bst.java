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
 
 
 Step 1: Search
 
 Step 2: delete
 
 delete 0 0r 1 children
 
 retun root.lefht
 
 delete w/ 2 children
   
   set parent.root.left = root.left
   (root.left).right = left
 */
class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        
        if(root== null){ return null;}
                
        //Search
        //Move to left
        if( key < root.val ){
            root.left = deleteNode(root.left, key);
        
        //Move to right
        } else if ( key > root.val) { 
         
            root.right = deleteNode(root.right, key);
            
        //Found node
        } else {
            //Step2: delete
            //0 or 1 child
            if(root.left == null){
                
                return root.right;
                
            } else if ( root.right == null){
                
                return root.left;
            // has 2 children -> replace with the smallest on the right subtree  
            } else {
                TreeNode minNode = root.right;
                
                while(minNode.left != null){
                    minNode = minNode.left;
                }
                
                //replace cur node with minNode value
                root.val = minNode.val;
                //remove node
                root.right = deleteNode(root.right, minNode.val);
            }
            
            
        }
        
        return root;
    }
    
    public TreeNode findMinNode(TreeNode root){
        
        TreeNode curr = root;
        
        while(curr.left != null){
            curr = curr.left;
        }
        return curr;        
    }
}