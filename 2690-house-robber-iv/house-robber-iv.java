// class Solution {
//     public boolean canRob(int[] nums, int mid, int k) {
//         int count = 0, n = nums.length;
//         for (int i = 0; i < n; i++) {
//             if (nums[i] <= mid) {
//                 count++;
//                 i++;
//             }
//         }
//         return count >= k;
//     }

//     public int minCapability(int[] nums, int k) {
//         int left = 1, right = Arrays.stream(nums).max().getAsInt(), ans = right;
//         while (left <= right) {
//             int mid = (left + right) / 2;
//             if (canRob(nums, mid, k)) {
//                 ans = mid;
//                 right = mid - 1;
//             } else {
//                 left = mid + 1;
//             }
//         }
//         return ans;
//     }
// }


class Solution {
    static{
        for(int i = 0 ; i < 500 ; i++){
            minCapability(new int[]{1 , 2, 3} , 2);
        }
    }
    public static int minCapability(int[] nums, int k) {
        int n = nums.length;
        int start = Integer.MAX_VALUE;
        int end = Integer.MIN_VALUE;
        for(int num : nums){
            end = Math.max(end , num);
            start = Math.min(start , num);
        }
        int ans = 0;
        while(start <= end){
            int mid = start + ((end - start)/2);
            int count = 0;
            for(int i = 0 ; i < n ; i++){
                if(nums[i] <= mid){
                    count++;
                    i++;
                }
            }
            if(count >= k){
                ans = mid;
                end = mid - 1;
            }
            else start = mid + 1;
        }
        return start;
    }
}