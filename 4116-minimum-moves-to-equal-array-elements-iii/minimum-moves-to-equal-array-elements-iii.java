// class Solution {
//     public int minMoves(int[] nums) {
//         int mx = Integer.MIN_VALUE;

//         for (int x : nums) {
//             mx = Math.max(mx, x);
//         }

//         int res = 0;

//         for (int x : nums) {
//             res += (mx - x);
//         }

//         return res;
//     }
// }

class Solution {
    public int minMoves(int[] nums) {
        int max=Integer.MIN_VALUE;
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            if(nums[i]>max){
                max=nums[i];
            }
        }
        return max*nums.length-sum;
       
    }
}