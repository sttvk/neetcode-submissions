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
        int diameter = 0;
        int height = -1;
    }

    private Pair diameter(TreeNode root) {
        if (root == null) {
            return new Pair();
        }

        Pair leftPair = diameter(root.left);
        Pair rightPair = diameter(root.right);

        int dia = leftPair.height + rightPair.height + 2;
        
        Pair pair = new Pair();
        pair.diameter = Math.max(dia, Math.max(leftPair.diameter, rightPair.diameter));
        pair.height = Math.max(leftPair.height, rightPair.height) + 1;

        return pair;   
    }
    
    public int diameterOfBinaryTree(TreeNode root) {
        return diameter(root).diameter;
    }
}
