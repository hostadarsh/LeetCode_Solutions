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

// public class Solution {

//     public String shortestBeautifulSubstring(String s, int k) {
//         char[] input = s.toCharArray();

//         int head = -1;
//         int tail = -1;

//         int back = 0;
//         int countOnes = 0;

//         for (int front = 0; front < input.length; ++front) {
//             countOnes += input[front] - '0';
//             if (countOnes < k) {
//                 continue;
//             }

//             while (back < front && input[back] == '0') {
//                 countOnes -= input[back] - '0';
//                 ++back;
//             }

//             if (head == -1 || head - tail + 1 > front - back + 1) {
//                 head = front;
//                 tail = back;
//             } else if (head - tail + 1 == front - back + 1
//                     && s.substring(tail, head + 1).compareTo(s.substring(back, front + 1)) > 0) {
//                 head = front;
//                 tail = back;
//             }
//             while (back < front && countOnes == k) {
//                 countOnes -= input[back] - '0';
//                 ++back;
//             }
//         }
//         return head != -1 ? s.substring(tail, head + 1) : "";
//     }
// }

class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        int n = s.length();
        int count = 0;
        int lo = 0;
        String ans = "";
        for(int i = 0; i < n; i++){
            //Update counter
            if (s.charAt(i) == '1'){
                count++;
            }
            //Update left pointer if counter > k Or has prefix '0'
            while(count > k || (count == k && s.charAt(lo) == '0')){
                if(s.charAt(lo) == '1'){
                    count--;
                }
                lo++;
            }
            // Update ans
            if(count == k){
                String sub = s.substring(lo, i+1);
                if( ans == "" ||
                    sub.length() < ans.length() || 
                  ((sub.compareTo(ans) < 0) && (sub.length() == ans.length()))
                ){
                    ans = sub;
                }
            }
        }
        return ans;
    }
}