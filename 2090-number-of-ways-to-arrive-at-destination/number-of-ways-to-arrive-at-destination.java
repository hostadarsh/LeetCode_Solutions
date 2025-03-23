// class Solution {
//     public int countPaths(int n, int[][] roads) {
//         List<List<int[]>> graph = new ArrayList<>();
//         for (int i = 0; i < n; i++) {
//             graph.add(new ArrayList<>());
//         }
        
//         for (int[] road : roads) {
//             int u = road[0], v = road[1], time = road[2];
//             graph.get(u).add(new int[]{v, time});
//             graph.get(v).add(new int[]{u, time});
//         }

//         long[] dist = new long[n];
//         int[] ways = new int[n];
//         Arrays.fill(dist, Long.MAX_VALUE);
//         dist[0] = 0;
//         ways[0] = 1;

//         PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a[0]));
//         pq.offer(new long[]{0, 0});

//         int MOD = 1_000_000_007;

//         while (!pq.isEmpty()) {
//             long[] curr = pq.poll();
//             long d = curr[0];
//             int node = (int) curr[1];

//             if (d > dist[node]) continue;

//             for (int[] neighbor : graph.get(node)) {
//                 int nextNode = neighbor[0];
//                 int time = neighbor[1];

//                 if (dist[node] + time < dist[nextNode]) {
//                     dist[nextNode] = dist[node] + time;
//                     ways[nextNode] = ways[node];
//                     pq.offer(new long[]{dist[nextNode], nextNode});
//                 } else if (dist[node] + time == dist[nextNode]) {
//                     ways[nextNode] = (ways[nextNode] + ways[node]) % MOD;
//                 }
//             }
//         }

//         return ways[n - 1];
//     }
// }


class Solution {
    long inf = Long.MAX_VALUE / 2;
    int mod = 1_000_000_007;
    public int countPaths(int n, int[][] roads) {
        long[][] graph = new long[n][n];
        long[] dist = new long[n];
        long[] count = new long[n];
        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(graph[i], inf);
        }
        Arrays.fill(dist, inf);

        for (int[] r: roads) {
            int u = r[0], v = r[1], time = r[2];
            graph[u][v] = time;
            graph[v][u] = time;
        }

        graph[0][0] = 0;
        dist[0] = 0;
        count[0] = 1;
        for (int i =0; i <n; i++) {
            int cur = -1;
            for (int j = 0; j <n; j++) {
                if (!visited[j] && (cur == -1 || dist[j] < dist[cur])) {
                    cur = j;
                }
            }
            visited[cur] = true;
            for (int j = 0; j < n ;j++) {
                if (j == cur) {
                    continue;
                }

                long newDist = dist[cur] + graph[cur][j];
                if (dist[j] > newDist) {
                    dist[j] = newDist;
                    count[j] = count[cur];
                } else if (dist[j] == newDist) {
                    count[j] += count[cur];
                    count[j] %= mod;
                }
            }
        }
        return (int)count[n - 1];
    }
}