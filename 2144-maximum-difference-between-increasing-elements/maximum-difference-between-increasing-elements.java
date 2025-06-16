// class Solution {
//     public int maximumDifference(int[] nums) {
//         Stack<int[]> stack = new Stack<>(); // [value, index]
//         int diff = -1;

//         for (int i = 0; i < nums.length; i++) {
//             if (stack.isEmpty() || nums[i] < stack.peek()[0]) {
//                 stack.push(new int[]{nums[i], i});
//             }

//             if (!stack.isEmpty() && stack.peek()[1] < i && nums[i] > stack.peek()[0]) {
//                 diff = Math.max(diff, nums[i] - stack.peek()[0]);
//             }
//         }

//         return diff;
//     }
// }


class Solution {
    public int maximumDifference(int[] nums) {
        int i = 0;
        int max = 0;
        for(int j = 1; j < nums.length; j++){
            if(j > i && nums[j] > nums[i]){
                int tempMax = nums[j] - nums[i];
                if(tempMax > max){
                    max = tempMax;
                }
            }
            else {
                i = j;
            }
        }
        if(max == 0){
            return -1;
        }
        return max;
    }
}