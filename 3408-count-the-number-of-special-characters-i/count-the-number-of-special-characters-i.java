class Solution {
    public int numberOfSpecialChars(String word) {
        boolean[] small = new boolean[26];
        boolean[] large = new boolean[26];

        int count = 0;

        for(char ch : word.toCharArray()){
            if(ch >= 'a' && ch <= 'z'){
                small[ch - 'a'] = true;
            }
            else{
                large[ch - 'A'] = true;
            }
        }

        for(int i = 0; i < 26; i++){
            if(small[i] && large[i]){
                count++;
            }
        }

        return count;
    }
}