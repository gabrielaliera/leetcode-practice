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
/*1) Base Case: check if the tree is empty. If it is, return a new TreeNode with node value of val
2) Recursively traverse the tree in pre-order fashion
    a) Compare the input value with the node values
        i) If input value > node.val: traverse the right subtree
        ii) traverse the left subtree
3) return the root of the tree
*/

// class Solution {
//     public TreeNode insertIntoBST(TreeNode root, int val) {
        
//         //Empty tree
//         if (root == null){
//           return new TreeNode(val);
//         }
                     
        
//         if( val < root.val){
//             root.left= insertIntoBST(root.left, val);
//         } else { 
//             root.right =insertIntoBST(root.right,val);
//         }     
          
//         return root;
        
//     }
// }

class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        
        if(root == null){  
            return new TreeNode(val);
        }
        
        if ( root.val < val ){
          root.right = insertIntoBST(root.right, val);  
        } else if ( root.val > val ){
            root.left = insertIntoBST(root.left, val);
        }
        
        return root;
    }
}