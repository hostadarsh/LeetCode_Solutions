// class Solution {
//     static int V, D;

//     public int countCompleteComponents(int n, int[][] edges) {
//         List<Integer>[] A = new ArrayList[n];
//         Arrays.setAll(A, _ -> new ArrayList<>());

//         for (int[] e : edges) {
//             A[e[0]].add(e[1]);
//             A[e[1]].add(e[0]);
//         }

//         boolean[] vis = new boolean[n];
//         int res = 0;

//         for (int i = 0; i < n; i++) {
//             boolean state = vis[i];

//             if (!state) {
//                 V = 0; D = 0;

//                 dfs(i, A, vis);

//                 if (D == V * (V - 1)) res++;
//             }
//         }

//         return res;
//     }

//     private void dfs(int x, List<Integer>[] A, boolean[] vis) {
//         V++;
//         D += A[x].size();
//         vis[x] = true;

//         for (int state : A[x])
//             if (!vis[state])
//                 dfs(state, A, vis);
//     }
// }


class Solution {
    int[] rank;
    int[] parent;

    public int find(int u)
    {
        if(u==parent[u]) return u;

        return parent[u]=find(parent[u]);
    }
    public void union(int u,int v)
    {
        int pu=find(u);
        int pv=find(v);
        if(pu==pv) return;

        if(rank[pu]>rank[pv])
        {
            parent[pv]=pu;
        }
        else if(rank[pv]>rank[pu])
        {
            parent[pu]=pv;
        }
        else{
            parent[pu]=pv;
            rank[pv]++;
        }
    }
    public int countCompleteComponents(int n, int[][] edges) {
        rank=new int[n];
        parent=new int[n];

        for(int i=0;i<n;i++)
        {
            parent[i]=i;
        }
        for(int[] e:edges)
        {
            union(e[0],e[1]);
        }

        int[] nodes = new int[n];
        for(int i=0;i<n;i++)
        {
            nodes[find(i)]++;
        }
        int[] edge = new int[n];
        for(int[] e:edges)
        {
            int root=find(e[0]);
            edge[root]++;
        }
        int ans=0;
        for(int i=0;i<n;i++)
        {
            if(nodes[i]==0) continue;
            int reqedge=nodes[i]*(nodes[i]-1)/2;

            if(reqedge==edge[i]) ans++;
        }
        return ans;
    }
}