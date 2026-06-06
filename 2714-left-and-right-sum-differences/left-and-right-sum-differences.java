class Solution {
    public int[] leftRightDifference(int[] nums) {
        
        int n = nums.length;

        int[] ans = new int[n];

        int leftSum = 0;
        int rightSum = 0;

        int[] lsum = new int[n];
        int[] rsum = new int[n];

        for(int i = 0; i < n ; i++){
            
            if(i == 0){
                lsum[i] = 0;
                rsum[n-i-1] = 0;
                continue;
            }

            leftSum = leftSum + nums[i - 1];
            lsum[i] = leftSum;

            rightSum = rightSum + nums[n - i];
            rsum[n-i-1] = rightSum;
            
        }

        for(int i = 0; i < n; i++){
            ans[i] = Math.abs(lsum[i] - rsum[i]);
        }

        return ans;
    }
}