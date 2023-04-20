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
 
 Plan: 
    do inorder traversal until kth time
 */
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        
        List<Integer> list = new ArrayList<>();
        list = helper(root, list,k);
        
        return list.get(k-1);
        
    }
    
    public List<Integer> helper(TreeNode root, List<Integer> list, int k){
        if(root == null) {return list;}
        
        helper(root.left,list, k);
        list.add(root.val);
        k--;
        if(k == 0){
            return list;
        }
      
        helper(root.right, list, k);
        
        return list;
    }
}