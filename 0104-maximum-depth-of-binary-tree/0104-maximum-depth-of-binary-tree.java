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
        return DepthFinder(root);
    }
    public int DepthFinder(TreeNode root){
     
        if(root == null)
            return 0;
        
        int count = DepthFinder(root.left);
        int flag = DepthFinder(root.right);
        return Math.max(count, flag) + 1;
    }
}