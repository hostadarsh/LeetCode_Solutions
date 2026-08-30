class Solution {
    public int minimumDeletions(int[] nums) {

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        int n = nums.length;

        int minIndex = -1;
        int maxIndex = -1;

        for(int i = 0; i < n; i++ ){
            if(nums[i] < min){
                min = nums[i];
                minIndex = i;
            }
            if(nums[i] > max){
                max = nums[i];
                maxIndex = i;
            }
        }

        int left = Math.min(minIndex, maxIndex);
        int right = Math.max(minIndex,maxIndex);

        // both start from left
        int leftSide = right + 1;

        // both from right
        int rightSide = n - left;

        // each from individual side
        int eachSide = (left + 1) + (n - right);

        return Math.min(Math.min(leftSide, rightSide), eachSide);
        
    }
}