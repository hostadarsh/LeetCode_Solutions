// class Solution {
//     int evenA, oddA, evenB, oddB;
//     List<List<Integer>> buildList(int[][] edges) {
//         int n = edges.length + 1;
//         List<List<Integer>> adj = new ArrayList<>();
//         for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
//         for (int[] e : edges) {
//             adj.get(e[0]).add(e[1]);
//             adj.get(e[1]).add(e[0]);
//         }
//         return adj;
//     }
//     void dfsColor(List<List<Integer>> adj, int u, int parent, int[] color, boolean isA) {
//         if (color[u] == 0) {
//             if (isA) evenA++;
//             else evenB++;
//         } else {
//             if (isA) oddA++;
//             else oddB++;
//         }
//         for (int v : adj.get(u)) if (v != parent) {
//             color[v] = color[u] ^ 1;
//             dfsColor(adj, v, u, color, isA);
//         }
//     }
//     public int[] maxTargetNodes(int[][] edges1, int[][] edges2) {
//         List<List<Integer>> adjA = buildList(edges1), adjB = buildList(edges2);
//         int n = adjA.size(), m = adjB.size();
//         int[] colorA = new int[n], colorB = new int[m];
//         Arrays.fill(colorA, -1);
//         Arrays.fill(colorB, -1);
//         evenA = oddA = evenB = oddB = 0;
//         colorA[0] = 0;
//         dfsColor(adjA, 0, -1, colorA, true);
//         colorB[0] = 0;
//         dfsColor(adjB, 0, -1, colorB, false);
//         int maxiB = Math.max(evenB, oddB);
//         int[] res = new int[n];
//         for (int i = 0; i < n; i++)
//             res[i] = (colorA[i] == 0 ? evenA : oddA) + maxiB;
//         return res;
//     }
// }

class Solution {
    public int[] maxTargetNodes(int[][] edges1, int[][] edges2) {
        final int[] targets1 = computeTargets(edges1);
        final int offset = findMax(computeTargets(edges2));
        for (int i = 0; i < targets1.length; i++) {
            targets1[i] += offset;
        }
        return targets1;
    }

    static final int findMax(int[] values) {
        int maximum = 0;
        for (int val : values) {
            maximum = Math.max(maximum, val);
        }
        return maximum;
    }

    static int[] computeTargets(int[][] connections) {
        final int nodeCount = connections.length + 1;
        final int[] edgeCount = new int[nodeCount];
        final int[] xorLink = new int[nodeCount];
        final int[] result = new int[nodeCount];
        Arrays.fill(result, 1);
        final int[] stack = new int[nodeCount];

        for (int[] pair : connections) {
            final int u = pair[0];
            final int v = pair[1];
            edgeCount[u]++;
            edgeCount[v]++;
            xorLink[u] ^= v;
            xorLink[v] ^= u;
        }

        int stackLength = 0;
        for (int i = 0; i < nodeCount; i++) {
            if (edgeCount[i] == 1) {
                stack[stackLength++] = i;
            }
        }

        for (int i = 0; i < connections.length; i++) {
            final int current = stack[i];
            final int parent = xorLink[current];
            xorLink[parent] ^= current;
            result[parent] -= result[current];
            if (--edgeCount[parent] == 1) {
                stack[stackLength++] = parent;
            }
        }

        final int central = stack[nodeCount - 1];
        result[central] = (nodeCount + result[central]) / 2;

        for (int i = nodeCount - 2; i >= 0; i--) {
            final int current = stack[i];
            result[current] = nodeCount - result[xorLink[current]];
        }

        return result;
    }
}