class Solution {
    public void setZeroes(int[][] matrix) {

        //step - 1 - Take first row and first column as markers - if they are 0 all he horizontal avd Vertical will be 0 
        int m = matrix.length;
        int n = matrix[0].length;
        int col0 = 1;

        for(int i = 0; i < m; i++ ){
            for(int j = 0; j < n; j++){
                if(matrix[i][j] == 0){
                    // mark i-th row
                    matrix[i][0] = 0;
                   
                
                if(j != 0){
                    matrix[0][j] = 0;
                }
                else{
                    col0 = 0;
                }
            }
        }
    }

    // step - 2 - mark the inner matrix except n = 0 or m = 0 to 0 according to the m = 0 & n = 0 (marker index)

    for(int i = 1; i < m ; i++ ){
        for(int j = 1; j < n; j++ ){
            if(matrix[i][j] != 0){
                // check for marker column and row if they are 0 or not
                if(matrix[i][0] == 0 || matrix[0][j] == 0){
                    matrix[i][j] = 0;
                }
            }
        }
    }

    // step 3 - finally mark 1st and 2nd column but first we will do row because row[0] will affect the column if changed, but for 
    // column we can use col0 which is a seperate col

    if(matrix[0][0] == 0){
        for(int j = 0; j<n ; j++){
             matrix[0][j] = 0;    
        }
    }

        if(col0 == 0){
            for(int i = 0; i<m; i++){
                matrix[i][0]=0;
            }
        }
    

    }
}