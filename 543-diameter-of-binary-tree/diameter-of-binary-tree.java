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

//     public int diameterOfBinaryTree(TreeNode root) {
//         // Initialize the variable to store the diameter of the tree

//         int[] diameter = new int[1];
//         diameter[0] = 0;

//         // Call the height function to traverse the tree and calculate diameter

//         height(root, diameter);

//         // Return the calculated diameter

//         return diameter[0];

//     }

//     // Function to calculate the height of the tree and update the diameter

//     private int height(TreeNode node, int[] diameter) {

//         // Base case: If the node is null, return 0 indicating the height of an empty tree
        
//         if (node == null) {
//             return 0;
//         }

//         // Recursively calculate the height of left and right subtrees

//         int[] lh = new int[1];
//         int[] rh = new int[1];
//         lh[0] = height(node.left, diameter);
//         rh[0] = height(node.right, diameter);

//         // Update the diameter with the maximum of current diameter or sum of left and right heights
        
//         diameter[0] = Math.max(diameter[0], lh[0] + rh[0]);

//         // Return the height of the current node's subtree
        
//         return 1 + Math.max(lh[0], rh[0]);
//     }
// }      
        

class Solution {
    public int diameterOfBinaryTree(TreeNode root) {
        
        int[] diameter = new int[1];
        diameter[0] = 0;

        height(root,diameter);
        return diameter[0];
    }

    private int height(TreeNode root, int[] diameter){
        if(root == null){
            return 0;
        }

        int[] lh = new int[1];
        int[] rh = new int[1];
        lh[0] = height(root.left, diameter);
        rh[0] = height(root.right, diameter);

        diameter[0] = Math.max(diameter[0], lh[0] + rh[0]);

        return 1 + Math.max(lh[0] , rh[0]);

    }
}      
  