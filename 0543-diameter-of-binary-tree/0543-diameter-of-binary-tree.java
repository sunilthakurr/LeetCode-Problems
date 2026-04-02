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
    int ans = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        // int ans = 0;
        int[] res = new int[1];
        solve(root, res);
        return res[0];
    }
    private int solve(TreeNode root, int[] res) {
        if (root == null) return 0;

        int lh = solve(root.left, res);
        int rh = solve(root.right, res);

        res[0] = Math.max(res[0], lh + rh);
        return 1 + Math.max(lh, rh);
    }
}