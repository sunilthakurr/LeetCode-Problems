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
    class Pair {
        TreeNode node;
        int index;

        public Pair(TreeNode node, int index) {
            this.node = node;
            this.index = index;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        if(root == null) return 0;

        Queue<Pair> q = new LinkedList<>();

        int res = 0;
        q.add(new Pair(root, 0));

        while(!q.isEmpty()) {
            int size = q.size();

            int start = 0, last = 0;
            int minIndex = q.peek().index;
            for(int i = 0; i < size; i++) {
                int curId = q.peek().index - minIndex;
                TreeNode node = q.poll().node;

                if(i == 0) start = curId;
                if(i == size - 1) last = curId;
                
                if(node.left != null) {
                    q.add(new Pair(node.left, 2 * curId + 1));
                }
                if(node.right != null) {
                    q.add(new Pair(node.right, 2 * curId + 2));
                }
            }
            res = Math.max(res, last - start + 1);
        }
        return res;
    }
}