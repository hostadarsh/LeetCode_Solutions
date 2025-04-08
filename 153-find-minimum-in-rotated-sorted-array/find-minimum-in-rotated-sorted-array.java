class Solution {
    public int findMin(int[] nums) {

        int low = 0;
        int high = nums.length - 1;
        int min = Integer.MAX_VALUE;

        while(low <= high){
            int mid = (low + high) / 2;

            if(min > nums[mid]){
                min = nums[mid];
            }

        // left is sorted ka condition 
            if(nums[low] <= nums[mid]){
                if(min > nums[low]){
                    min = nums[low];
                }               
                low = mid + 1;
            }
        // right is sorted ka condition
            else{
                if(min > nums[mid + 1]){
                     min = nums[mid+1];
                }
                high = mid - 1;
            }          
        }
        return min;
        
    }
}