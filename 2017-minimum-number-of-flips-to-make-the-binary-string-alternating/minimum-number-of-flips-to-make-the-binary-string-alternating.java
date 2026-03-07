class Solution {
    public int minFlips(String s) {
        // int count = 0;

        // for(int i = 0; i < s.length(); i++){
        //     if(s.charAt(i) - '0' != (i%2)){
        //         count ++;
        //     }
        // }
        // return Math.min(count, s.length() - count );

         int n = s.length();
        String ss = s + s;

        int diff1 = 0;
        int diff2 = 0;
        int ans = Integer.MAX_VALUE;

        for(int i = 0; i < ss.length(); i++){

            char expected1 = (i % 2 == 0) ? '0' : '1';
            char expected2 = (i % 2 == 0) ? '1' : '0';

            if(ss.charAt(i) != expected1) diff1++;
            if(ss.charAt(i) != expected2) diff2++;

            if(i >= n){
                char prev1 = ((i-n) % 2 == 0) ? '0' : '1';
                char prev2 = ((i-n) % 2 == 0) ? '1' : '0';

                if(ss.charAt(i-n) != prev1) diff1--;
                if(ss.charAt(i-n) != prev2) diff2--;
            }

            if(i >= n-1){
                ans = Math.min(ans, Math.min(diff1, diff2));
            }
        }

        return ans;
    }
  
}