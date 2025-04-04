// class Solution {
//     public long maximumTripletValue(int[] nums) {
//         int n = nums.length;
//         if (n < 3) return 0;

//         int[] leftMax = new int[n];
//         leftMax[0] = nums[0];
//         for (int i = 1; i < n; i++) {
//             leftMax[i] = Math.max(leftMax[i - 1], nums[i]);
//         }

//         int[] rightMax = new int[n];
//         rightMax[n - 1] = nums[n - 1];
//         for (int i = n - 2; i >= 0; i--) {
//             rightMax[i] = Math.max(rightMax[i + 1], nums[i]);
//         }

//         long ans = 0;  
//         for (int i = 1; i < n - 1; i++) {
//             int left = leftMax[i - 1];
//             int right = rightMax[i + 1];
//             ans = Math.max(ans, (long)(left - nums[i]) * right); 
//         }

//         return ans;
//     }
// }

// class Solution {
//     public long maximumTripletValue(int[] nums) {
//         int maxi = Integer.MIN_VALUE;
//         int diff = 0;
//         long res = 0;
        
//         for (int i = 0; i < nums.length; i++) {
//             maxi = Math.max(maxi, nums[i]);
//             if (i >= 2)
//                 res = Math.max(res, (long)diff * nums[i]);
//             if (i >= 1)
//                 diff = Math.max(diff, maxi - nums[i]);
//         }
        
//         return res;
//     }
// }

class Solution {
    public long maximumTripletValue(int[] nums) {
        long maxProduct=0;
        int maxDiff=0;
        int maxNum=0;
        for(int num: nums){
            maxProduct = Math.max(maxProduct, (long)maxDiff*num);
            maxNum = Math.max(maxNum, num);
            maxDiff = Math.max(maxDiff, maxNum-num);
        }
        return maxProduct>0?maxProduct:0;
    }
}