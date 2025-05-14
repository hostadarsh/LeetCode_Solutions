// class Solution {
//     public int largestRectangleArea(int[] heights) {

//         int[] rb = new int[heights.length];
       
//         Stack<Integer> st = new Stack<>();
//         st.push(heights.length-1);
//         rb[heights.length - 1] = heights.length;

//         for(int i = heights.length - 2; i >= 0; i--){
//             while(!st.isEmpty() && heights[st.peek()] >= heights[i] ){
//                 st.pop();
//             }
//             if(st.isEmpty()){
//                 rb[i] = heights.length;
//             }
//             else{
//                 rb[i] = st.peek();
//             }
//             st.push(i);
//         }

//         int[] lb = new int[heights.length];
//         st = new Stack<>();
//         st.push(0);
//         lb[0] = -1; 

//         for(int i = 0; i < heights.length; i++){
//             while(!st.isEmpty() && heights[st.peek()] >= heights[i]){
//                 st.pop();
//             }

//             if(st.isEmpty()){
//                 lb[i] = -1;
//             }
//             else{
//                 lb[i] = st.peek();
//             }
//             st.push(i);
//         }

//         int maxArea = 0;

//         for(int i = 0; i < heights.length; i++){
//             int area = (rb[i] - lb[i] - 1) * heights[i];
//             maxArea = Math.max(maxArea, area);
//         }

//         return maxArea;

        
//     }
// }

// class Solution {
//     public int largestRectangleArea(int[] heights) {

//         int n = heights.length;
//         Stack<Integer> st = new Stack<>();
//         int maxA = 0;

//         for(int i = 0; i <= n; i++){
//             while(!st.isEmpty() && (i == n || heights[st.peek()] >= heights[i])){
//                 int height = heights[st.peek()];
//                 st.pop();
//                 int width;

//                 if(st.isEmpty()){
//                     width = i;
//                 }
//                 else{
//                     width = i - st.peek() - 1;
//                     }
//                 maxA = Math.max(maxA, width * height);
//             }
//             st.push(i);
//         }
//         return maxA;

//     }
// }

class Solution {
    public int largestRectangleArea(int[] heights) {

        Stack<Integer> st = new Stack<>();
        int n = heights.length;
        int maxA = 0;

        for(int i = 0; i < n; i++){
            while(!st.isEmpty() && heights[i] <= heights[st.peek()]){
                int height = heights[st.peek()];
                st.pop();
                int width;
                if(st.isEmpty()){
                    width = i;
                }
                else{
                    width = i - st.peek() - 1;
                }
                maxA = Math.max(maxA, height * width); 
            }
            st.push(i);
        }
         while(!st.isEmpty()){
            int height = heights[st.pop()];
            int width = st.isEmpty() ? n : n - st.peek() - 1;
            maxA = Math.max(maxA, height * width);
        }
        return maxA;
    }
}