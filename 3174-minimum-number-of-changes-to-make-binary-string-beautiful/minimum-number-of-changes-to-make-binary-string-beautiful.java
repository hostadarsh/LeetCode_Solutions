// class Solution {
//     public int minChanges(String s) {
        
//         int count = 0;

//         for(int i = 0; i< s.length(); i=i+2){
//             if(s.charAt(i) != s.charAt(i+1)){
//                 count++;
//             }
//         }
//         return count;
//     }
// }

class Solution {
    public int minChanges(String s){
        int ans = 0, c = 0;
        for(int i = 0; i< s.length() ; i++){
            c = c + s.charAt(i) - '0';
            if(i%2==1){
                ans = ans + (c%2);
                c = 0;
            }
        }
        return ans;
    }
}