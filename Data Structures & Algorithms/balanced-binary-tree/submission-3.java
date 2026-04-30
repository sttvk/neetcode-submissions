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
    public boolean isBalanced(TreeNode root) {
        return calculateHt(root) != -1;
    }

    private int calculateHt(TreeNode root) {
        if (root == null) {
            return 0; 
        }

        int leftHt = calculateHt(root.left);
        int rightHt = calculateHt(root.right);
        
        if (rightHt == -1 || leftHt == -1 || Math.abs(leftHt - rightHt) > 1) 
            return -1;


        return 1 + Math.max(leftHt, rightHt);
    }
}
