// class Solution {
//     public int findNumbers(int[] nums) {

//         int count = 0;

//         for(int num : nums){
//             if ((int)(Math.log10(num) + 1) % 2 == 0) {
//                 count++;
//             }
//         }
//         return count;
        
//     }
// }

class Solution {
    public int findNumbers(int[] nums) {
        int result = 0;
        for (int number: nums) {
            if ((number > 9 && number < 100) || (number > 999 && number < 10000) || (number == 100000)) result++;
        }
        return result;
    }
}