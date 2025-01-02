// class Solution {
//     public int maxScore(String s) {
//         int totalZeros = 0;
//         for (char c : s.toCharArray()) {
//             if (c == '0') totalZeros++;
//         }
//         int ans = -1, zeros = 0, n = s.length();
//         for (int i = 1; i < n; i++) {
//             if (s.charAt(i - 1) == '0') {
//                 zeros++;
//                 totalZeros--;
//             }
//             ans = Math.max(ans, zeros + (n - totalZeros - i));
//         }
//         return ans;
//     }
// }

class Solution {
    public int maxScore(String s) {
        int n = s.length();
        int ons = 0;
        int curr = s.charAt(0) == '0' ? 1 : 0;
        int score = curr;

        for (int i = 1; i < n - 1; i++) {
            if (s.charAt(i) == '0') {
                curr++;
            } else {
                ons++;
                curr--;
            }
            if (curr > score) {
                score = curr;
            }
        }
        ons += s.charAt(n - 1) == '1' ? 1 : 0;

        return ons + score;
    }
}