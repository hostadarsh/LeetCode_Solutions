class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        
        int[] ans = new int[2];

        int l = grid.length;

        int n = l * l;

        long SN = ((long)n * (n + 1)) / 2;

        long S2N = ((long)n * (n + 1) * (2*n + 1)) / 6;


        long S = 0;
        long S2 = 0;

        for(int i = 0; i < l; i++){
            for(int j = 0; j < l; j++){
                S = S + (long) grid[i][j];
                S2 = S2 + (long) grid[i][j] * (long) grid[i][j]; 
            }
        }

        //diff of sum 
        long val1 = S - SN;

        // diff of square sum
        long val2 = S2 - S2N;

        val2 = val2 / val1 ;

        long x = (val1 + val2) / 2; // repeating

        long y = x - val1;  // missing

        ans[0] = (int)x;
        ans[1] = (int)y;

        return ans;
    }
}