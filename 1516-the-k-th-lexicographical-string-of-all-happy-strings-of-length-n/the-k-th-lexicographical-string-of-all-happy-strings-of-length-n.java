// import java.util.*;
// class Solution {
//     public String getHappyString(int n, int k) {
//         Queue<String> q = new LinkedList<>();
//         q.offer("a");
//         q.offer("b");
//         q.offer("c");
//         List<String> happyStrings = new ArrayList<>();
        
//         while (!q.isEmpty()) {
//             String s = q.poll();
//             if (s.length() == n) {
//                 happyStrings.add(s);
//                 continue;
//             }
//             for (char ch : new char[]{'a', 'b', 'c'}) {
//                 if (s.charAt(s.length() - 1) != ch) {
//                     q.offer(s + ch);
//                 }
//             }
//         }
        
//         return k > happyStrings.size() ? "" : happyStrings.get(k - 1);
//     }
// }

class Solution {
    private static final char[] CHARS = new char[] { 'a', 'b', 'c' };
    public String getHappyString(int n, int k) {
	    StringBuilder sb = new StringBuilder();
	    build(n, '-', k, sb); // first we have fake `-` as parameter, so all `a`, `b` and `c` are valid as a first letter
	    return sb.toString();
    }
    
    private static void build(int n, char last, int k, StringBuilder sb) {
        if (n == 0) {
            return; // we have reached the leaf
        }
        int step = 1 << (n - 1); // number of elements in each branch, which is perfect binary tree
        int to = step;
        for (char c : CHARS) {
            if (c == last) continue; // we can't have two same letters in row
            if (k <= to) {
                build(n - 1, c, k - (to - step), sb.append(c)); // get the child tree and deduct the number of elements in left branch from k, if `to` is the right boundary of current branch, then (to-step) is the right boundary of the left branch, which is the number of all elements in it
				return;
            }
            to += step;
        }
    }
}