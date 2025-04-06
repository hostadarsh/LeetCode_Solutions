class Solution {
    public void sortColors(int[] nums) {

        int idx = 0; 
       // int[] res = nums;  - we dont use this because it only give the reference of nums to res and not actually copy the array
        int[] res = Arrays.copyOf(nums,nums.length);

         for(int i = 0; i < 3; i++){
            for(int j = 0; j < nums.length; j++ ){
                if(res[j] == i){
                    nums[idx++] = i;
                }
            }
        }  
    }
}