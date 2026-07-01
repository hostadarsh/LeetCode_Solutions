class Solution {
           static int[]dr={-1,1,0,0};
           static int[]dc={0,0,-1,1};
           static int n;
    public int maximumSafenessFactor(List<List<Integer>> g) {
         n=g.size();
        Queue<Pair>q=new ArrayDeque<>();
        int[][]grid=new int[n][n];
           for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                int a=g.get(i).get(j);
                if(a==1){
                  q.add(new Pair(i,j));
                }
                grid[i][j]=a;
            }
           }
          while(!q.isEmpty()){
            Pair rv=q.poll();
             int r=rv.u;
             int c=rv.v;
             for(int i=0;i<4;i++){
                int nr=r+dr[i];
                int nc=c+dc[i];
                if(isValid(nr,nc)&&grid[nr][nc]<=0){
                    grid[nr][nc]=grid[r][c]+1;
                    q.offer(new Pair(nr,nc));
                }
             }
          }
          PriorityQueue<Pair>pq=new PriorityQueue<>((a,b)->Integer.compare(b.w,a.w));
          pq.offer(new Pair(grid[0][0],0,0));
          grid[0][0]=-1;
          while(!pq.isEmpty()){
              Pair rv=pq.poll();
              int sf=rv.w;
              int r=rv.u;
              int c=rv.v;
              if(r==n-1&&c==n-1){
                return sf-1;
              }
              for(int i=0;i<4;i++){
                int nr=r+dr[i];
                int nc=c+dc[i];
                if(isValid(nr,nc)&&grid[nr][nc]>0){
                    int nsf=Math.min(sf,grid[nr][nc]);
                    pq.offer(new Pair(nsf,nr,nc));
                    grid[nr][nc]=-1;
                }
              }
          }
          return 0;
           
    }
    public class Pair{
        int w;
        int u;
        int v;
        Pair(int u,int v){
            this.u=u;
            this.v=v;
        }
         Pair(int w,int u,int v){
            this.w=w;
            this.u=u;
            this.v=v;
         }

    }
    public static boolean isValid(int r,int c){
        if(r>=0&&r<n&&c>=0&&c<n){
            return true;
        }
      return false;
    }
}