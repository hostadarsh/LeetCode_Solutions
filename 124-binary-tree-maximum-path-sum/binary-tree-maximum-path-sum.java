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
    public int maxPathSum(TreeNode root) {

        int[] sum = {Integer.MIN_VALUE};

        heightSum(root, sum);
        return sum[0];
        
    }

    private int heightSum(TreeNode root, int[] sum){
        if(root == null){
            return 0;
        }

        int ls = Math.max(0, heightSum(root.left,sum));
        int rs = Math.max(0, heightSum(root.right, sum));

        sum[0] = Math.max(sum[0], ls + rs + root.val);

        return Math.max(ls, rs) + root.val; 
    }
}