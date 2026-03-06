class Solution {
    public boolean checkOnesSegment(String s) {
        if(s.length() == 1){
            return true;
        }

        int count = 0;

        for(int i = 1; i < s.length(); i++){
            if (s.charAt(i) - '0' == 0){
                count = 1;
            }

            if( count == 1 && s.charAt(i) - '0' == 1){
                return false;
            }
        }
        return true;
    }
}