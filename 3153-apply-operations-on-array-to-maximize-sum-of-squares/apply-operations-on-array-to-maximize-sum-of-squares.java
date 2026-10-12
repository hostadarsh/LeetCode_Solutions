// class Solution {
//     public int maxSum(List<Integer> nums, int k) {
//         final long MOD = 1_000_000_007;
//         int[] cnt = new int[30];  // coins in each bit column, never changes
//         for (int x : nums)
//             for (int b = 0; b < 30; b++) cnt[b] += x >> b & 1;
//         long total = 0;
//         for (int i = 0; i < k; i++) {  // build row i of the stacked picture
//             long row = 0;
//             for (int b = 0; b < 30; b++)
//                 if (cnt[b] > i) row |= 1L << b;  // a coin from every column with more than i coins
//             total = (total + row * row) % MOD;
//         }
//         return (int) total;
//     }
// }

class Solution {

    public int maxSum(List<Integer> nums, int k) {
        final int MOD = 1000000007;
        int[] cnt = new int[30];

        // Count the number of 1 bits at each position
        for (int num : nums) {
            for (int i = 0; i < 30; i++) {
                if ((num & (1 << i)) != 0) {
                    cnt[i]++;
                }
            }
        }

        long res = 0;
        for (int i = 0; i < k; i++) {
            long cur = 0;
            // Construct the current number from the most significant bit to the least significant bit
            for (int j = 29; j >= 0; j--) {
                if (cnt[j] > 0) {
                    cur |= 1L << j;
                    cnt[j]--;
                }
            }
            res = (res + cur * cur) % MOD;
        }

        return (int) res;
    }
}