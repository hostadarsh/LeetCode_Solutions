// class Solution {
//     public long countFairPairs(int[] nums, int lower, int upper) {

//         long count = 0L; 
//         Arrays.sort(nums);
//         int n = nums.length;
//         for(int i = 0; i < n ; i++){
//             for(int j = i+1 ; j < n ; j++){
                
//                 if(nums[i]+ nums[j] <= upper && nums[i] + nums[j] >= lower){
//                     count++;
//                 }
//             }
//         }
//         return count;
        
//     }
// }


class Solution {
  public long countFairPairs(int[] nums, int lower, int upper) {
   
    Arrays.sort(nums);
    return countLess(nums, upper) - countLess(nums, lower - 1);
  }

  private long countLess(int[] nums, int sum) {
    long res = 0;
    for (int i = 0, j = nums.length - 1; i < j; ++i) {
      while (i < j && nums[i] + nums[j] > sum)
        --j;
      res += j - i;
    }
    return res;
  }
}