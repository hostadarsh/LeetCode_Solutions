// class Solution {
//     public boolean isZeroArray(int[] nums, int[][] queries) {
//         for (int i = 0; i < queries.length; i++) {
//             for (int j = queries[i][0]; j <= queries[i][1]; j++) {
//                 if (nums[j] > 0) {
//                     nums[j]--;
//                 }
//             }
//         }

//         for (int x : nums) {
//             if (x != 0) {
//                 return false;
//             }
//         }
//         return true;
//     }
// }

class Solution {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        int n = nums.length;
        int[] diff = new int[n + 1];

        for (int[] q : queries) {
            int l = q[0];
            int r = q[1];
            diff[l]++;
            if (r + 1 < n) {
                diff[r + 1]--;
            }
        }

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            cnt += diff[i];
            if (nums[i] > cnt) {
                return false;
            }
        }

        return true;
    }
}