class Solution {
    public int stoneGameVIII(int[] A) {
        int n = A.length;
        for (int i = 1; i < n; i++)
            A[i] += A[i - 1];

        int ans = A[n - 1];
        for (int i = n - 2; i > 0; i--)
            ans = Math.max(ans, A[i] - ans);

        return ans;
    }
}

// class Solution {
//     public int stoneGameVIII(int[] stones) {
//         int n = stones.length;
//         int[] prefixSum = new int[n];
//         prefixSum[0] = stones[0];
//         for (int i = 1; i < n; i++) {
//             prefixSum[i] = prefixSum[i - 1] + stones[i];
//         }

//         // maxDiff tracks the maximum score difference a player can achieve 
//         // starting from index i to the end.
//         int maxDiff = prefixSum[n - 1];
//         for (int i = n - 2; i >= 1; i--) {
//             maxDiff = Math.max(maxDiff, prefixSum[i] - maxDiff);
//         }

//         return maxDiff;
//     }
// }