// class Solution {
//     public int longestNiceSubarray(int[] nums) {
//         int n = nums.length;
//         int maxLength = 1;
//         int left = 0;
//         int usedBits = 0;

//         for (int right = 0; right < n; right++) {
//             while ((usedBits & nums[right]) != 0) {
//                 usedBits ^= nums[left];
//                 left++;
//             }
            
//             usedBits |= nums[right];
//             maxLength = Math.max(maxLength, right - left + 1);
//         }
        
//         return maxLength;


//     }
// }

class Solution {
    public int longestNiceSubarray(int[] nums) {

        int bit = 0;
        int max = 1;

         int s = 0;
         int e = 0;
         int n = nums.length;

         while(e < n){


          while( (bit& nums[e]) != 0){

            bit^=nums[s++];

          }


          bit|=nums[e];

          if(e-s+1 > max){
            max = e-s+1;
          }
          e++;



         }

return max;
        
    }
}