class Solution {
    public String answerString(String word, int numFriends) {
        if(numFriends == 1){
            return word;
        }

        String ans = "";
        int length = word.length() - numFriends + 1;

        for(int i = 0 ; i < word.length(); i++){

            String temp;
            if(i + length <= word.length()){
                temp = word.substring(i , i + length);
            }
            else{
                temp = word.substring(i);
            }

            if(ans.compareTo(temp) < 0){
                ans = temp;
            }
        }
        return ans;
    }
}