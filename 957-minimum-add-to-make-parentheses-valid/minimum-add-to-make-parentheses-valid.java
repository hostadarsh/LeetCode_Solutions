// class Solution {
//     public int minAddToMakeValid(String s) {
//         int open = 0, add = 0;
//         for (char c : s.toCharArray()) {
//             if (c == '(') {
//                 open++;
//             } else {
//                 if (open > 0) {
//                     open--;
//                 } else {
//                     add++;
//                 }
//             }
//         }
//         return add + open;
//     }
// }


class Solution {
    public int minAddToMakeValid(String s) {
        Stack<Character> st = new Stack<>();
        int count = 0;
        for(char ch : s.toCharArray()){
            if(ch == '('){
                st.push(ch);
            }
            else{
                if(!st.isEmpty()){
                    st.pop();
                }
                else{
                    count++;
                }
            }
        }

        return st.size() + count;
    }
}