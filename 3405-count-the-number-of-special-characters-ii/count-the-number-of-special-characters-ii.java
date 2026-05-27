class Solution {
    public int numberOfSpecialChars(String word) {
        
        int[] state = new int[26];

        /*
        0 -> not seen
        1 -> lowercase seen
        2 -> valid special
       -1 -> invalid
        */

        for(char ch : word.toCharArray()){

            // lowercase
            if(Character.isLowerCase(ch)){

                int idx = ch - 'a';

                // lowercase after uppercase
                if(state[idx] == 2 || state[idx] == -1){
                    state[idx] = -1;
                }
                else if(state[idx] == 0){
                    state[idx] = 1;
                }
            }

            // uppercase
            else{

                int idx = ch - 'A';

                // uppercase before lowercase
                if(state[idx] == 0){
                    state[idx] = -1;
                }

                // proper lowercase before uppercase
                else if(state[idx] == 1){
                    state[idx] = 2;
                }
            }
        }

        int ans = 0;

        for(int val : state){
            if(val == 2){
                ans++;
            }
        }

        return ans;
    }
}