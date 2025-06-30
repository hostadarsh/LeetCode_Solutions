public class Solution {
    public int findLHS(int[] nums) {
        Arrays.sort(nums);
        int j = 0;
        int maxLength = 0;
        
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] - nums[j] > 1) {
                j++;
            }
            if (nums[i] - nums[j] == 1) {
                maxLength = Math.max(maxLength, i - j + 1);
            }
        }
        return maxLength;
    }
}

// public class Solution {
//     public int findLHS(int[] nums) {
//         Map<Integer, Integer> frequencyMap = new HashMap<>();
        
//         for (int num : nums) {
//             frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
//         }
        
//         int maxLength = 0;
        
//         for (int num : frequencyMap.keySet()) {
//             if (frequencyMap.containsKey(num + 1)) {
//                 int currentLength = frequencyMap.get(num) + frequencyMap.get(num + 1);
//                 maxLength = Math.max(maxLength, currentLength);
//             }
//         }
//         return maxLength;
//     }
// }