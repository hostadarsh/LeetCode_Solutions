// class Solution {
//     public int[] maxSlidingWindow(int[] nums, int k) {
//         int n = nums.length;
//         if (n == 0 || k == 0) return new int[0];

//         Stack<Integer> st = new Stack<>();
//         int[] ans = new int[n];
//         st.push(n-1);
//         ans[n-1] = n;

//         int[] max = new int[n-k+1];

//         for(int i = n - 2; i >= 0; i--){
//             while(!st.isEmpty() && nums[st.peek()] <= nums[i]){
//                 st.pop();
//             }

//             if(st.isEmpty()){
//                 ans[i] = n;
//             }
            
//             if(nums[st.peek()] > nums[i]){
//                 ans[i] = nums[st.peek()];
//             }
//             st.push(i);
//         }

//         for(int i = 0; i < n-k; i++){
//             max[i] = ans[i];
//             for(int j = 0; j < i+k; j++){
//                 if(ans[i] < ans[j]){
//                     max[i] = nums[j];
//                 }
//             }
//         }
//         return max;
        
//     }
// }

import java.util.*;

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] nge = new int[n];  // stores index of next greater element
        Stack<Integer> st = new Stack<>();

        // Build the Next Greater Element (NGE) index array
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && nums[st.peek()] <= nums[i]) {
                st.pop();
            }
            nge[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }

        // Build the result using the NGE array
        int[] result = new int[n - k + 1];
        int j = 0;

        for (int i = 0; i <= n - k; i++) {
            // Ensure j is within window [i, i+k)
            if (j < i) j = i;

            // Jump to next greater until it's outside the window
            while (nge[j] < i + k) {
                j = nge[j];
            }

            result[i] = nums[j];
        }

        return result;
    }
}
