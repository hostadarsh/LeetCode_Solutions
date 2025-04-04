// class Solution {
//     public int countPalindromicSubsequence(String s) {
//         int[] R = new int[26];
//         for (char u : s.toCharArray()) {
//             R[u - 'a']++;
//         }
//         int[] L = new int[26];
//         HashSet<Integer> S = new HashSet<>();

//         for (int i = 0; i < s.length(); i++) {
//             int t = s.charAt(i) - 'a';
//             R[t]--;
//             for (int j = 0; j < 26; j++) {
//                 if (L[j] > 0 && R[j] > 0) {
//                     S.add(26 * t + j);
//                 }
//             }
//             L[t]++;
//         }

//         return S.size();
//     }
// }

class Solution {
    public int countPalindromicSubsequence(String s) {
        final int n = s.length();
        final byte[] sc = new byte[n];
        s.getBytes(0, n, sc, 0);
        
        final int[][] firstCounts = new int[26][26];
        final int[] firstIdx = new int[26];
        final int[] charCounts = new int[26];
        int foundLettersCount = 0;

        for (int i = 0; i < n; i++) {
            final int c = sc[i] - 'a';
            charCounts[c]++;
            if (firstIdx[c] == 0) {
                firstIdx[c] = i + 1;
                final int[] firsts = firstCounts[c];
                for (int j = 0; j < 26; j++) 
                    firsts[j] = charCounts[j];
                foundLettersCount++;
            }
        }

        int palindromeCount = 0;
        final boolean[] foundLast = new boolean[26];
        for (int i = n - 1; i >= 2; i--) {
            final int c = sc[i] - 'a';
            charCounts[c]--;
            if (!foundLast[c]) {
                foundLast[c] = true;
                if (i > firstIdx[c]) {
                    final int[] firsts = firstCounts[c];
                    for (int j = 0; j < 26; j++) 
                        if (charCounts[j] > firsts[j]) 
                            palindromeCount++;
                }
                if (--foundLettersCount == 0)  break;
            }
        }
        return palindromeCount;
    }
}