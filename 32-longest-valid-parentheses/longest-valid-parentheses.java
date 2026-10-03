// class Solution {
//     public int longestValidParentheses(String s) {
        
//         int count = 0;
//         Stack<Character> st = new Stack<>();

//         for(char c : s.toCharArray()){
//             if(c == ')'){
//                 if(st.isEmpty()){
//                     continue;
//                 }    
//                 else{
//                     count += 2;
//                     st.pop();
//                 }
//             }
//             else{
//                 st.push(c);
//             }
//         }
//         return count;
//     }
// }

class Solution {
    public int longestValidParentheses(String s) {
        int res = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(')
                stack.push(i);
            else {
                stack.pop();
                
                if (stack.isEmpty())
                    stack.push(i);
                else
                    res = Math.max(res, i - stack.peek());
            }
        }
        
        return res;
    }
}