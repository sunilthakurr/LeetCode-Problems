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
        int row;
        int col;

        public Pair (TreeNode node, int row, int col) {
            this.node = node;
            this.row = row;
            this.col = col;
        }
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        return solve(root);
    }
    private List<List<Integer>> solve(TreeNode root) {
        if (root == null) return new ArrayList<>();

        

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0, 0));

        // row --> col --> val
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                Pair pair = q.poll();

                TreeNode node = pair.node;
                int row = pair.row;
                int col = pair.col;

                if (pair.node.left != null) {
                    q.add(new Pair(pair.node.left, row - 1, col + 1));
                }
                if (pair.node.right != null) {
                    q.add(new Pair(pair.node.right, row + 1, col + 1));
                }

                if (!map.containsKey(pair.row)) {
                    map.put(pair.row, new TreeMap<>());
                }
                if (!(map.get(pair.row).containsKey(pair.col))) {
                    map.get(pair.row).put(pair.col, new PriorityQueue<>());
                }
                // map.get(pair.row).get(pair.col).add(new PriorityQueue<Integer>());
                // PriorityQueue<Integer> pq = map.get(pair.row).get(pair.col);
                // pq.add(pair.node.val);
                // if (map.get(pair.row).get(pair.col) == null) {
                //     PriorityQueue<Integer> pq = new PriorityQueue<>();
                //     map.get(pair.row).put(pair.col,pq);
                // }
                map.get(pair.row).get(pair.col).add(pair.node.val);
            }
        }

        List<List<Integer>> res = new ArrayList<>();
        for (TreeMap<Integer, PriorityQueue<Integer>> key: map.values()) {
            List<Integer> list = new ArrayList<>();

            for (PriorityQueue<Integer> pq: key.values()) {
                while (!pq.isEmpty()) {
                    list.add(pq.poll());
                }
            }
            res.add(list);
        }
        return res;
    }
}