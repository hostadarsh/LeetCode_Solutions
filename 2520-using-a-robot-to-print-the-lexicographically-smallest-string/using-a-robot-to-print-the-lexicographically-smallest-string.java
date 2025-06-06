// import java.util.*;

// class Solution {
//     public String robotWithString(String s) {
//         Stack<Character> stack = new Stack<>();
//         int[] freq = new int[26];
        
//         // Count frequency of each character
//         for (char ch : s.toCharArray()) {
//             freq[ch - 'a']++;
//         }
        
//         StringBuilder t = new StringBuilder();

//         for (char ch : s.toCharArray()) {
//             stack.push(ch);
//             freq[ch - 'a']--;

//             // Check if we can pop the top of the stack
//             while (!stack.isEmpty() && stack.peek() <= smallestChar(freq)) {
//                 t.append(stack.pop());
//             }
//         }

//         // Append remaining characters from stack
//         while (!stack.isEmpty()) {
//             t.append(stack.pop());
//         }

//         return t.toString();
//     }

//     // Helper function to find the smallest character still available
//     private char smallestChar(int[] freq) {
//         for (int i = 0; i < 26; i++) {
//             if (freq[i] > 0) {
//                 return (char) ('a' + i);
//             }
//         }
//         return 'a';
//     }
// }


class Solution {
    public String robotWithString(String s) {
        int[] freq = new int[26];
        int j = 0, i = 0;
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();

        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        while (i < 26 && freq[i] == 0) {
            i++;
        }

        for (char c : s.toCharArray()) {
            if (c - 'a' == i) {
                sb.append(c);
                freq[c - 'a']--;
                if (freq[c - 'a'] == 0) {
                    while (i < 26 && freq[i] == 0) {
                        i++;
                    }
                    while (i < 26 && sb2.length() > 0 && sb2.charAt(sb2.length() - 1) <= i + 'a') {
                        sb.append(sb2.charAt(sb2.length() - 1));
                        sb2.deleteCharAt(sb2.length() - 1);
                    }
                }
            } else {
                sb2.append(c);
                freq[c - 'a']--;
            }
        }

        sb2.reverse();
        sb.append(sb2);
        return sb.toString();
    }
}