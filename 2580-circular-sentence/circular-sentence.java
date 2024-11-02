class Solution {
    public boolean isCircularSentence(String sentence) {

        if(sentence.charAt(0) != sentence.charAt(sentence.length()-1)){
            return false;
        }

        int k = sentence.indexOf(" ");
        if(k == -1){
            return true;
        }
        
        for(int i = 1; i < sentence.length()-1; i++){
            if(sentence.charAt(i) == ' '){
                if(sentence.charAt(i-1) != sentence.charAt(i+1)){
                    return false;
                }
                
            }
        }
        return true;
        
    }
}
