// class Solution {
//     public long countGood(int[] nums, int k) {
//         Map<Integer, Integer> freq = new HashMap<>();
//         int left = 0;
//         long pairCount = 0;
//         long goodSubarrays = 0;

//         for (int right = 0; right < nums.length; right++) {
//             int count = freq.getOrDefault(nums[right], 0);
//             pairCount += count;
//             freq.put(nums[right], count + 1);

//             while (pairCount >= k) {
//                 goodSubarrays += nums.length - right;
//                 int leftNum = nums[left++];
//                 int f = freq.get(leftNum);
//                 freq.put(leftNum, f - 1);
//                 pairCount -= (f - 1);
//             }
//         }

//         return goodSubarrays;
//     }
// }

public class Solution {
    public long countGood(int[] nums, int k) {
        if (nums.length < 2) {
            return 0L;
        }
        Map<Integer, Integer> countMap = new HashMap<>(nums.length, 0.99f);
        long goodSubArrays = 0L;
        long current = 0L;
        int left = 0;
        int right = -1;
        while (left < nums.length) {
            if (current < k) {
                if (++right == nums.length) {
                    break;
                }
          
                Integer num = nums[right];
                Integer count = countMap.get(num);
                if (count == null) {
                    count = 1;
                } else {
                    current += count;
                    if (current >= k) {
                        goodSubArrays += nums.length - right;
                    }
                    count = count + 1;
                }
                countMap.put(num, count);
            } else {
                Integer num = nums[left++];
                int count = countMap.get(num) - 1;
                if (count > 0) {
                    countMap.put(num, count);
                    current -= count;
                } else {
                    countMap.remove(num);
                }
                if (current >= k) {
                    goodSubArrays += nums.length - right;
                }
            }
        }
        return goodSubArrays;
    }
}