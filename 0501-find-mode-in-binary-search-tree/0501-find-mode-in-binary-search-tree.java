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
 import java.util.Map.Entry;
class Solution {
    public int[] findMode(TreeNode root) {

        HashMap<Integer, Integer> freq = new HashMap<>();
        traverse(root, freq);
        List<Integer> list = new ArrayList<>();
        int maxFreq = (Collections.max(freq.values()));
        
        for(Entry<Integer, Integer> entry : freq.entrySet()){
            if(entry.getValue() == maxFreq){
                list.add(entry.getKey());
            }
        }
        int[] res = new int[list.size()];
        for(int i = 0; i < list.size(); ++i){
            res[i] = list.get(i);
        }
        return res;
        
    }
    public static void traverse(TreeNode root, HashMap<Integer, Integer> freq){
        if(root == null){
            return;
        }
        int val = root.val;
        if(!freq.containsKey(val)){
            freq.put(val, 1);
        }
        else{
            freq.put(val, freq.get(val) + 1);
        }
        traverse(root.left, freq);
        traverse(root.right, freq);
    }
}