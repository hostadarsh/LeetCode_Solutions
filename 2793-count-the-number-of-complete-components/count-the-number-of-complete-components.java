// class Solution {
//     int[] parent;
//     int[] rank;

//     public int countCompleteComponents(int n, int[][] edges) {
//         parent = new int[n];
//         rank = new int[n];

//         for (int i = 0; i < n; i++) {
//             parent[i] = i;
//         }

//         for (int[] edge : edges) {
//             union(edge[0], edge[1]);
//         }

//         Map<Integer, Set<Integer>> componentVertices = new HashMap<>();
//         Map<Integer, Integer> componentEdges = new HashMap<>();

//         for (int i = 0; i < n; i++) {
//             int root = find(i);
//             componentVertices.computeIfAbsent(root, k -> new HashSet<>()).add(i);
//         }

//         for (int[] edge : edges) {
//             int root = find(edge[0]);
//             componentEdges.put(root, componentEdges.getOrDefault(root, 0) + 1);
//         }

//         int completeCount = 0;
//         for (int root : componentVertices.keySet()) {
//             int numVertices = componentVertices.get(root).size();
//             int expectedEdges = numVertices * (numVertices - 1) / 2;

//             if (componentEdges.getOrDefault(root, 0) == expectedEdges) {
//                 completeCount++;
//             }
//         }

//         return completeCount;
//     }

//     int find(int x) {
//         if (parent[x] != x) {
//             parent[x] = find(parent[x]);
//         }
//         return parent[x];
//     }

//     void union(int x, int y) {
//         int rootX = find(x);
//         int rootY = find(y);
//         if (rootX == rootY) return;

//         if (rank[rootX] < rank[rootY]) {
//             parent[rootX] = rootY;
//         } else if (rank[rootX] > rank[rootY]) {
//             parent[rootY] = rootX;
//         } else {
//             parent[rootY] = rootX;
//             rank[rootX]++;
//         }
//     }
// }

class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        int[] parent = new int[n];
        int[] numEdgesForComponent = new int[n];
        int[] numVert = new int[n];
        for(int i = 0; i < n; i++) {
            parent[i] = i;
            // numEdgesForComponent[i] = 0;
            numVert[i] = 1;
        }
        for(int[] edge : edges) {
            int p1 = getParent(parent, edge[0]);
            int p2 = getParent(parent, edge[1]);
            if (p1 == p2) {
                // already connected via p1(i.e. p2)
                // numComponents stays same
                numEdgesForComponent[p1]++;
                continue;
            } else {
                if (numVert[p1] > numVert[p2]) {
                    numVert[p1] += numVert[p2];
                    numEdgesForComponent[p1] += numEdgesForComponent[p2];
                    numEdgesForComponent[p1]++;
                    parent[p2] = p1;
                } else {
                    numVert[p2] += numVert[p1];
                    numEdgesForComponent[p2] += numEdgesForComponent[p1];
                    numEdgesForComponent[p2]++;
                    parent[p1] = p2;
                }
            }
        }

        // System.out.println("Parent: " + Arrays.toString(parent));
        // System.out.println("Vert: " + Arrays.toString(numVert) + ", edges: " + Arrays.toString(numEdgesForComponent));

        int numCompleteComp = 0;
        for(int i = 0; i < n; i++) {
            if (parent[i] == i) {
                // only look at parent
                int expectedEdges = numVert[i] * (numVert[i] - 1) / 2;
                if (expectedEdges == numEdgesForComponent[i]) {
                    numCompleteComp++;
                }
            }
        }

        return numCompleteComp;
    }

    private int getParent(int[] parent, int node) {
        int current = node;
        while(current != parent[current]) {
            current = parent[current];
        }
        return current;
    }
}