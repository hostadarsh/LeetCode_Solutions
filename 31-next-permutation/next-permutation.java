class Solution {
    public void nextPermutation(int[] nums) {

        int n = nums.length;

        int idx = -1;

        for(int i = n - 2; i >= 0; i--){
            if(nums[i] < nums[i+1]){
                idx = i;
                break;
            }
        }

        if(idx == -1){
            for(int i = 0; i < (n/2); i++){
                int temp = nums[i];
                nums[i] = nums[n-i-1];
                nums[n-i-1] = temp;
            }
           return;
        }
        
        for(int i = n - 1; i > idx; i-- ){
            if(nums[i] > nums[idx]){
                int temp = nums[i];
                nums[i] = nums[idx];
                nums[idx] = temp;
                break;
            }
        }
        while(idx+1 < n){
            int temp = nums[idx+1];
            nums[idx+1] = nums[n-1];
            nums[n-1] = temp;
            idx++;
            n--;
        }
         return ;

    }
}