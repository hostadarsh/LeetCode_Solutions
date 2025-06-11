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
    public long kthLargestLevelSum(TreeNode root, int k) {

        if(root==null)return -1;
        List<Long> result = new ArrayList<>();

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int n = q.size(); // number of node at that level

            long sum = 0;

            for (int i = 0; i < n; i++) {
                TreeNode node = q.poll();
                sum = sum + node.val;

                if (node.left != null) {
                    q.add(node.left);
                }
                if (node.right != null) {
                    q.add(node.right);
                }

            }
            result.add(sum);
        }

        if(k > result.size()){
            return -1;
        }

        result.sort(Collections.reverseOrder());

        return result.get(k-1);

    }
}