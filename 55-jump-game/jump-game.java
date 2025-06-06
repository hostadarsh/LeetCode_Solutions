class Solution {
    public boolean canJump(int[] nums) {
        if(nums.length == 1){
            return true;
        }

        int maxId = -1;

        for(int i = 0; i < nums.length; i++){
            maxId = Math.max(maxId,nums[i] + i);

            if(nums[i] == 0 && maxId <= i && i != nums.length- 1){
                return false;
            }
        }
        if(maxId >= nums.length - 1){
          return true;  
        }
        return false;
    }
}