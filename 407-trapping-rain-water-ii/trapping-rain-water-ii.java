// class Solution {

//     public int trapRainWater(int[][] heightMap) {
//         int m=heightMap.length;
//         int n=heightMap[0].length;
//         boolean[][] visited=new boolean[m][n];

//         PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[0]-b[0]);

//         //Set the boundary element as visited
//         for(int i=0; i<m; i++){
//             for(int j=0; j<n; j++){
//                 if(i==0 || i==m-1 || j==0 || j==n-1){
//                     pq.add(new int[]{heightMap[i][j], i, j});
//                     visited[i][j]=true;
//                 }
//             }
//         }


//         int[][] direction={ {0,1}, {0,-1}, {1,0}, {-1,0} };

//         int waterVolume=0;

//         //Applying the BFS Traversal
//         while(!pq.isEmpty()){
//             int[] arr=pq.poll();
//             int cv=arr[0];    //Curr value
//             int cr=arr[1];    //Curr row
//             int cc=arr[2];    //Curr column

//             //Visiting the adjacent elemetns of current element
//             for(int[] dir:direction){
//                 int nr=cr+dir[0];   //New row
//                 int nc=cc+dir[1];   //New column    

//                 // Checking the element is within row, column and not visited
//                 if(nr>=0 && nr<m && nc>=0 && nc<n && !visited[nr][nc]){
                    
//                     //volume of water it can trap after raining.
//                     if(cv-heightMap[nr][nc]>0){
//                         waterVolume+=cv-heightMap[nr][nc];
//                         pq.add(new int[]{cv, nr, nc});
//                     }
//                     else{
//                         pq.add(new int[]{heightMap[nr][nc], nr, nc});
//                     }

//                     visited[nr][nc]=true;
//                 }
                
//             }
//         }

//         return waterVolume;
//     }

// }             

class Solution {
    public int trapRainWater(int[][] heightMap) {
        int m = heightMap.length;
        int n = heightMap[0].length;
        
        // initialization
        int[][] vols = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                vols[i][j] = heightMap[i][j];
            }
        }

        //spread
        boolean upt = true;
        boolean init = true;
        while (upt) {
            upt = false;
            // from left top
            for (int i = 1; i < m - 1; i++) {
                for (int j = 1; j < n - 1; j++) {
                    int val = Math.max(heightMap[i][j], Math.min(vols[i - 1][j], vols[i][j - 1]));
                    if (init || vols[i][j] > val) {
                        vols[i][j] = val;
                        upt = true;
                    }
                }
            }
            init = false;

            //from down right
            for (int i = m - 2; i >= 1; i--) {
                for (int j = n - 2; j >= 1; j--) {
                    int val = Math.max(heightMap[i][j], Math.min(vols[i + 1][j], vols[i][j + 1]));
                    if (vols[i][j] > val) {
                        vols[i][j] = val;
                        upt = true;
                    }
                }
            }
        }

        // calculate result
        int res = 0;
        for (int i = 1; i < m - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                if (vols[i][j] > heightMap[i][j])
                    res += vols[i][j] - heightMap[i][j];
            }
        }
        return res;
    }
}