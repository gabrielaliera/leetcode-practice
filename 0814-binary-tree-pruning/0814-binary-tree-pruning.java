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
 
 undersand
  give rootd
    remove subtree with no 1
    
  dfs -  preorder
  
  Assume that 1 root is always true
  
  Plan:
    containsOne = true
 dfs
 
     if root.val == 1 || containOne == true
          containsOne == true
          
    if root == null{
     return false
    }
    
    if (root.left == null)   
        return dfs(right, containsOne)
    if (right == null)
       reuturn dfs(left, contiansOne)
   
   
   return  
 
 */
class Solution {
    public TreeNode pruneTree(TreeNode root) {
        return containsOne(root) ? root : null;
    }
    
    public boolean containsOne(TreeNode node) {
        if (node  == null) return false;
        
        boolean leftContainsOne = containsOne(node.left);
        
        boolean rightContainsOne = containsOne(node.right);
        
        // If the left subtree does not contain a 1, prune the subtree.
        if (!leftContainsOne) node.left = null;
        
        // If the right subtree does not contain a 1, prune the subtree.
        if (!rightContainsOne) node.right = null;
        
        return node.val == 1 || leftContainsOne || rightContainsOne;
    }
}