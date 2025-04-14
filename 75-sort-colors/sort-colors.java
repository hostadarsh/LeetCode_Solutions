// class Solution {
//     public void sortColors(int[] nums) {

//         int idx = 0; 
//        // int[] res = nums;  - we dont use this because it only give the reference of nums to res and not actually copy the array
//         int[] res = Arrays.copyOf(nums,nums.length);

//          for(int i = 0; i < 3; i++){
//             for(int j = 0; j < nums.length; j++ ){
//                 if(res[j] == i){
//                     nums[idx++] = i;
//                 }
//             }
//         }  
//     }
// }


class Solution {
    public void sortColors(int[] nums) {

        int n = nums.length;
        int low = 0,mid = 0;
        int high = n - 1;

        while(mid <= high){
            if(nums[mid] == 2){
                int temp = nums[mid];
                nums[mid] = nums[high];
                nums[high] = temp;
                high--;
            }
            else if(nums[mid] == 0){
                int temp = nums[low];
                nums[low] = nums[mid];
                nums[mid] = temp;
                mid++;
                low++;
            }
            else{
                mid++;
            }
        }
    }
}
