class Solution {
    public int minimumLength(String s) {

        int[] maxCharFreq = new int[26];
        int result = 0;
        int totalFrequency = 0;

        for(char ch : s.toCharArray()){
            maxCharFreq[ch-'a']++;
        }

        for(int frequency : maxCharFreq){
            if(frequency == 0){
                continue;
            }
            if(frequency % 2 == 0){
                result += 2;
            }
            else{
                result +=1;
            }
        }
        return result;
    }
}

