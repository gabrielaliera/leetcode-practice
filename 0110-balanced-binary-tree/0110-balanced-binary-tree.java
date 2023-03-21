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

final class TreeInfo {
    public final int height;
    public final boolean balanced;
    
    public TreeInfo(int h, boolean b){
        this.height = h;
        this.balanced = b;
    }
}


class Solution {
    public boolean isBalanced(TreeNode root) {
        
        return helper(root).balanced;
    
    }
    
    private TreeInfo helper(TreeNode root){
        if (root == null) { 
            return new TreeInfo(-1, true);
        }
        
        
        TreeInfo left = helper(root.left);
        if(!left.balanced){return new TreeInfo(-1, false);}
        
        
        TreeInfo right = helper(root.right);
        if(!right.balanced){return new TreeInfo(-1, false);}
        
      
        
         if (Math.abs(left.height - right.height) < 2) {
            return new TreeInfo(Math.max(left.height, right.height) + 1, true);
        }
        return new TreeInfo(-1, false);
    }
    
    
}