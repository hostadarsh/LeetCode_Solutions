class Solution {
    public boolean search(int[] nums, int target) {
        
        int left = 0;
        int right = nums.length - 1;

        while(left <= right){
            int mid = (left + right) / 2;

            if(nums[mid] == target){
                return true;
            }

            if( nums[left] == nums[mid] && nums[right] == nums[left]){
                left++;
                right--;
                continue;
            }

            // checking if left is sorted

            if(nums[left] <= nums[mid]){
                if(nums[left] <= target && target <= nums[mid]){
                    right = mid - 1;
                }
                else{
                    left = mid + 1;
                }
            }
            //right is sorted
            else{
                if(nums[mid] <= target && target <= nums[right]){
                    left = mid + 1;
                }
                else{
                    right = mid - 1;
                }
            }
        }
        return false;

    }
}