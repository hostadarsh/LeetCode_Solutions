class Solution {
    public int furthestDistanceFromOrigin(String moves) {

        int Lcount = 0;
        int Rcount = 0;
        int count_ = 0;

        for(int i = 0; i < moves.length(); i++){
            if(moves.charAt(i) == 'L'){
                Lcount++;
            }
            else if(moves.charAt(i) == '_'){
                count_++;
            }
            else{
                Rcount++;
            }
        }

        int res = Lcount > Rcount ? Lcount - Rcount + count_ : Rcount - Lcount + count_; 
        
        return res;
    }
}