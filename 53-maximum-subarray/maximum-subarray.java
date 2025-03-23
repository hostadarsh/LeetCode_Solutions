// Better Approach but time limit exceed

// class Solution {
//     public int maxSubArray(int[] nums) {

//         int maxSum = Integer.MIN_VALUE;
        
//         for(int i = 0; i<nums.length; i++){
//             int sum = 0;
//             for(int j = i; j < nums.length; j++ ){
                             
//                 sum += nums[j];
                
//                maxSum = Math.max(maxSum,sum);
//             }
//         }
//         return maxSum;
         
//     }
// }


// class Solution {
//     public int maxSubArray(int[] nums) {

//         int maxSum = Integer.MIN_VALUE;
//         int sum = 0;
        
//         for(int i = 0; i < nums.length; i++){
            
//         sum = sum + nums[i];

//         if(sum > maxSum){
//             maxSum = sum;
//         }

//         if(sum < 0){
//             sum = 0;
//         }

          
//         }
//         return maxSum;
         
//     }
// }

// class Solution {
//     public int maxSubArray(int[] nums) {
//         int s = 0, ms = nums[0];
//         for (int num : nums) {
//             s += num;
//             ms = s >ms ? s : ms;
//             if (s < 0) s = 0;
//         }
//         return ms;
//     }
// }




class Solution {
    public int maxSubArray(int[] nums) {
     
        int ms= nums[0], s = 0;

        for(int n : nums){
            s = s + n;
           
            ms = Math.max(ms,s);

             if(s<0){
                s=0;
            }
        }
        return ms;

    }
}