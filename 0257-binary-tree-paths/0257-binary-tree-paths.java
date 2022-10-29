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
    private List<String> ans;

    public List<String> binaryTreePaths(TreeNode root) {
        ans = new ArrayList<String>();

        helper(root, "");

        return ans;
    }

    private void helper(TreeNode root, String path) {
        if(root == null) {
            return; // empty list
        }
        if(root.left == null && root.right == null) {
            ans.add(path + root.val);
            return;
        }
        helper(root.left, path + root.val + "->");
        helper(root.right, path + root.val + "->");

    }

}