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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        ArrayList<Integer> list1 = new ArrayList<Integer>();
        ArrayList<Integer> list2 = new ArrayList<Integer>();
        leafNodes(root1, list1);
        leafNodes(root2, list2);
        System.out.println(list1.toString());
        System.out.println(list2.toString());
        return list1.equals(list2);
    }
    public static void leafNodes(TreeNode root, ArrayList list){
        if(root == null)
            return;
        if(root.left == null && root.right == null){
            list.add(root.val);
        }
        leafNodes(root.left, list);
        leafNodes(root.right, list);
    }
}