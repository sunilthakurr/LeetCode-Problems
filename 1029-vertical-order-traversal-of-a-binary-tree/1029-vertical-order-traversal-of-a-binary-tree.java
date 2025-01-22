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
        TreeMap<Integer, TreeMap<Integer, List<Integer>>> map = new TreeMap<>();
        
        q.add(new Pair(root, 0, 0));
        
        while(!q.isEmpty()) {
            int size = q.size();
            
            for(int i = 0; i < size; i++) {
                TreeNode node = q.peek().node;
                int row = q.peek().row;
                int col = q.peek().col;
                q.poll();
                
                if(!map.containsKey(col)) {
                    TreeMap<Integer, List<Integer>> colMap = new TreeMap<>();
                    List<Integer> list = new ArrayList<>();
                    list.add(node.val);
                    colMap.put(row, list);
                    map.put(col, colMap);
                }
                else {
                    TreeMap<Integer, List<Integer>> colMap = map.get(col);
                    if(!colMap.containsKey(row)) {
                        List<Integer> list = new ArrayList<>();
                        list.add(node.val);
                        colMap.put(row, list);
                    }
                    else {
                        List<Integer> list = colMap.get(row);
                        list.add(node.val);
                        colMap.put(row, list);
                    }
                    map.put(col, colMap);
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
            TreeMap<Integer, List<Integer>> colMap = entry.getValue();
            List<Integer> list = new ArrayList<>();
            for(Map.Entry<Integer, List<Integer>> colEntry: colMap.entrySet()) {
                List<Integer> rowList = colEntry.getValue();
                Collections.sort(rowList);
                list.addAll(rowList);
            }
            res.add(list);
        }
        return res;
    }
}