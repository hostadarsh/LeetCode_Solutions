// class Solution {
//     public int[] vowelStrings(String[] words, int[][] queries) {
//         int n = words.length;
//         int[] Prefix = new int[n + 1];
//         Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));

//         for (int i = 0; i < n; i++) {
//             Prefix[i + 1] = Prefix[i];
//             if (vowels.contains(words[i].charAt(0)) && vowels.contains(words[i].charAt(words[i].length() - 1))) {
//                 Prefix[i + 1]++;
//             }
//         }

//         int[] ANS = new int[queries.length];
//         for (int i = 0; i < queries.length; i++) {
//             ANS[i] = Prefix[queries[i][1] + 1] - Prefix[queries[i][0]];
//         }
//         return ANS;
//     }
// }

class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        int n = words.length;
        int[] count = new int[n+1];
        for (int i=0;i<n;i++) {
            if (isVowelString(words[i])) {
                count[i+1]++;
            }
        }
        for (int i=1;i<=n;i++) {
            count[i]+= count[i-1];
        }
        int[] res = new int[queries.length];
        int i = 0;
        for (int[] q:queries) {
            int l = q[0];
            int r = q[1];
            res[i++] = count[r+1]-count[l];
        }
        return res;
    }
    public boolean isVowelString(String str) {
        return isVowel(str.charAt(0)) && isVowel(str.charAt(str.length()-1));
    }
    public boolean isVowel(char ch) {
        return ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u';
    }
}