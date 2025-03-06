// class Solution {
//     public int[] findMissingAndRepeatedValues(int[][] grid) {
//         int n = grid.length;
//         int size = n * n;
//         Set<Integer> seen = new HashSet<>();
//         int repeated = -1, missing = -1;

//         for (int[] row : grid) {
//             for (int num : row) {
//                 if (!seen.add(num)) {
//                     repeated = num;
//                 }
//             }
//         }

//         for (int num = 1; num <= size; num++) {
//             if (!seen.contains(num)) {
//                 missing = num;
//                 break;
//             }
//         }

//         return new int[]{repeated, missing};
//     }
// }

class Solution {
    public int[] findMissingAndRepeatedValues(int[][] g) {
         long n = g.length; 
         
        long SN = ((n*n) * ((n*n) + 1)) / 2;
        long S2N = ((n*n) * ((n*n) + 1) * (2 * (n*n) + 1)) / 6;
        long S = 0, S2 = 0;
        for (int i = 0; i < n; i++) {
            for(int j=0;j<n;j++){
            S += g[i][j];
            S2 += (long)g[i][j] * (long)g[i][j];
            }
        }
        long val1 = S - SN;
        long val2 = S2 - S2N;
        val2 = val2 / val1;
        long x = (val1 + val2) / 2;
        long y = x - val1;

        int[] ans = {(int)x, (int)y};
        return ans;
    }
}
