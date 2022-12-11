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
    // 2:02
    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return helper(root)[1];
    }
    
    public int[] helper(TreeNode root) {
        if (root == null) {
            return new int[]{0, Integer.MIN_VALUE};
        }
        int[] left = helper(root.left);
        int[] right = helper(root.right);
        int first = Math.max(0, Math.max(left[0], right[0])) + root.val;
        int sec = Math.max(root.val + left[0] + right[0], Math.max(first, Math.max(left[1], right[1])));
        return new int[]{first, sec};
    }
}
