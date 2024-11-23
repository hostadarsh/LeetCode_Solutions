class Solution {
    public char[][] rotateTheBox(char[][] box) {
        int rows = box.length;
        int col = box[0].length;

        char[][] res = new char[col][rows];  // length of result box = length of row become length of col and vice versa
        for(char[] row : res){
            Arrays.fill(row, '.');
        }

        for(int r = 0 ; r < rows; r++){
            int i = col - 1;
            for(int c = col - 1; c>=0; c--){
                if(box[r][c] == '#'){
                    res[i][rows - r - 1] = '#';
                    i--;
                }
                else if(box[r][c] == '*'){
                    res[c][rows - r - 1] = '*';
                    i = c - 1; 
                }
            }
        }
        return res;

        
    }
}