// class Solution {
//     public int minCost(int[][] grid) {
//         int m = grid.length, n = grid[0].length;
//         int[][] dist = new int[m][n];
//         for (int[] row : dist) Arrays.fill(row, Integer.MAX_VALUE);
//         Deque<int[]> dq = new ArrayDeque<>();
//         dq.offerFirst(new int[]{0, 0});
//         dist[0][0] = 0;
//         int[] dx = {0, 0, 1, -1}, dy = {1, -1, 0, 0};
        
//         while (!dq.isEmpty()) {
//             int[] curr = dq.pollFirst();
//             int x = curr[0], y = curr[1];
//             int curDir = grid[x][y] - 1;
//             for (int dir = 0; dir < 4; dir++) {
//                 int nx = x + dx[dir], ny = y + dy[dir];
//                 if (nx >= 0 && ny >= 0 && nx < m && ny < n) {
//                     int cost = dist[x][y] + (dir == curDir ? 0 : 1);
//                     if (cost < dist[nx][ny]) {
//                         dist[nx][ny] = cost;
//                         if (dir == curDir) {
//                             dq.offerFirst(new int[]{nx, ny});
//                         } else {
//                             dq.offerLast(new int[]{nx, ny});
//                         }
//                     }
//                 }
//             }
//         }
//         return dist[m - 1][n - 1];
//     }
// }


class Solution {
    public int minCost(int[][] grid) {
       rows = grid.length;
        cols = grid[0].length;
        visited = new boolean[rows][cols];
        
        int cost = 0;
        runAll(grid, 0,0);
        //System.out.println(dq.size());
        while(!dq.isEmpty()) {
            for(int round = dq.size(); round>0; round--) {
                int[] cur= dq.pollFirst();
                int r=cur[0], c=cur[1];
                if(r==rows-1 && c==cols-1) return cost;
                runAll(grid, r, c);
                for(int k=0; k<4; k++) {
                    runAll(grid, r+dr[k], c+dc[k]);
                }
            }
            cost++;
        }
        return -1;
    }
    Deque<int[]> dq = new LinkedList();
    int[] dr = new int[]{0,0,1,-1}, dc = new int[]{1,-1,0,0};
    boolean[][] visited;
    int rows, cols;
    
    private void runAll(int[][] grid, int r, int c) {
        while(r>=0 && r<rows && c >= 0 && c<cols && !visited[r][c]) {
            visited[r][c] = true;
            int dir = grid[r][c]-1;
            dq.addLast(new int[]{r,c});
            r += dr[dir];
            c += dc[dir];
        }
    }
}