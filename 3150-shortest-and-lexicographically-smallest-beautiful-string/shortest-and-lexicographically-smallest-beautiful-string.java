// class Solution {
//     public String shortestBeautifulSubstring(String s, int k) {
//         String ans = "";
//         int n = s.length();

//         for (int i = 0; i < n; i++) {

//             int oneCnt = 0;
//             StringBuilder cur = new StringBuilder();

//             for (int j = i; j < n; j++) {

//                 cur.append(s.charAt(j));

//                 if (s.charAt(j) == '1')
//                     oneCnt++;

//                 // More than k ones can never become valid again
//                 if (oneCnt > k)
//                     break;

//                 if (oneCnt == k) {
//                     String curStr = cur.toString();

//                     if (ans.isEmpty() ||
//                         curStr.length() < ans.length() ||
//                         (curStr.length() == ans.length() && curStr.compareTo(ans) < 0)) {

//                         ans = curStr;
//                     }
//                 }
//             }
//         }

//         return ans;
//     }
// }

public class Solution {

    public String shortestBeautifulSubstring(String s, int k) {
        char[] input = s.toCharArray();

        int head = -1;
        int tail = -1;

        int back = 0;
        int countOnes = 0;

        for (int front = 0; front < input.length; ++front) {
            countOnes += input[front] - '0';
            if (countOnes < k) {
                continue;
            }

            while (back < front && input[back] == '0') {
                countOnes -= input[back] - '0';
                ++back;
            }

            if (head == -1 || head - tail + 1 > front - back + 1) {
                head = front;
                tail = back;
            } else if (head - tail + 1 == front - back + 1
                    && s.substring(tail, head + 1).compareTo(s.substring(back, front + 1)) > 0) {
                head = front;
                tail = back;
            }
            while (back < front && countOnes == k) {
                countOnes -= input[back] - '0';
                ++back;
            }
        }
        return head != -1 ? s.substring(tail, head + 1) : "";
    }
}