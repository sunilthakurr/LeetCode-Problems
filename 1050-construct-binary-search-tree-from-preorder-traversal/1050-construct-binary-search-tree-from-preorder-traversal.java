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

    public int i  = 0;
    public TreeNode bstFromPreorder(int[] preorder) {
        return bstfropreorder(preorder,Integer.MAX_VALUE);
    }
public TreeNode bstfropreorder(int[] A,int bound){
    System.out.println(i);
        if(i==A.length || A[i]>bound) return null;
        TreeNode root = new TreeNode(A[i++]);
        root.left = bstfropreorder(A,root.val);
        root.right = bstfropreorder(A,bound);
        return root;

    }
}