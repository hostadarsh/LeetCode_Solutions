// import java.util.LinkedList;
// import java.util.Queue;

// class Solution {
//     public int[][] highestPeak(int[][] isWater) {
//         int m = isWater.length;
//         int n = isWater[0].length;
//         int[][] height = new int[m][n];
//         Queue<int[]> queue = new LinkedList<>();

//         // Initialize the queue with water cells and set their height to 0
//         for (int i = 0; i < m; i++) {
//             for (int j = 0; j < n; j++) {
//                 if (isWater[i][j] == 1) {
//                     height[i][j] = 0; // Water cell height is 0
//                     queue.offer(new int[]{i, j}); // Add water cell to the queue
//                 } else {
//                     height[i][j] = -1; // Land cell is initially unvisited
//                 }
//             }
//         }

//         // Directions for adjacent cells (up, down, left, right)
//         int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

//         // BFS to propagate heights
//         while (!queue.isEmpty()) {
//             int[] current = queue.poll();
//             int x = current[0];
//             int y = current[1];

//             for (int[] dir : directions) {
//                 int newX = x + dir[0];
//                 int newY = y + dir[1];

//                 // Check bounds and if the cell is a land cell and unvisited
//                 if (newX >= 0 && newX < m && newY >= 0 && newY < n && height[newX][newY] == -1) {
//                     height[newX][newY] = height[x][y] + 1; // Set height
//                     queue.offer(new int[]{newX, newY}); // Add to queue for further processing
//                 }
//             }
//         }

//         return height; // Return the height matrix
//     }
// }

class Solution {
    public int[][] highestPeak(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int maxVal = 2000;
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (matrix[r][c] == 1) matrix[r][c] = 0;
                else matrix[r][c] = 1;
            }
        }
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (matrix[r][c] != 0) {
                    int top = maxVal;
                    int left = maxVal;
                    if (r - 1 >= 0) top = matrix[r - 1][c];
                    if (c - 1 >= 0) left = matrix[r][c - 1];
                    matrix[r][c] = Math.min(top, left) + 1;
                }
            }
        }
        for (int r = m - 1; r >= 0; r--) {
            for (int c = n - 1; c >= 0; c--) {
                if (matrix[r][c] != 0) {
                    int bottom = maxVal;
                    int right = maxVal;
                    if (r + 1 < m) bottom = matrix[r + 1][c];
                    if (c + 1 < n) right = matrix[r][c + 1];
                    matrix[r][c] = Math.min(matrix[r][c], Math.min(bottom, right) + 1);
                }
            }
        }
        return matrix;
    }
}