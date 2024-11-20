// class Solution {
//     public int takeCharacters(String s, int k) {
//         int[] d = new int[3], h = new int[3];
//         for (char c : s.toCharArray()) d[c - 'a']++;
//         for (int i = 0; i < 3; i++) if ((d[i] -= k) < 0) return -1;
        
//         int m = 0, l = 0;
//         for (int r = 0; r < s.length(); r++) {
//             h[s.charAt(r) - 'a']++;
//             while (l <= r && h[s.charAt(r) - 'a'] > d[s.charAt(r) - 'a']) h[s.charAt(l++) - 'a']--;
//             m = Math.max(m, r - l + 1);
//         }
//         return s.length() - m;
//     }
// }

class Solution {
    public int takeCharacters(String s, int k) {
        int[] charCount = new int[3];
        char[] chars = s.toCharArray();
        int length = chars.length;
        
        int left;
        for (left = 0; left < length; left++) {
            charCount[chars[left] - 'a']++;
            if (isValidCount(charCount, k)) {
                break;
            }
        }
        
        if (left == length) {
            return -1;
        }
        
        int currentCount = left + 1;
        int minCount = currentCount;
        int right = length - 1;
        
        while (left >= 0) {
            int currentChar = chars[left] - 'a';
            
            if (charCount[currentChar] == k) {
                while (chars[left] != chars[right]) {
                    charCount[chars[right] - 'a']++;
                    right--;
                    currentCount++;
                }
                right--;
            } else {
                charCount[currentChar]--;
                currentCount--;
                minCount = Math.min(currentCount, minCount);
            }
            left--;
        }
        
        return minCount;
    }
    
    private boolean isValidCount(int[] count, int k) {
        return count[0] >= k && count[1] >= k && count[2] >= k;
    }
}


/* Simplest alternative 

class Solution {
    public int takeCharacters(String s, int k) {
        int[] freq = new int[3];
        int n = s.length();
        
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }
        
        if (freq[0] < k || freq[1] < k || freq[2] < k) {
            return -1;
        }
        
        int[] curr = new int[3];
        int maxLen = 0;
        int left = 0;
        
        for (int right = 0; right < n; right++) {
            curr[s.charAt(right) - 'a']++;
            
            while (left <= right && (curr[0] > freq[0] - k || 
                   curr[1] > freq[1] - k || 
                   curr[2] > freq[2] - k)) {
                curr[s.charAt(left) - 'a']--;
                left++;
            }
            
            maxLen = Math.max(maxLen, right - left + 1);
        }
        
        return n - maxLen;
    }
}
*/