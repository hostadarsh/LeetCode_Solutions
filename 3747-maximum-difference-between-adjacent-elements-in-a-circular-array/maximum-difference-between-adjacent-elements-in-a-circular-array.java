class Solution {
    public int maxAdjacentDistance(int[] nums) {
        int n = nums.length;
        int diff = Math.abs(nums[0] - nums[n-1]);

        for(int i = 1; i < n; i++){
            diff = Math.abs(nums[i] - nums[i-1]) > diff ? Math.abs(nums[i] - nums[i-1]) : diff; 
        }

        return diff;
    }
}