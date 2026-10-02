// class Solution {
//     private static final int MOD = 1000000007;
//     private static final int MAX = 100001;
//     private static final int[] pow = new int[MAX];

//     static {
//         pow[0] = 1;
//         for (int i = 1; i < MAX; i++)
//             pow[i] = (int) ((pow[i - 1] * 10L) % MOD);
//     }

//     public int[] sumAndMultiply(String s, int[][] queries) {
//         int n = s.length();
//         int[] A = new int[n + 1];
//         int[] B = new int[n + 1];
//         int[] len = new int[n + 1];

//         for (int i = 0; i < n; i++) {
//             int d = s.charAt(i) - '0';            
//             A[i + 1] = A[i] + d;
            
//             if (d > 0) {
//                 B[i + 1] = (int) ((B[i] * 10L + d) % MOD);
//                 len[i + 1] = len[i] + 1;
//             } else {
//                 B[i + 1] = B[i];
//                 len[i + 1] = len[i];
//             }
//         }

//         int[] res = new int[queries.length];
//         int i = 0;

//         for (int[] q : queries) {
//             int l = q[0], r = q[1] + 1;
            
//             long sub = ((long) B[l] * pow[len[r] - len[l]]) % MOD;
//             long x = (B[r] - sub + MOD) % MOD;
            
//             res[i++] = (int) ((x * (A[r] - A[l])) % MOD);
//         }

//         return res;
//     }
// }


class Solution {
    public int[] sumAndMultiply(String s, int[][] queries) {
        final long MOD = 1_000_000_007L;

        int n = s.length();

        long[] sum = new long[n + 1];
        long[] value = new long[n + 1];
        int[] count = new int[n + 1];
        long[] pow10 = new long[n + 1];
        pow10[0] = 1;
        for (int i = 1; i <= n; i++) {
            pow10[i] = (pow10[i - 1] * 10) % MOD;
        }
        for (int i = 0; i < n; i++) {
            int digit = s.charAt(i) - '0';
            sum[i + 1] = sum[i] + digit;
            count[i + 1] = count[i];
            value[i + 1] = value[i];

            if (digit != 0) {
                count[i + 1]++;

                value[i + 1] =
                    (value[i] * 10 + digit) % MOD;
            }
        }

        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int l = queries[i][0];
            int r = queries[i][1];
            long digitSum = sum[r + 1] - sum[l];
            int nonZeroCount = count[r + 1] - count[l];
            long x = (
                value[r + 1]
                - value[l] * pow10[nonZeroCount] % MOD
                + MOD
            ) % MOD;
            ans[i] = (int) ((x * digitSum) % MOD);
        }

        return ans;
    }
}