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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();

        if (root != null) {
            q.offer(root);
        }

        while (!q.isEmpty()) {
            int size = q.size();
            TreeNode rightmost = null;

            for (int i = 0; i < size; i++) {
                TreeNode cur = q.poll();
                rightmost = cur;

                if (cur.left != null) { 
                    q.offer(cur.left);
                }
                
                if (cur.right != null) {
                    q.offer(cur.right);
                }
            }

            res.add(rightmost.val);
        }

        return res;
    }
}
