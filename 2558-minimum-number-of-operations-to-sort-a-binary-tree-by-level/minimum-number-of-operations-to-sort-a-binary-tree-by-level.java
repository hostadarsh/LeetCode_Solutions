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

//     private int indexOf(int[] arr, int ele) {
//         for (int i = 0; i < arr.length; i++)
//             if (arr[i] == ele)
//                 return i;

//         return -1;
//     }

//     private void swap(int[] arr, int i, int j) {
//         int temp = arr[i];
//         arr[i] = arr[j];
//         arr[j] = temp;
//     }

//     private int minSwaps(int[] arr, int N) {
//         int ans = 0;
//         int[] temp = Arrays.copyOfRange(arr, 0, N);
//         Arrays.sort(temp);

//         for (int i = 0; i < N; i++) {
//             if (arr[i] != temp[i]) {
//                 ans++;
//                 swap(arr, i, indexOf(arr, temp[i]));
//             }
//         }
//         return ans;
//     }

//     public int minimumOperations(TreeNode root) {
//         Queue<TreeNode> q = new LinkedList<>();
//         q.add(root);
//         int count = 0;

//         while (!q.isEmpty()) {
//             TreeNode curr = q.peek();
//             int size = q.size();

//             for (int i = 0; i < size; i++) {
//                 curr = q.remove();
//                 if (curr.left != null)
//                     q.add(curr.left);

//                 if (curr.right != null)
//                     q.add(curr.right);
//             }

//             int[] arr = new int[q.size()];
//             int k = 0;
//             for (TreeNode num : q)
//                 arr[k++] = num.val;

//             count += minSwaps(arr, k);
//         }
//         return count;
//     }
// }

class Solution {

    // Constants for bit manipulation
    final int SHIFT = 20;
    final int MASK = 0xFFFFF;

    public int minimumOperations(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);
        int swaps = 0;

        // Process tree level by level using BFS
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            long[] nodes = new long[levelSize];

            // Store node values with encoded positions
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                // Encode value and index: high 20 bits = value, low 20 bits = index
                nodes[i] = ((long) node.val << SHIFT) + i;

                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }

            // Sort nodes by their values (high 20 bits)
            Arrays.sort(nodes);

            // Count swaps needed to match indices with original positions
            for (int i = 0; i < levelSize; i++) {
                int origPos = (int) (nodes[i] & MASK);
                if (origPos != i) {
                    // Swap nodes and decrement i to recheck current position
                    long temp = nodes[i];
                    nodes[i--] = nodes[origPos];
                    nodes[origPos] = temp;
                    swaps++;
                }
            }
        }
        return swaps;
    }
}