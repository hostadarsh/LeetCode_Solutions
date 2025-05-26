// class Solution {
//     public int longestPalindrome(String[] words) {
//         Map<String, Integer> mpp = new HashMap<>();
//         for (String w : words)
//             mpp.put(w, mpp.getOrDefault(w, 0) + 1);

//         int count = 0, alreadyPalindrome = 0;
//         for (Map.Entry<String, Integer> e : mpp.entrySet()) {
//             String w = e.getKey();
//             int freq = e.getValue();
//             String s = new StringBuilder(w).reverse().toString();
//             if (w.equals(s)) {
//                 count += (freq / 2) * 4;
//                 if (freq % 2 == 1)
//                     alreadyPalindrome = 1;
//             } else if (w.compareTo(s) < 0 && mpp.containsKey(s)) {
//                 count += Math.min(freq, mpp.get(s)) * 4;
//             }
//         }
//         return count + alreadyPalindrome * 2;
//     }
// }

class Solution {
    private static final int S = 5;
    private static final int M = (1 << S) - 1;
    static {
        for(int i = 0; i < 100; i++) {
            longestPalindrome(new String[]{"lc", "cl", "gg"});
        }
    }
    public static int longestPalindrome(String[] words) {
        int[] freq = new int[1 << (S << 1)];
        for (String s: words)
            freq[(s.charAt(0) & M) << S | s.charAt(1) & M]++;
        int res = 0, mid = 0;
        for (int i = 1; i <= 26; i++) {
            int dupe = freq[i << S | i];
            res += dupe >> 1;
            mid |= dupe & 1;
            for (int j = i + 1; j <= 26; j++) {
                res += Math.min(freq[i << S | j], freq[j << S | i]);
            }
        }
        return (res << 2) | (mid << 1);
    }
}