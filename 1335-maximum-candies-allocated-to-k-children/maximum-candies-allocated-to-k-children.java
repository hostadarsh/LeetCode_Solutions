// class Solution {
//     public int maximumCandies(int[] candies, long k) {
//         int left = 1, right = 10_000_000;
//         int result = 0;

//         while (left <= right) {
//             int mid = left + (right - left) / 2;
//             long childrenCount = 0;

//             for (int candy : candies) {
//                 childrenCount += candy / mid;
//             }

//             if (childrenCount >= k) {
//                 result = mid;
//                 left = mid + 1;
//             } else {
//                 right = mid - 1;
//             }
//         }

//         return result;
//     }
// }

class Solution {
    public int maximumCandies(int[] candies, long k) {
        long sum = 0;
        for(int i : candies){
            sum += i;
        }
        if(sum < k){
            return 0;
        }
        int l = 1, r = (int)(sum/k);
        while(l < r){
            int mid = (l+r+1)/2;
            if(binarySearch(candies, mid, k)){
                l = mid;
            } else{
                r = mid-1;
            }
        }
        return l;
    }
    private boolean binarySearch(int[] arr, int each, long k){
        long count = 0;
        for(int i : arr){
            count += i/each;
            if(count >= k){
                return true;
            }
        }
        return false;
    }
}