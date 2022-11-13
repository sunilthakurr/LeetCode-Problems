/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
       if (original == null )
			return cloned;
        else if(original == target)
            return cloned;
		TreeNode result = getTargetCopy(original.left, cloned.left, target);
		if (result != null)
			return result;
		return getTargetCopy(original.right, cloned.right, target);
        
    }
}