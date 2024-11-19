import java.util.*;

class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        Set<Integer> s = new HashSet<>();
        long sum = 0, mx = 0;
        int j = 0;

        for (int i = 0; i < nums.length; i++) {
            while (s.contains(nums[i])) {
                sum -= nums[j];
                s.remove(nums[j]);
                j++;
            }

            s.add(nums[i]);
            sum += nums[i];

            if (s.size() == k) {
                mx = Math.max(mx, sum);
                sum -= nums[j];
                s.remove(nums[j]);
                j++;
            }
        }

        return mx;
    }
}