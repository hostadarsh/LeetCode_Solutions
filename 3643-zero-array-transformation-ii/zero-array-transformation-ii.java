// class Solution {
//     public int minZeroArray(int[] nums, int[][] queries) {
//         int n = nums.length;
        
//         if (Arrays.stream(nums).allMatch(x -> x == 0)) return 0;
//         int left = 1, right = queries.length;
//         if (!canMakeZeroArray(right, nums, queries)) return -1;
//         while (left < right) {
//             int mid = left + (right - left) / 2;
//             if (canMakeZeroArray(mid, nums, queries)) right = mid;
//             else left = mid + 1;
//         }
//         return left;
//     }

//     private boolean canMakeZeroArray(int k, int[] nums, int[][] queries) {
//         int n = nums.length;
//         int[] diff = new int[n + 1];
//         for (int i = 0; i < k; i++) {
//             int left = queries[i][0], right = queries[i][1], val = queries[i][2];
//             diff[left] += val;
//             diff[right + 1] -= val;
//         }
//         int currVal = 0;
//         for (int i = 0; i < n; i++) {
//             currVal += diff[i];
//             if (currVal < nums[i]) return false;
//         }
//         return true;
//     }
// }

// class Solution {
//     public int minZeroArray(int[] nums, int[][] queries) {
//         int n = nums.length;
//         int[] differenceArray = new int[n + 1];

//         int differentArrayPrefixSum = 0;
//         int q = 0;
//         for (int i = 0; i < n; i++) {
//             while (differentArrayPrefixSum + differenceArray[i] < nums[i]) {
//                 q++;
//                 if (q > queries.length) return -1;

//                 int[] nextQuery = queries[q - 1];
//                 int left = nextQuery[0], right = nextQuery[1], val = nextQuery[2];
//                 if (right >= i) {
//                     differenceArray[Math.max(left, i)] += val;
//                     differenceArray[right + 1] -= val;
//                 }
//             }
//             differentArrayPrefixSum += differenceArray[i];
//         }
//         return q;
//     }
// }

class Solution {
    private boolean isValid(int m, int[] nums, int[][] queries) {
        int[] temp = new int[nums.length];
        for(int i = 0; i <= m; i++) {
            temp[queries[i][0]] += queries[i][2];
            if ((queries[i][1]+1) < nums.length) {
                temp[queries[i][1]+1] -= queries[i][2];
            }
        }
        int cur = 0;
        for(int i = 0; i < nums.length; i++) { 
            cur += temp[i];
            if(nums[i] > cur) {
                return false;
            }
        }
        return true;
    }
    public int minZeroArray(int[] nums, int[][] queries) {
        if(!isValid(queries.length-1, nums, queries)) {
            return -1;   
        }
        int i = -1, j = queries.length-1;
        while (i < j) {
            int m = i + (j-i)/2;
            if (isValid(m, nums, queries)) {
                j = m;
            } else {
                i = m +1;
            }
        }
        return i+1;
    }
}

