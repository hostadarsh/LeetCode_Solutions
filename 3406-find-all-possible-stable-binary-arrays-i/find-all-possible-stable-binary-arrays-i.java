// class Solution {

//     public int numberOfStableArrays(int zero, int one, int limit) {
//         int MOD = 1000000007;
//         // dp[z][o][0] -> ways where last element is 0
//         // dp[z][o][1] -> ways where last element is 1
//         long[][][] dp = new long[zero + 1][one + 1][2];
//         // base cases: only zeros
//         for(int i = 1; i <= Math.min(zero, limit); i++) {
//             dp[i][0][0] = 1;
//         }
//         // base cases: only ones
//         for(int j = 1; j <= Math.min(one, limit); j++) {
//             dp[0][j][1] = 1;
//         }
//         for(int z = 1; z <= zero; z++) {
//             for(int o = 1; o <= one; o++) {
//                 // place 0 at the end
//                 dp[z][o][0] = (dp[z-1][o][0] + dp[z-1][o][1]) % MOD;

//                 if(z - limit - 1 >= 0) {
//                     dp[z][o][0] = (dp[z][o][0] - dp[z-limit-1][o][1] + MOD) % MOD;
//                 }
//                 // place 1 at the end
//                 dp[z][o][1] = (dp[z][o-1][0] + dp[z][o-1][1]) % MOD;

//                 if(o - limit - 1 >= 0) {
//                     dp[z][o][1] = (dp[z][o][1] - dp[z][o-limit-1][0] + MOD) % MOD;
//                 }
//             }
//         }
//         return (int)((dp[zero][one][0] + dp[zero][one][1]) % MOD);
//     }
// }




class Solution {
    public int numberOfStableArrays(int zero, int one, int limit) {
        final int mod = 1_000_000_007;
        int L = limit + 1;

        int[][] dp0 = new int[zero + 1][one + 1]; // i 0s + j 1s ending with 0
        int[][] dp1 = new int[zero + 1][one + 1]; // i 0s + j 1s ending with 1

        // Base cases: only zeros or only ones => only one string if len <= min(limit, zero/one)
        for (int i = 1; i <= Math.min(zero, limit); ++i) dp0[i][0] = 1;
        for (int j = 1; j <= Math.min(one, limit); ++j) dp1[0][j] = 1;

        // DP iterations
        for (int i = 1; i <= zero; ++i) {
            for (int j = 1; j <= one; ++j) {
                dp0[i][j] = (dp0[i - 1][j] + dp1[i - 1][j] - (i >= L ? dp1[i - L][j] : 0)) % mod;
                dp1[i][j] = (dp1[i][j - 1] + dp0[i][j - 1] - (j >= L ? dp0[i][j - L] : 0)) % mod;

                // Fix negatives
                dp0[i][j] = (dp0[i][j] + mod) % mod;
                dp1[i][j] = (dp1[i][j] + mod) % mod;
            }
        }

        return (dp0[zero][one] + dp1[zero][one]) % mod;
    }
}