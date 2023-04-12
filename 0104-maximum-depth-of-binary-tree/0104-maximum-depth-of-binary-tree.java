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
        
        // return helper(root);
       // return itDFS(root);
        return ItBFS(root);
        
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
       
        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> depths = new Stack<>();
        stack.push(root);
        depths.push(1);
        int depth = 0;
        int current_depth = 0;
        
        while(!stack.isEmpty()){
            //pop
            TreeNode cur = stack.pop();
            current_depth = depths.pop();
            System.out.println(cur.val +" "+ "depth "+ current_depth);
           
            if(cur != null){
                depth = Math.max(depth, current_depth);                
                //add child to queue
                stack.push(root.left);
                stack.push(root.right);
                //add depth
                depths.push(current_depth +1);
                depths.push(current_depth +1);
            }
        }
       return depth; 
    }
    
    public int ItBFS(TreeNode root){
        
        if(root == null){return 0;}
        
        Queue<TreeNode> queue = new LinkedList<>();
        
        queue.add(root);
        int depth = 0;
        
        while(!queue.isEmpty()){
                       
            int levelsize = queue.size();
            
            for(int i=0; i< levelsize; i++){
                TreeNode cur = queue.remove();
            
                if(cur.left != null){
                    queue.add(cur.left);
                }
                
                if(cur.right != null){
                    queue.add(cur.right);
                }
                System.out.println(cur.val +" "+ "depth "+ depth);
            }
            depth++;
            
        }
        return depth;
        
    }
}