// import java.util.Arrays;

// class Solution {
//     public boolean canConstruct(String s, int k) {
//         if (s.length() < k) return false;

//         char[] chars = s.toCharArray();
//         Arrays.sort(chars);
//         int oddCount = 0;

//         for (int i = 0; i < chars.length; ) {
//             char current = chars[i];
//             int count = 0;
//             while (i < chars.length && chars[i] == current) {
//                 count++;
//                 i++;
//             }
//             if (count % 2 != 0) oddCount++;
//         }

//         return oddCount <= k;
//     }
// }

class Solution {
    public boolean canConstruct(String s, int k) {
        // Handle edge cases
        if (s.length() < k) return false;
        if (s.length() == k) return true;

        // Initialize oddCount as an integer bitmask
        int oddCount = 0;

        // Update the bitmask for each character in the string
        for (char chr : s.toCharArray()) {
            oddCount ^= 1 << (chr - 'a');
        }

        // Return if the number of odd frequencies is less than or equal to k
        return Integer.bitCount(oddCount) <= k;
    }
}