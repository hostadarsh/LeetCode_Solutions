// class Solution {
//     private static final int MOD = 1_000_000_007;

//     private int power(long a, long b) {
//         long ans = 1;
//         a %= MOD;

//         while (b > 0) {
//             if ((b & 1) == 1) {
//                 ans = (ans * a) % MOD;
//             }

//             a = (a * a) % MOD;
//             b >>= 1;
//         }

//         return (int) ans;
//     }

//     private int dfs(int node, int parent, List<List<Integer>> adj) {
//         int ans = 0;

//         for (int child : adj.get(node)) {
//             if (child != parent) {
//                 ans = Math.max(ans, 1 + dfs(child, node, adj));
//             }
//         }

//         return ans;
//     }

//     public int assignEdgeWeights(int[][] edges) {
//         int n = edges.length + 2;

//         List<List<Integer>> adj = new ArrayList<>();
//         for (int i = 0; i < n; i++) {
//             adj.add(new ArrayList<>());
//         }

//         for (int[] edge : edges) {
//             int u = edge[0];
//             int v = edge[1];

//             adj.get(u).add(v);
//             adj.get(v).add(u);
//         }

//         int depth = dfs(1, -1, adj);

//         return power(2, depth - 1);
//     }
// }

import java.util.*;

class Solution {
    static final int MOD = 1_000_000_007;
    List<Integer>[] tree;
    
    public int assignEdgeWeights(int[][] edges) {
        int n = edges.length + 1;
        tree = new List[n + 1];
        for (int i = 1; i <= n; i++) tree[i] = new ArrayList<>();
        
        for (int[] e : edges) {
            int u = e[0], v = e[1];
            tree[u].add(v);
            tree[v].add(u);
        }
        
        int[] depth = new int[n + 1];
        dfs(1, -1, depth);
        
        int maxDepth = 0;
        for (int d : depth) maxDepth = Math.max(maxDepth, d);
        
        if (maxDepth == 0) return 0;
        return powMod(2, maxDepth - 1);
    }
    
    private void dfs(int u, int parent, int[] depth) {
        for (int v : tree[u]) {
            if (v != parent) {
                depth[v] = depth[u] + 1;
                dfs(v, u, depth);
            }
        }
    }
    
    private int powMod(long a, long b) {
        long res = 1;
        while (b > 0) {
            if ((b & 1) == 1) res = (res * a) % MOD;
            a = (a * a) % MOD;
            b >>= 1;
        }
        return (int) res;
    }
}