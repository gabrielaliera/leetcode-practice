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
class Solution {
    public int maxDepth(TreeNode root) {
        
         return helper(root);
        
    }
    //Recursive Depth first search
    public int helper( TreeNode root){
        
        if(root == null){ return 0;}
        
       int left =  helper(root.left);
       int right = helper(root.right);
           
      return Math.max(left,right) +1 ;
    }
    
    //Iterative DFS
    public int itDFS (TreeNode root){
       
        Queue<TreeNode> queue = new LinkedList<>();
        Stack<Integer> depths = new Stack<>();
        queue.add(root);
        depths.add(1);
        int depth = 0;
        int current_depth = 0;
        
        while(!queue.isEmpty()){
            //pop
            TreeNode cur = queue.remove();
            current_depth = depths.pop();
           
            if(cur != null){
                depth = Math.max(depth, current_depth);                
                //add child to queue
                queue.add(root.left);
                queue.add(root.right);
                //add depth
                depths.add(current_depth +1);
                depths.add(current_depth +1);
            }
        }
       return depth; 
    }
}