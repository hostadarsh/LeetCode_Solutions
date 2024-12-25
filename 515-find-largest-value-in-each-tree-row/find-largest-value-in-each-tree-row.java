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
// class Solution {
//     private List<Integer> res;
//     public List<Integer> largestValues(TreeNode root) {
//         res = new ArrayList<>();
//         dfs(root, 0);

//         return res;
//     }

//     private void dfs(TreeNode root, int level) {
//         if (root != null) {
//             int val = root.val;
            
//             if (res.size() == level) 
//                 res.add(val);
//             else 
//                 res.set(level, Math.max(res.get(level), val));
            
//             dfs(root.left, level + 1);
//             dfs(root.right, level + 1);
//         }
//     }
// }

class Solution {
    List<Integer> ans;
    public List<Integer> largestValues(TreeNode root) {
        ans = new ArrayList<>();
        dfs(root, 0);
        return ans;
    }

    private void dfs(TreeNode node, int l) {
        if(node != null) {
            int v = node.val;
            if(l == ans.size()) {
                ans.add(v);
            } else {
                ans.set(l, Math.max(ans.get(l), v));
            }
            dfs(node.left, l + 1);
            dfs(node.right, l + 1);
        }
    }
}