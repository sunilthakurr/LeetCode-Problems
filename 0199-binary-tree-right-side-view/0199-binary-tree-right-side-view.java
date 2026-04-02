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
    int maxDepth = 0;
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        solve(root, result, 1);
        return result;
    }
    private void solve(TreeNode root, List<Integer> res, int level) {
        if (root == null) return;

        if (maxDepth < level) {
            res.add(root.val);
            maxDepth = level;
        }
        solve(root.right, res, level + 1);
        solve(root.left, res, level + 1);
    }
}