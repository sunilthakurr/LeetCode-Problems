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
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> inorder = new ArrayList<>();
        solve(root, inorder);
        System.out.println(inorder);
        return inorder.get(k - 1);
    }
    public void solve(TreeNode root, List<Integer> inorder) {
        if(root == null) return;
        solve(root.left, inorder);
        inorder.add(root.val);
        solve(root.right, inorder);
    }
}