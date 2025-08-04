class Solution {
    public int splitArray(int[] nums, int k) {
        int min = nums[0];
        int max = 0;
        //Finding maximum element of array and sum of all elements.
        //Our search space lies between this
        for(int i: nums){
            min = Math.max(min, i);
            max += i;
        }
        int mid = 0;
        //Applying Binary Search on search space
        while(min<=max){
            mid = min + (max - min)/2;
            if(countPartitions(nums, k, mid)) max = mid - 1;
            else min = mid + 1;
        }
        return min;
    }
    public boolean countPartitions(int nums[], int k, int mid){
        long sum = 0;
        int partitions = 1;
        /* Counting partitions to check if we could split array 
            into k partitions */
        for(int i = 0; i<nums.length; i++){
            if((sum+nums[i])<=mid){
                sum += nums[i];
            }
            else{
                partitions += 1;
                sum = nums[i];
            }
        }
        return partitions<=k;
    }
}