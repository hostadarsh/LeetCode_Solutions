class Solution {
    public int smallestIndex(int[] nums) {

        int n = nums.length;

        for(int i = 0; i < n ; i++){
            if(nums[i] < 10){
                if(nums[i] == i ){
                    return i ;
                }
            }
            else{
                int sumOfDigit = 0;
                    while(nums[i] != 0){
                        sumOfDigit += nums[i]%10;
                        nums[i] /= 10;
                    }

                    if(sumOfDigit == i){
                        return i;
                    }
            }
        }
        return -1;
        
    }
}