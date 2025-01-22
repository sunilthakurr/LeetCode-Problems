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
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        return solve(root);
    }
    public List<List<Integer>> solve(TreeNode root){
        
        // root -> row -> col
        Queue<Pair<TreeNode, Pair<Integer, Integer>>> q = new LinkedList<>();

        q.add(new Pair(root, new Pair(0, 0)));

        // col -> row -> all elements of that particular row
        HashMap<Integer, HashMap<Integer, List<Integer>>> map = new HashMap<>();

        int min = 0;
        int max = 0;

        while(!q.isEmpty()){
            TreeNode node = q.peek().getKey();
            int row = q.peek().getValue().getKey();
            int col = q.peek().getValue().getValue();

            q.poll();

            min = Math.min(min, col);
            max = Math.max(max, col);
            if(!map.containsKey(col)){
                List<Integer> list = new ArrayList<>();
                list.add(node.val);
                HashMap<Integer, List<Integer>> mp = new HashMap<>();
                mp.put(row, list);
                map.put(col, mp);
            }
            else{
                HashMap<Integer, List<Integer>> mp = map.get(col);
                if(!mp.containsKey(row)){
                    List<Integer> list = new ArrayList<>();
                    list.add(node.val);
                    mp.put(row, list);
                }
                else{
                    List<Integer> list = mp.get(row);
                    list.add(node.val);
                    Collections.sort(list);
                    mp.put(row, list);
                }
            }
            if(node.left != null){
                q.add(new Pair(node.left, new Pair(row + 1, col - 1)));
            }
            if(node.right != null){
                q.add(new Pair(node.right, new Pair(row + 1, col + 1)));
            }
        }
        List<List<Integer>> res = new ArrayList<>();
        // System.out.println(map.deepToString());

        for(int i = min; i <= max; i++){
            HashMap<Integer, List<Integer>> temp = map.get(i);
            List<Integer> arr = new ArrayList<>(temp.keySet());
            Collections.sort(arr);
            List<Integer> abc = new ArrayList<>();

            for(int k = 0; k < arr.size(); k++){
                List<Integer> bcd = temp.get(arr.get(k));

                for(int j = 0; j < bcd.size(); ++j){
                    abc.add(bcd.get(j));
                }
            }
            res.add(abc);
        }

        return res;
    }
}