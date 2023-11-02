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

    public int averageOfSubtree(TreeNode root) {
        subtreeSum(root);
        return ans;
    }

    // function to calculate sum of all nodes in subtree
    private int[] subtreeSum(TreeNode root){
        // base condition
        if(root == null)
            return new int[]{0, 0};

        // for leaf nodes
        if(root.left == null && root.right == null){ 
            ans++;
            return new int[]{root.val, 1};
        }

        int[] leftSum = subtreeSum(root.left);
        int[] rightSum = subtreeSum(root.right);
        if((leftSum[0] + rightSum[0] + root.val) / (leftSum[1] + rightSum[1] + 1) == root.val)
            ans++;

        return new int[] {(leftSum[0] + rightSum[0] + root.val), (leftSum[1] + rightSum[1] + 1)};
    }
}