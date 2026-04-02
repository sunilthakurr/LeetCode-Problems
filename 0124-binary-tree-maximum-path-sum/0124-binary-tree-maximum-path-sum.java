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
    public int maxPathSum(TreeNode root) {
        int[] res = new int[1];
        res[0] = Integer.MIN_VALUE;
        solve(root, res);
        return res[0];
    }

    private int solve(TreeNode root, int[] res) {
        if (root == null) return 0;

        int leftSum = Math.max(0, solve(root.left, res));
        int rightSum = Math.max(0, solve(root.right, res));
        res[0] = Math.max(res[0], leftSum + rightSum + root .val);
        return root.val + Math.max(leftSum, rightSum);
    }
}