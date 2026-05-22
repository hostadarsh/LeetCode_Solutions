class Solution {
    public int search(int[] nums, int target) {
        
        int n = nums.length;

        int low = 0;
        int high = n-1;

        while(low <= high){

            int mid = (low+high)/2;

            if(nums[mid] == target){
                return mid;
            }


            // left half considering sorted
            if(nums[low] <= nums[mid]){

                if(target < nums[mid] && target >= nums[low]){
                    high = mid - 1;
                }
                else{
                    low = mid + 1;
                }
            }

            // right arr is considetring sorted
            else{
                if(target <= nums[high] && target > nums[mid]){
                    low = mid + 1;
                }
                else{
                    high = mid - 1;
                }
            }

        }
        return -1;
    }
}