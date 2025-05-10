// class Solution {
//     public long minSum(int[] nums1, int[] nums2) {
//         long sum1 = sum(nums1);
//         long sum2 = sum(nums2);

//         long count1 = count(nums1);
//         long count2 = count(nums2);

//         if(count1 == 0 && count2 == 0){
//             return sum1 == sum2 ? sum1 : -1;
//         }


//         if(sum1 + count1 >= sum2 + count2 && count2 != 0){
//             return sum1 + count1;
//         }   
//         if(sum1 + count1 <= sum2 + count2 && count1 != 0 ){
//             return sum2 + count2;
//         } 
//         return -1;    
        
//     }

//     public static long sum(int[] arr){
//         long sum = 0;
//         for(int i = 0; i < arr.length; i++){
//             sum = sum + arr[i];
//         }
//         return sum;
//     }
//     public static long count(int[] arr){
//         long count = 0;
//         for(int i = 0; i < arr.length; i++){
//             if(arr[i] == 0){
//                 count++;
//             }
//         }
//         return count;
//     }
// }

class Solution {
    public long minSum(int[] nums1, int[] nums2) {
        long sum1 = 0;
        long zeroCount1 = 0;

        for (int n: nums1) {
            sum1 += (long) n;
            zeroCount1 += n == 0 ? 1 : 0;
        }

        long sum2 = 0;
        long zeroCount2 = 0;

        for (int n: nums2) {
            sum2 += (long) n;
            zeroCount2 += n == 0 ? 1 : 0;
        }

        long minSum1 = sum1+zeroCount1;
        long minSum2 = sum2+zeroCount2;

        if (minSum1<minSum2 && zeroCount1 == 0) {
            return -1;
        }

        if (minSum1>minSum2 && zeroCount2 == 0) {
            return -1;
        }

        return Math.max(minSum1, minSum2);
    }
}