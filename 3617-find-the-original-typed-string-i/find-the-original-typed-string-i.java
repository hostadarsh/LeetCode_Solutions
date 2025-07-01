// class Solution {
//     public int possibleStringCount(String word) {
//         int[] freq = new int[26];
//         int ans = 1;
//         for(char ch : word.toCharArray()){
//             freq[ch - 'a']++;
//         }

//         for(int i = 0; i < freq.length; i++){
//             if(freq[i] > 1){
//                 ans = ans + freq[i] - 1;
//             }
//         }
//         return ans;
//     }
// }

class Solution {
    public int possibleStringCount(String word) {
        int n = word.length();
        int count = n;
        for(int i = 1 ; i < word.length() ; i++){
            if(word.charAt(i) != word.charAt(i-1)){
                count--;
            }
        }
        return count;
    }
}