// class Solution {
//     public int countSubmatrices(int[][] grid, int k) {
//         int m = grid.length, n = grid[0].length;
//         int ans = 0;

//         for (int i = 0; i < m; i++) {
//             for (int j = 0; j < n; j++) {
//                 long up = (i > 0 ? grid[i - 1][j] : 0);
//                 long left = (j > 0 ? grid[i][j - 1] : 0);
//                 long diag = (i > 0 && j > 0 ? grid[i - 1][j - 1] : 0);

//                 grid[i][j] = (int)(grid[i][j] + up + left - diag);

//                 if (grid[i][j] <= k) {
//                     ans++;
//                 } else {
//                     if (j == 0) return ans;
//                     break;
//                 }
//             }
//         }

//         return ans;
//     }
// }


// class Solution {

//     public int countSubmatrices(int[][] grid, int k) {
//         int n = grid.length;
//         int m = grid[0].length;
//         int[] cols = new int[m];
//         int res = 0;

//         for (int i = 0; i < n; i++) {
//             int rows = 0;
//             for (int j = 0; j < m; j++) {
//                 cols[j] += grid[i][j];
//                 rows += cols[j];
//                 if (rows <= k) {
//                     res++;
//                 }
//             }
//         }

//         return res;
//     }
// }




class Solution {

    public int countSubmatrices(int[][] grid, int k) {
        int m = grid[0].length;
        int n = grid.length;
        int res = 0;

        int [] cols = new int[m];
        
        for(int i = 0; i < n; i++){
            int rows = 0;

            for(int j = 0; j < m; j++){
                cols[j] = cols[j] + grid[i][j];
                rows = rows + cols[j];

                if(rows <= k){
                    res++;
                }
            }
        }

        return res;
        
    }
}




















