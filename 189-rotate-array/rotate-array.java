class Solution {
    public void rotate(int[] nums, int k) {

        int[] ans = Arrays.copyOf(nums, nums.length);

        //k = k % nums.length;

        for(int i = 0; i < nums.length; i++){
            nums[(i+k) % nums.length] = ans[i];
        }

        return;
        
    }
}