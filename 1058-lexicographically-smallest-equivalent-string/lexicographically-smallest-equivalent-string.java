// import java.util.*;

// class Solution {
//     public String smallestEquivalentString(String s1, String s2, String baseStr) {
//         Map<Character, List<Character>> adj = new HashMap<>();
//         int n = s1.length();

//         // Build the adjacency list
//         for (int i = 0; i < n; i++) {
//             char u = s1.charAt(i);
//             char v = s2.charAt(i);

//             adj.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
//             adj.computeIfAbsent(v, k -> new ArrayList<>()).add(u);
//         }

//         StringBuilder result = new StringBuilder();

//         for (char ch : baseStr.toCharArray()) {
//             boolean[] visited = new boolean[26];
//             char minChar = dfs(adj, ch, visited);
//             result.append(minChar);
//         }

//         return result.toString();
//     }

//     private char dfs(Map<Character, List<Character>> adj, char ch, boolean[] visited) {
//         visited[ch - 'a'] = true;
//         char minChar = ch;

//         for (char neighbor : adj.getOrDefault(ch, new ArrayList<>())) {
//             if (!visited[neighbor - 'a']) {
//                 char candidate = dfs(adj, neighbor, visited);
//                 if (candidate < minChar) {
//                     minChar = candidate;
//                 }
//             }
//         }

//         return minChar;
//     }
// }

class Solution {
    int[] parent = new int[26];

    private int findUltPar(int x) {
        if(parent[x] != x) {
            parent[x] = findUltPar(parent[x]);
        }
        return parent[x];
    }

    private void union(int u, int v) {
        int ultPar_u = findUltPar(u);
        int ultPar_v = findUltPar(v);

        if(ultPar_u != ultPar_v) {
            if(ultPar_u < ultPar_v) {
                parent[ultPar_v] = ultPar_u;
            } else {
                parent[ultPar_u] = ultPar_v;
            }
        } 
    }
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<26; i++) {
            parent[i] = i;
        }

        for(int i=0; i<s1.length(); i++) {
            int u = s1.charAt(i) - 'a';
            int v = s2.charAt(i) - 'a';

            union(u, v);
        }

        for(int i=0; i<baseStr.length(); i++) {
            int mappedChar = findUltPar(baseStr.charAt(i) - 'a');
            sb.append((char)(mappedChar + 'a'));
        }

        return sb.toString();
        }
}