// class Solution {
//     public int[] asteroidCollision(int[] asteroids) {
//         Stack<Integer> stack = new Stack<>();

//         for (int asteroid : asteroids) {
//             boolean alive = true;

//             // Collision happens only if current is going left (negative) and stack top is going right (positive)
//             while (alive && asteroid < 0 && !stack.isEmpty() && stack.peek() > 0) {
//                 int top = stack.peek();

//                 if (top < -asteroid) {
//                     // Stack top is smaller → it explodes
//                     stack.pop();
//                 } else if (top == -asteroid) {
//                     // Both are same size → both explode
//                     stack.pop();
//                     alive = false;
//                 } else {
//                     // Stack top is bigger → current asteroid explodes
//                     alive = false;
//                 }
//             }

//             if (alive) {
//                 stack.push(asteroid);
//             }
//         }

//         // Convert stack to array
//         int[] result = new int[stack.size()];
//         for (int i = stack.size() - 1; i >= 0; i--) {
//             result[i] = stack.pop();
//         }

//         return result;
//     }
// }


class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        
        Stack<Integer> st = new Stack<>();

        for(int asteroid : asteroids){
            boolean alive = true;

            while(alive && asteroid < 0 && !st.isEmpty() && st.peek() > 0){
                int top = st.peek();
                if(top < -asteroid){
                    st.pop();
                }
                else if(top == -asteroid){
                    st.pop();
                    alive = false;
                }
                else{
                    alive = false;
                }
            }
            if(alive){
                st.push(asteroid);
            }
        }

        int[] result = new int[st.size()];
        for(int i = st.size() - 1; i >= 0; i--){
            result[i] = st.pop();
        } 
        return result;
    }
}
