class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int res = 0;  // To store the result (number of subarrays divisible by k)
    int prefix = 0;  // Running prefix sum
    int[] map = new int[k];  // Hash map to count occurrences of each remainder
    map[0] = 1;  // There's one way to have a sum divisible by k starting from the beginning
    for (int i = 0; i < nums.length; i++) {
        // Update the prefix sum and normalize the remainder
        prefix = (prefix + nums[i] % k + k) % k;
        // Add the count of current remainder to the result
        res += map[prefix];
        // Increment the count of this remainder for future subarrays
        map[prefix]++;
    }
    return res;
        
    }
}