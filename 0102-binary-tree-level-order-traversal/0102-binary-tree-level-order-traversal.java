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
    public List<List<Integer>> levelOrder(TreeNode root) {
    
        List<List<Integer>> res = new ArrayList<>();
        if(root == null){ return res;}
     
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int depth = 0;

    //Create hashmap - depth, linkedlist
    //HashMap<Integer, LinkedList<TreeNode>> map = new HashMap<>();
    

        while(!queue.isEmpty()){
          
            res.add(new ArrayList<Integer>());
         
            int level = queue.size();
            
            for(int i = 0; i < level; ++i) {
                 TreeNode parent = queue.remove();
                
                res.get(depth).add(parent.val);
                
                //Add child to queue
                 if(parent.left != null){
                    queue.add(parent.left);
                 }
                  if(parent.right != null){
                    queue.add(parent.right);
                  }
             }
            depth++;
        }
        
        return res;
    }
}