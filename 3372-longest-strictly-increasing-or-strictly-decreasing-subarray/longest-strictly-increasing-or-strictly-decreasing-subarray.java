// class Solution {
//     public int longestMonotonicSubarray(int[] nums) {
//         if(nums.length == 0){
//             return 0;
//         }

//         int maxLen = 1, inc = 1, dec = 1;
//         for(int i = 1; i < nums.length;i++){
//             if(nums[i] > nums[i-1]){
//                 inc++;
//                 dec =1;
//             }
//             else if(nums[i]< nums[i-1]){
//                 dec++;
//                 inc = 1;
//             }
//             else{
//                 inc = 1; dec = 1;
//             }
//             maxLen = Math.max(maxLen, Math.max(inc,dec));
//         }
//         return maxLen;
//     }
// }
class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int incLength = 1;
        int decLength = 1;
        int maxLength = 1;

        for(int pos = 0; pos < nums.length - 1; pos++) {
            if(nums[pos + 1] > nums[pos]) {
                incLength++;
                decLength = 1;
            } else if(nums[pos + 1] < nums[pos]) {
                decLength++;
                incLength = 1;
            } else {
                incLength = 1;
                decLength = 1;
            }
            maxLength = Math.max(maxLength, Math.max(incLength, decLength));
        }
        return maxLength;
    }

}