// import java.util.*;

// class Solution {
//     public String triangleType(int[] nums) {
//         Arrays.sort(nums);
//         Set<Integer> set = new HashSet<>();
//         for (int num : nums) set.add(num);

//         if (nums[0] + nums[1] <= nums[2]) return "none";
//         if (set.size() == 1) return "equilateral";
//         if (set.size() == 2) return "isosceles";
//         return "scalene";
//     }
// }

class Solution {
    public String triangleType(int[] nums) {
        if (nums == null || nums.length != 3) {
            return "none";
        }
        int a = nums[0], b = nums[1], c = nums[2];

        if (a + b <= c || a + c <= b || b + c <= a) {
            return "none";
        }


        if (a == b && b == c) {
            return "equilateral";
        }
        if (a == b || b == c || c == a) {
            return "isosceles";
        } else {
            return "scalene";
        }
    }
}