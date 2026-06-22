class Solution {
    public int maxNumberOfBalloons(String text) {
        int[] freq = new int[5];
        int count = 0;

        for(char ch : text.toCharArray()){
            if(ch == 'b'){
                freq[0]++;
            }
            else if(ch == 'a'){
                freq[1]++;
            }
            else if(ch == 'l'){
                freq[2]++;
            }
            else if(ch == 'o'){
                freq[3]++;
            }
            else if(ch == 'n'){
                freq[4]++;
            }
            else {
                continue;
            }
        }

        while(freq[0] > 0 && freq[1] > 0 && freq[2] > 1 && freq[3] > 1 && freq[4] > 0){
            count++;
            freq[0]--;
            freq[1]--;
            freq[2] -= 2;
            freq[3] -= 2;
            freq[4]--;
        }

        return count;
    }
}