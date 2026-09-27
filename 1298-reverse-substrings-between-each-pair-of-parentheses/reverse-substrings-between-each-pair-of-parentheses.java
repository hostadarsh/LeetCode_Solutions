// class Solution {
//     public String reverseParentheses(String s) {
        
//         Stack<Character> st = new Stack<>();

//         for(char ch : s.toCharArray()){
//             if(ch != ')'){
//                 st.push(ch);
//             }
//             else{
//                 StringBuilder temp = new StringBuilder();

//                 while(st.peek() != '('){
//                     temp.append(st.pop());
//                 }
//                 st.pop(); // for opening bracket

//                 for(char c : temp.toString().toCharArray()){
//                     st.push(c);
//                 }
//             }
//         }

//         StringBuilder ans = new StringBuilder();
//         while(!st.isEmpty()){
//             ans.append(st.pop());
//         }

//         return ans.reverse().toString();
//     }
// }

class Solution {
    public String reverseParentheses(String s) {
        Stack<StringBuilder>stack = new Stack<>();
        StringBuilder curr = new StringBuilder();
        for(char ch:s.toCharArray()){
            if(ch=='('){
                stack.push(curr);
                curr = new StringBuilder();
            }
            else if(ch==')'){
                curr.reverse();
                StringBuilder temp = stack.pop();
                temp.append(curr);
                curr = temp;
            }
            else{
                curr.append(ch);
            }
        }
        return curr.toString();
    }
}