class Solution {
    public int firstStableIndex(int[] nums, int k) {

        int[] ans = new int[nums.length];

        for(int i = 0; i < nums.length; i++){

            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;

            for(int j = 0; j < i + 1; j++){
                max = Math.max(max, nums[j]);
            }

            for(int l = i; l < nums.length; l++){
                min = Math.min(min , nums[l]);
            }

            int newValue = max - min;

            ans[i] = newValue;
        }

        for(int a = 0; a < nums.length; a++){
            if(ans[a] <= k){
                return a;
            }
        }
        return -1;  
    }
}