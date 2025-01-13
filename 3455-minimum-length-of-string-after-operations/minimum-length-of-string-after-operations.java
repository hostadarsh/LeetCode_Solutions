// class Solution {
//     public int minimumLength(String s) {

//         int[] maxCharFreq = new int[26];
//         int result = 0;
//         int totalFrequency = 0;

//         for(char ch : s.toCharArray()){
//             maxCharFreq[ch-'a']++;
//         }

//         for(int frequency : maxCharFreq){
//             if(frequency == 0){
//                 continue;
//             }
//             if(frequency % 2 == 0){
//                 result += 2;
//             }
//             else{
//                 result +=1;
//             }
//         }
//         return result;
//     }
// }


class Solution {
    static {
        for(int i = 0; i < 100; i++) {
            minimumLength("qbbqq");
        }
    }
    public static int minimumLength(String s) {
        int[] freq = new int[26];
        for(byte c: s.getBytes()) freq[c - 'a']++;
        int res = 0;
        for(int i: freq) {
            if (i == 0) continue;
            res += (i & 1 ^ 1) << 1 | i & 1;
        }
        return res;
    }
}