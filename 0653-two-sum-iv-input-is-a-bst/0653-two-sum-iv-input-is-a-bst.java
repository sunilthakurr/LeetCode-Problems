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
    public boolean findTarget(TreeNode root, int k) {
        if(root == null) return false;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()) {
            TreeNode node = q.poll();
            if(isPossible(root, node, k - node.val)) return true;
            if(node.left != null) {
                q.add(node.left);
            }
            if(node.right != null) {
                q.add(node.right);
            }
        }
        return false;
    }
    public boolean isPossible(TreeNode root, TreeNode node, int val) {
        if(root == null) return false;
        if(root.val == val && root != node) return true;

        if(root.val > val) {
            return isPossible(root.left, node, val);
        }
        else {
            return isPossible(root.right, node, val);
        }
    }
}