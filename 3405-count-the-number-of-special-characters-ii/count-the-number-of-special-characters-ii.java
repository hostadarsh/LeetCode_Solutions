// class Solution {
//     public int numberOfSpecialChars(String word) {
        
//         int[] state = new int[26];

//         /*
//         0 -> not seen
//         1 -> lowercase seen
//         2 -> valid special
//        -1 -> invalid
//         */

//         for(char ch : word.toCharArray()){

//             // lowercase
//             if(Character.isLowerCase(ch)){

//                 int idx = ch - 'a';

//                 // lowercase after uppercase
//                 if(state[idx] == 2 || state[idx] == -1){
//                     state[idx] = -1;
//                 }
//                 else if(state[idx] == 0){
//                     state[idx] = 1;
//                 }
//             }

//             // uppercase
//             else{

//                 int idx = ch - 'A';

//                 // uppercase before lowercase
//                 if(state[idx] == 0){
//                     state[idx] = -1;
//                 }

//                 // proper lowercase before uppercase
//                 else if(state[idx] == 1){
//                     state[idx] = 2;
//                 }
//             }
//         }

//         int ans = 0;

//         for(int val : state){
//             if(val == 2){
//                 ans++;
//             }
//         }

//         return ans;
//     }
// }




class Solution {
    public int numberOfSpecialChars(String word) {

        int count = 0;
        
        int[] lower = new int[26];
        int[] upper = new int[26];

        Arrays.fill(lower, -1);
        Arrays.fill(upper, -1);

        for(int i = 0; i < word.length(); i++){
            char ch = word.charAt(i);

            if(Character.isLowerCase(ch)){
                lower[ch - 'a'] = i;
            }
            else if(Character.isUpperCase(ch) && upper[ch - 'A'] == -1){
                upper[ch - 'A'] = i;
            }
            else{
                continue;
            }
        }

        for(int i = 0; i < 26; i++){
             if(lower[i] != -1 && upper[i] != -1){
            if(lower[i] < upper[i]){
                count++;
            }
             }
        }

        return count;
        
    }
}