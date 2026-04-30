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
        return calculateHt(root) != Integer.MIN_VALUE;
    }

    private int calculateHt(TreeNode root) {
        if (root == null) {
            return -1;
        }

        int leftHt = calculateHt(root.left);
        int rightHt = calculateHt(root.right);

        if (leftHt == Integer.MIN_VALUE || rightHt == Integer.MIN_VALUE || Math.abs(leftHt - rightHt) > 1) {
            return Integer.MIN_VALUE;
        }

        return 1 + Math.max(leftHt, rightHt);
    }
}
