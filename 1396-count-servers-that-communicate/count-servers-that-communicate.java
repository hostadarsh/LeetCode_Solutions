// class Solution {
//     public int countServers(int[][] grid) {
//         int[] Rows = new int[grid.length];
//         int[] Col = new int[grid[0].length];
//         for (int i = 0; i < grid.length; i++) {
//             for (int j = 0; j < grid[0].length; j++) {
//                 Rows[i] += grid[i][j];
//                 Col[j] += grid[i][j];
//             }
//         }
//         int ans = 0;
//         for (int i = 0; i < grid.length; i++) {
//             for (int j = 0; j < grid[0].length; j++) {
//                 if (grid[i][j] == 1 && (Rows[i] > 1 || Col[j] > 1)) {
//                     ans++;
//                 }
//             }
//         }
//         return ans;
//     }
// }

class Solution {
    public int countServers(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        int[] rowCount = new int[m];
        int[] colCount = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    rowCount[i]++;
                    colCount[j]++;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && (rowCount[i] > 1 || colCount[j] > 1)) {
                    count++;
                }
            }
        }

        return count;
    }
}