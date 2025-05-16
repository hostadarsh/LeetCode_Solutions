// class Solution {
//     public boolean differByOneChar(String word1, String word2) {
//         if (word1.length() != word2.length()) return false;
//         int diffCount = 0;
//         for (int i = 0; i < word1.length(); i++)
//             if (word1.charAt(i) != word2.charAt(i))
//                 diffCount++;
//         return diffCount == 1;
//     }

//     public List<String> getWordsInLongestSubsequence(String[] words, int[] groups) {
//         int n = groups.length;
//         int[] dp = new int[n];
//         int[] parent = new int[n];
//         Arrays.fill(dp, 1);
//         Arrays.fill(parent, -1);
//         int maxi = 0;

//         for (int i = 0; i < n; i++) {
//             for (int j = 0; j < i; j++) {
//                 if (groups[i] != groups[j] &&
//                     differByOneChar(words[i], words[j]) &&
//                     dp[i] < dp[j] + 1) {
//                     dp[i] = dp[j] + 1;
//                     parent[i] = j;
//                 }
//             }
//             if (dp[i] > maxi) maxi = dp[i];
//         }

//         List<String> result = new ArrayList<>();
//         for (int i = 0; i < n; i++) {
//             if (dp[i] == maxi) {
//                 while (i != -1) {
//                     result.add(words[i]);
//                     i = parent[i];
//                 }
//                 break;
//             }
//         }
//         Collections.reverse(result);
//         return result;
//     }
// }

class Solution {
    public List<String> getWordsInLongestSubsequence(String[] words, int[] groups) {
        int n = words.length;
        Map<Long, List<Integer>> map = new HashMap();
        
        int[] ansNext = new int[n];
        int[] lengths = new int[n];
        
        int ansIndex = 0;

        Arrays.fill(ansNext, n);

        for (int left = n - 1; left >= 0; left--) {
            String word = words[left];
            int len = word.length();
            int res = 1;
            long completeMask = 0l;
            long[] masks = new long[len];
            for (int i = 0; i < len; i++) {
                completeMask |= masks[i] = (long)(word.charAt(i) - 'a' + 1) << (5 * i);
            }
            for (int i = 0; i < len; i++) {
                long targetMask = completeMask ^ masks[i];
                List<Integer> queue = map.computeIfAbsent​(targetMask, (j) -> new ArrayList());
                for (int idx : queue) {
                    if (res >= lengths[idx] + 1 || groups[idx] == groups[left] ) continue;
                    res = lengths[idx] + 1;
                    ansNext[left] = idx;
                }
                queue.add(left);
            }
            lengths[left] = res;
            if (lengths[ansIndex] < res) ansIndex = left;
        }

        List<String> ans = new ArrayList(lengths[ansIndex]);
        for (int i = ansIndex; i < n; i = ansNext[i]) {
            ans.add(words[i]);
        }

        return ans;
    }
}