// class Solution {
//     public int[] getFinalState(int[] nums, int k, int multiplier) {
//         for(int i = 0 ; i < k; i++){
//         int idx = smallest(nums);
//         nums[idx] = nums[idx] * multiplier;
//         }

//         return nums;

        
//     }
//     public static int smallest(int [] arr){
//         int small = 10000;
//         int idx = 0;
//         for(int i = 0; i< arr.length; i++){
//             if(arr[i] < small){
//                 small = arr[i];
//                 idx = i;
//             }
//         }
//         return idx;
//     }
// }

 class Solution {
     public int[] getFinalState(int[] arr, int k, int multiplier) {

        int[] ans = new int[arr.length];

        while(k > 0){
            int x = 0;

            for(int i = 1; i< arr.length; i++){
                if(arr[i] < arr[x]){
                    x = i;
                }
            }
            arr[x] = arr[x] * multiplier;
            k--;
        }
        return arr;

     }
 }