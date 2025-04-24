// public class Solution {
//     public int countCompleteSubarrays(int[] nums) {
//         Set<Integer> distinctElements = new HashSet<>();
//         for (int num : nums) {
//             distinctElements.add(num);
//         }
//         int totalDistinct = distinctElements.size();
//         int count = 0;
//         int n = nums.length;
        
//         for (int i = 0; i < n; i++) {
//             Set<Integer> currentSet = new HashSet<>();
//             for (int j = i; j < n; j++) {
//                 currentSet.add(nums[j]);
//                 if (currentSet.size() == totalDistinct) {
//                     count += (n - j);
//                     break;
//                 }
//             }
//         }
//         return count;
//     }
// }

class Solution {
    public int countCompleteSubarrays(int[] nums) {
        boolean[] exists = new boolean[2001];
        int distinct = 0;
        for( int n : nums ){
            if( !exists[n] ){
                exists[n] = true;
                distinct++;
            }
        }
        int[] freq = new int[2001];
        int count = 0, n = nums.length;
        int sub = 0;
        for( int start = 0, end = 0; end < n; end++ ){
            if( freq[ nums[ end ] ]++ == 0 )
                count++;
            while( count == distinct ){
                sub += n - end;
                if( freq[ nums[ start ++ ] ]-- == 1 )
                    count--;
            }
        }
        return sub;
    }
}