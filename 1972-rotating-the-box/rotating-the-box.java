// class Solution {
//     public char[][] rotateTheBox(char[][] box) {
//         int rows = box.length;
//         int col = box[0].length;

//         char[][] res = new char[col][rows];  // length of result box = length of row become length of col and vice versa
//         for(char[] row : res){
//             Arrays.fill(row, '.');
//         }

//         for(int r = 0 ; r < rows; r++){
//             int i = col - 1;
//             for(int c = col - 1; c>=0; c--){
//                 if(box[r][c] == '#'){
//                     res[i][rows - r - 1] = '#';
//                     i--;
//                 }
//                 else if(box[r][c] == '*'){
//                     res[c][rows - r - 1] = '*';
//                     i = c - 1; 
//                 }
//             }
//         }
//         return res;

        
//     }
// }


class Solution {
    public char[][] rotateTheBox(char[][] box) {
        int m = box.length, n = box[0].length;
        char [][] res = new char[n][m];
        for (int i = 0; i < m; ++i){
            for (int j = n - 1, k = n - 1; j >= 0; --j) {
                res[j][m - i - 1] = 
                '.';
                if (box[i][j] != '.') {
                    k = box[i][j] == '*' ? j : k;
                    res[k--][m - i - 1] = box[i][j];
                }
            }
        }
        return res;
    }
}