// class Solution {
//     public int totalWaviness(int num1, int num2) {
        
//         int count = 0;

//         for(int j = num1; j <= num2; j++){
//             String str = String.valueOf(j);

//             for(int i = 1; i < str.length() - 1; i++){
//                 int digit = str.charAt(i) - '0';
//                 int prevDigit = str.charAt(i-1) - '0';
//                 int nextDigit = str.charAt(i+1) - '0';

//                 if(digit < prevDigit && digit < nextDigit || digit > prevDigit && digit > nextDigit){
//                     count++;
//                 }
//             }
//         }

//         return count;
//     }
// }


class Solution {
    private static int MAX = 100001;
    private static int[] dp = new int[MAX], pref = new int[MAX];

    static {
        for (int i = 100; i < MAX; i++) {
            int r = i % 10;
            int m = (i / 10) % 10;
            int l = (i / 100) % 10;

            int isWave = m > Math.max(l, r) || m < Math.min(l, r) ? 1 : 0;
            dp[i] = dp[i / 10] + isWave;
            pref[i] = pref[i - 1] + dp[i];
        }
    }

    public int totalWaviness(int num1, int num2) {
        return pref[num2] - pref[num1 - 1];
    }
}