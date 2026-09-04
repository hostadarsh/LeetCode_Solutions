// class Solution {
//     public int firstStableIndex(int[] nums, int k) {

//         int[] ans = new int[nums.length];

//         for(int i = 0; i < nums.length; i++){

//             int max = Integer.MIN_VALUE;
//             int min = Integer.MAX_VALUE;

//             for(int j = 0; j < i + 1; j++){
//                 max = Math.max(max, nums[j]);
//             }

//             for(int l = i; l < nums.length; l++){
//                 min = Math.min(min , nums[l]);
//             }

//             int newValue = max - min;

//             ans[i] = newValue;
//         }

//         for(int a = 0; a < nums.length; a++){
//             if(ans[a] <= k){
//                 return a;
//             }
//         }
//         return -1;  
//     }
// }

class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int len = nums.length;
        int[] minPrefix = new int[len];
        int min = Integer.MAX_VALUE;
        for (int i = len - 1; i >= 0; i--) {
            min = Math.min(min, nums[i]);
            minPrefix[i] = min;
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < len; i++) {
            max = Math.max(max, nums[i]);
            if (Math.abs(minPrefix[i] - max) <= k)
                return i;
        }
        return -1;
    }
}