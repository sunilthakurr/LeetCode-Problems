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
    public int sumRootToLeaf(TreeNode root) {
        return solve(root);
    }
    private int solve(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();

        q.add(root);
        q2.add(root.val);
        int res = 0;

        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            int val = q2.poll();

            if (node.left == null && node.right == null) {
                res += val;
            }
            if (node.left != null) {
                q.add(node.left);
                q2.add((val << 1) + node.left.val);
            }
            if (node.right != null) {
                q.add(node.right);
                q2.add((val << 1) + node.right.val);
            }
        }
        return res;
    }
}