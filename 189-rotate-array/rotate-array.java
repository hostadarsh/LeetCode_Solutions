// class Solution {
//     public void rotate(int[] nums, int k) {

//         int[] ans = Arrays.copyOf(nums, nums.length);

//         //k = k % nums.length;

//         for(int i = 0; i < nums.length; i++){
//             nums[(i+k) % nums.length] = ans[i];
//         }

//         return;
        
//     }
// }

class Solution {
    public void rotate(int[] nums, int k) {

        int n = nums.length;
        k %= n;

        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
    }

    private void reverse(int[] nums, int left, int right) {
        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;

            left++;
            right--;
        }
    }
}