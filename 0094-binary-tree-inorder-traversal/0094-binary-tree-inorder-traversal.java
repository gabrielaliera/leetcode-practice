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


inorder - left parent right 


*/
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        
       List<Integer> list = new ArrayList<>(); 
      // return helper(root, list);
       return helperIter(root, list);
        
    }
    
    //Recursive
    public List<Integer> helper(TreeNode root, List<Integer> list){
        if(root == null) { return list;}
        
        helper(root.left, list);
        list.add(root.val);
        helper(root.right,list);
        
        return list;
        
    }
    
    
    //iterative
    public List<Integer> helperIter(TreeNode root, List<Integer> list){
        
        Stack<TreeNode> stack = new Stack<>();
        
        
        TreeNode cur = root;
        
        while(cur != null || !stack.isEmpty()){
            
            while(cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            list.add(cur.val);
            cur = cur.right;
        }
        
        return list;
    }
    
    
}