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
    public List<Integer> preorderTraversal(TreeNode root) {
        
        if (root == null) return new ArrayList<>();
        
        List<Integer> list = new ArrayList<>();

        Stack<TreeNode> st = new Stack<>();
        st.add(root);

        while (!st.isEmpty()) {
            TreeNode node = st.pop();
            list.add(node.val);

            if (node.right != null) st.add(node.right);
            if (node.left != null) st.add(node.left);
        }
        return list;
    }
}