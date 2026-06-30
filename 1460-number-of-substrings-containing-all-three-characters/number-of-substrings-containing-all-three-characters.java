// class Solution {
//     public int numberOfSubstrings(String s) {
        
//         int count = 0;
//         for(int i = 0; i < s.length(); i++ ){
//             for(int j = i + 3; j <= s.length(); j++){
//                 String part = s.substring(i,j);
//                 if(part.contains("a") && part.contains("b") && part.contains("c")){
//                     count++;
//                 }
//             }
//         }

//         return count;
//     }
// }

class Solution {
    public int numberOfSubstrings(String s) {

        int[] freq = new int[3];

        int left = 0;
        int ans = 0;

        for (int right = 0; right < s.length(); right++) {

            freq[s.charAt(right) - 'a']++;

            while (freq[0] > 0 && freq[1] > 0 && freq[2] > 0) {

                ans += s.length() - right;

                freq[s.charAt(left) - 'a']--;
                left++;
            }
        }

        return ans;
    }
}