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
 
 Min depth - closest leaf node
 
          2 
    null    3
null   4 null 5
 
 MATCH
   Pre ORDER traversal
      P L R - stack
 
 Plan:
    queue
    depth 
    while queue  is not empty
         cur pop 
         if left not null 
           push  cur left
         if right not null
          push  cur right
          
        if left == null and right == null (LEAF)
                return depth
                
    if
    
DFS
  if node == null
    return 0
  if left is null
    return 1 + dfs(right)
    
 if right not
    return 1 + dfs left
    
else return 1 + min(dfs left, dfst right)
 
 */
class Solution {
    public int minDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        
        if (root.left == null){
            return 1 + minDepth(root.right);
        }
        if( root.right == null) {
            return 1 + minDepth(root.left);
        }
        
        return 1 + Math.min(minDepth(root.left), minDepth(root.right));
    }
}