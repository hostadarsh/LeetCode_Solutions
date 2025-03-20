// import java.util.HashMap;
// class Solution {
//     public int[] twoSum(int[] nums, int target) {

//         for(int i = 1; i < nums.length; i++){
//             for(int j = i; j < nums.length ; j++){
//                 if(nums[j] + nums[j-1] == target){
//                     return new int[]{j-1,j};
//                 }
//             }
//         }
//         return new int[]{};
        
//     }
// }

import java.util.HashMap;

class Solution {
    public int[] twoSum(int[] nums, int target) {
     for(int i = 1; i < nums.length; i++){
            for(int j = i; j < nums.length; j++) {
                if(nums[j] + nums[j - i] == target) {
                return new int[]{j-i, j};
                }
            }
        }
        return new int[]{};
    }
}