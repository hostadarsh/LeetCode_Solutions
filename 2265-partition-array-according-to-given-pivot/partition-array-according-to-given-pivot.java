// class Solution {
//     public int[] pivotArray(int[] nums, int pivot) {
//         List<Integer> lesser = new ArrayList<>();
//         List<Integer> pivotCount = new ArrayList<>();
//         List<Integer> greater = new ArrayList<>();

//         for(int i = 0; i < nums.length; i++){
//             if(nums[i] < pivot){
//                 lesser.add(nums[i]);
//             }
//             else if(nums[i] > pivot){
//                 greater.add(nums[i]);
//             }
//             else{
//                 pivotCount.add(pivot);
//             }
//         }

//         int [] ans = new int [nums.length];

//         int i = 0;

//         for(int n : lesser){
//             ans[i++] = n;
//         }
//         for(int n : pivotCount){
//             ans[i++] = n;
//         }
//         for(int n : greater){
//             ans[i++] = n;
//         }

// return ans;
//     }
// }

class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int[] result = new int[nums.length];
        int left = 0, right = nums.length - 1;
        
        for (int i = 0, j = nums.length - 1; i < nums.length; i++, j--) {
            if (nums[i] < pivot) {
                result[left] = nums[i];
                left++;
            }
            
            if (nums[j] > pivot) {
                result[right] = nums[j];
                right--;
            }
        }
        
        while (left <= right) {
            result[left] = pivot;
            left++;
        }
        
        return result;
    }
}