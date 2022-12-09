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
    public int maxAncestorDiff(TreeNode root) {
        return depthFirstSearch(root, root.val, root.val);
    }

    public int depthFirstSearch(TreeNode node, int minimum, int maximum) {
        if (node == null)
            return Integer.MIN_VALUE;

        minimum = Math.min(minimum, node.val);
        maximum = Math.max(maximum, node.val);

        int lMaximum = depthFirstSearch(node.left, minimum, maximum);
        int rMaximum = depthFirstSearch(node.right, minimum, maximum);
        return Math.max(maximum - minimum, Math.max(lMaximum, rMaximum));
    }
}
