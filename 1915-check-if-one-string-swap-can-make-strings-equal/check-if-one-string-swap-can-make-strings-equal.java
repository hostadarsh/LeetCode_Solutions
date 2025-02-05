class Solution {
    public boolean areAlmostEqual(String s1, String s2) {

        int a = -1, b= -1, count = 0;

        for(int i = 0 ; i < s1.length(); i++ ){
             if(s1.charAt(i) != s2.charAt(i)){
                count++;
                if(a == -1){
                    a = i;
                }
                else if( b == -1){
                    b = i;
                }
            }
        }

            if( count == 0){
                return true;
            }
            else if(count == 2 && s1.charAt(a) == s2.charAt(b) && s1.charAt(b) == s2.charAt(a)){
                return true;
            }

            return false;
        }
        
    }