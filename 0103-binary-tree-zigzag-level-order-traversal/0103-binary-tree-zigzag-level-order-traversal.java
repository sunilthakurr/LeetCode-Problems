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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        return solve(root);
    }

    private List<List<Integer>> solve(TreeNode root) {
        if (root == null)
            return new ArrayList<>();

        List<List<Integer>> res = new ArrayList<>();

        Queue<TreeNode> q = new LinkedList<>();

        q.add(root);

        boolean isLeftToRight = true;

        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> level = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                if (isLeftToRight) level.add(node.val);
                else level.addFirst(node.val);

                if (node.left != null) q.add(node.left);
                if (node.right != null) q.add(node.right);
            }
            isLeftToRight = !isLeftToRight;
            res.add(level);
        }
        return res;
    }
}