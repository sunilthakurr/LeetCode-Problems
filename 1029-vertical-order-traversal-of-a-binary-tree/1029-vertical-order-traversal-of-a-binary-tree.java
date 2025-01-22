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

        public Pair(TreeNode node, int row, int col) {
            this.node = node;
            this.row = row;
            this.col = col;
        }
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Queue<Pair> q = new LinkedList<>();

        q.add(new Pair(root, 0, 0));


        TreeMap<Integer, TreeMap<Integer, List<Integer>>> map = new TreeMap<>();

        int[] rDir = {-1, 0, 1, 0};
        int[] cDir = {0, 1, 0, -1};

        while(!q.isEmpty()) {
            int size = q.size();

            for(int i = 0; i < size; i++) {
                TreeNode node = q.peek().node;
                int row = q.peek().row;
                int col = q.peek().col;
                q.poll();

                if(!map.containsKey(col)) {
                    List<Integer> list = new ArrayList<>();
                    list.add(node.val);
                    TreeMap<Integer, List<Integer>> rowMap = new TreeMap<>();
                    rowMap.put(row, list);
                    map.put(col, rowMap);
                }
                else {
                    TreeMap<Integer, List<Integer>> rowMap = map.get(col);
                    
                    if(!rowMap.containsKey(row)) {
                        List<Integer> list = new ArrayList<>();
                        list.add(node.val);
                        rowMap.put(row, list);
                    }
                    else {
                        List<Integer> list = rowMap.get(row);
                        list.add(node.val);
                        rowMap.put(row, list);
                    }
                    map.put(col, rowMap);
                }
                if(node.left != null) {
                    q.add(new Pair(node.left, row + 1, col - 1));
                }
                if(node.right != null) {
                    q.add(new Pair(node.right, row + 1, col + 1));
                }
            }
        }
        List<List<Integer>> res = new ArrayList<>();

        for(Map.Entry<Integer, TreeMap<Integer, List<Integer>>> entry: map.entrySet()) {
            TreeMap<Integer, List<Integer>> rowMap = entry.getValue();
            List<Integer> finalList = new ArrayList<>();
            for(Map.Entry<Integer, List<Integer>> rowEntry: rowMap.entrySet()) {
                List<Integer> list = rowEntry.getValue();
                Collections.sort(list);
                finalList.addAll(list);
            }
            res.add(finalList);
        }
        return res;
    }
}