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
//Plan
//Start at the middle of the array
// insert left and right at the same time
// insert again 
class Solution {
    
    int[]nums;
    
    public TreeNode helper(int left, int right){
        if(left > right){
            return null;
        }
        
        int p = (left +right)/2;
        System.out.print("p: "+ p);
        if((left+ right) % 2  == 1){
            p++;
        }
        System.out.println(p);
        TreeNode root = new TreeNode(nums[p]);
        
        root.left= helper(left, p-1);
        root.right = helper(p+1,right);
        
        return root;
    }
    
    
    public TreeNode sortedArrayToBST(int[] nums) {
        
        this.nums = nums;
        return helper(0, nums.length-1);
    }
}