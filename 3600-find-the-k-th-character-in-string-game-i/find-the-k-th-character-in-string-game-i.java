// class Solution {
//     public char kthCharacter(int k) {
//         StringBuilder sb = new StringBuilder("a");
//         while (sb.length() < k) {
//             int size = sb.length();
//             for (int i = 0; i < size; i++) {
//                 sb.append((char) ('a' + ((sb.charAt(i) - 'a') + 1) % 26));
//             }
//         }
//         return sb.charAt(k - 1);
//     }
// }

class Solution {
    public char kthCharacter(int k) {
        int ans = 0;
        int t;
        while (k != 1) {
            t = 31 - Integer.numberOfLeadingZeros(k);
            if ((1 << t) == k) {
                t--;
            }
            k = k - (1 << t);
            ans++;
        }
        return (char) ('a' + ans);
    }
}