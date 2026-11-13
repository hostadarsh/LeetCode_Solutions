// class Solution {
//     public long countNonDecreasingSubarrays(int[] nums, int k) {
//         Deque<Integer> starts = new ArrayDeque<>();  // where each plateau starts, left to right
//         long ans = 0, water = 0;
//         int n = nums.length, r = n - 1;
//         for (int l = n - 1; l >= 0; l--) {
//             int x = nums[l];
//             while (!starts.isEmpty() && nums[starts.peekFirst()] <= x) {  // x floods the plateau that starts at starts.peekFirst()
//                 int s = starts.pollFirst();
//                 int end = starts.isEmpty() ? r + 1 : starts.peekFirst();
//                 water += (long) (x - nums[s]) * (end - s);
//             }
//             starts.offerFirst(l);
//             while (water > k) {  // the right end leaves with its water
//                 water -= nums[starts.peekLast()] - nums[r];
//                 if (starts.peekLast() == r)
//                     starts.pollLast();
//                 r--;
//             }
//             ans += r - l + 1;
//         }
//         return ans;
//     }
// }

class Solution {
    public long countNonDecreasingSubarrays(int[] nums, int k) {
        int n = nums.length;

        long ans = 0;
        long cost = 0;

        int[] stack = new int[n];

        int head = 0;
        int top = 0;

        int j = n - 1;

        for (int i = n - 1; i >= 0; i--) {

            // Add nums[i].
            // Pop smaller values from the back.
            while (head < top && nums[stack[top - 1]] < nums[i]) {

                int x = stack[--top];

                int r = (head < top)
                      ? stack[top - 1]
                      : j + 1;

                cost += (long) (r - x) * (nums[i] - nums[x]);
            }

            stack[top++] = i;

            // Shrink from the right while too expensive.
            while (cost > k) {

                cost -= (long) nums[stack[head]] - nums[j];

                if (stack[head] == j) {
                    head++;
                }

                j--;
            }

            ans += j - i + 1;
        }

        return ans;
    }
}