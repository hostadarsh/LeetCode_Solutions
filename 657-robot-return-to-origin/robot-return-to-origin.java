class Solution {
    public boolean judgeCircle(String moves) {
        int countR = 0;
        int countL = 0;
        int countU = 0;
        int countD = 0;

        for(int i = 0; i < moves.length(); i++){
            char ch = moves.charAt(i);

        // for(char ch : moves.tocharArray()){

            if(ch == 'U'){
                countU++;
            }
            if(ch == 'D'){
                countD++;
            }
            if(ch == 'L'){
                countL++;
            }
            if(ch == 'R'){
                countR++;
            }
        }

        if(countR == countL && countU == countD){
            return true;
        }

        return false;
    }
}