// class Solution {
//     public int findTargetSumWays(int[] nums, int target) {
//         return helper(nums, target, 0, 0);
//     }

//     private int helper(int[] arr, int target, int idx, int sum) {
//         if (idx >= arr.length)
//             return sum == target ? 1 : 0;
        
//         int subtract = helper(arr, target, idx + 1, sum - arr[idx]);
//         int add = helper(arr, target, idx + 1, sum + arr[idx]);

//         return subtract + add;
//     }
// }

class Solution {
    int[] dp;
    public int findTargetSumWays(int[] nums, int target) {
        // use DP
        // assume that we have S1 - S2 = target && S1 + S2 = sum ==> S1 = (target + sum)/2
        // it means that we need to find the number of subsets that have sum = (target + sum)/2
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        //System.out.println("target+sum:" + (target+sum));
        if (target > sum || target + sum < 0 || (target+sum)%2 != 0) {
            return 0;
        }
        //System.out.println("---");
        int targetSum = (target + sum)/2;
        // we use DP to represents the number of subset that have sum equals targetSum
        dp = new int[targetSum+1]; 
        dp[0] = 1; // we have at least one way to have sum = 0 as empty subset

        countSubsets(nums, 0, targetSum);
        return dp[targetSum];
    }

    private void countSubsets(int[] nums, int index, int targetSum) {
        if (index == nums.length) {
            return;
        }
        
        for (int j=targetSum; j>=nums[index]; j--) {
            dp[j] += dp[j-nums[index]];
        }
        countSubsets(nums, index+1, targetSum);
    }

    /* backtracking
    public int findTargetSumWays(int[] nums, int target) {
        return backtrack(nums, 0, target, 0);
    }

    private int backtrack(int[] nums, int index, int target, int currentSum) {
        if (index == nums.length) {
            return (currentSum == target) ? 1 : 0;
        }
        int add = backtrack(nums, index+1, target, currentSum+nums[index]);
        int sub = backtrack(nums, index+1, target, currentSum-nums[index]);
        return add+sub;
    }*/
}