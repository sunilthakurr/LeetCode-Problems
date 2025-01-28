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
    public int amountOfTime(TreeNode root, int start) {
       HashMap<Integer, List<Integer>> map = new HashMap<>();
        solve(root, map);
        // for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
        //     System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        // }
        
        List<Integer> result = new ArrayList<>();

        Queue<Integer> q = new LinkedList<>();
        // int destination = target.val;
        q.add(start);
        Set<Integer> vis = new HashSet<>();
        vis.add(start);
        int dist = 0;

        while(!q.isEmpty()) {
            int size = q.size();

            for(int i = 0; i < size; i++) {
                int adjacentNode = q.poll();
                // System.out.println("adjacentNode :-"+adjacentNode);
                // System.out.println("adjacent ka partner :- "+map.get(adjacentNode));
                vis.add(adjacentNode);
                for(int el: map.get(adjacentNode)) {
                    if(!vis.contains(el))
                        q.add(el);
                }
            }
            ++dist;
        }
        // while(!q.isEmpty()) result.add(q.poll());
        // return result;
        return dist - 1;
    }
    public void solve(TreeNode root, HashMap<Integer, List<Integer>> map) {
    if (root == null) return;

    if (root.left != null) {
        List<Integer> list = map.getOrDefault(root.val, new ArrayList<>());
        list.add(root.left.val);
        map.put(root.val, list);

        List<Integer> list2 = map.getOrDefault(root.left.val, new ArrayList<>());
        list2.add(root.val);
        map.put(root.left.val, list2);

        solve(root.left, map);
    }

    if (root.right != null) {
        List<Integer> list = map.getOrDefault(root.val, new ArrayList<>());
        list.add(root.right.val);
        map.put(root.val, list);

        List<Integer> list2 = map.getOrDefault(root.right.val, new ArrayList<>());
        list2.add(root.val);
        map.put(root.right.val, list2);

        solve(root.right, map);
    }
    if(root.left == null && root.right == null && !map.containsKey(root.val)) map.put(root.val, new ArrayList<>());
}
}