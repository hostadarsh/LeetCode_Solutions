// class Solution {
//     private void compute(int dir1, int dir2, int dir3, int dir4, int[] k_cnt, int[] dist) {
//         dist[dir1] += (k_cnt[dir1] > 0) ? 1 : -1;
//         k_cnt[dir1]--;

//         dist[dir2] += (k_cnt[dir2] > 0) ? 1 : -1;
//         k_cnt[dir2]--;

//         dist[dir3]++;
//         dist[dir4]++;
//     }

//     public int maxDistance(String s, int k) {
//         if (s.length() == k) return k;

//         int mx = 0;
//         int[] k_cnt = new int[4];
//         int[] dist = new int[4];
//         Arrays.fill(k_cnt, k);

//         for (int i = 0; i < s.length(); i++) {
//             char ch = s.charAt(i);
//             if (ch == 'N') {
//                 compute(1, 3, 0, 2, k_cnt, dist);
//             } else if (ch == 'E') {
//                 compute(2, 3, 1, 0, k_cnt, dist);
//             } else if (ch == 'W') {
//                 compute(0, 1, 2, 3, k_cnt, dist);
//             } else { // 'S'
//                 compute(0, 2, 1, 3, k_cnt, dist);
//             }

//             mx = Math.max(mx, Math.max(Math.max(dist[0], dist[1]), Math.max(dist[2], dist[3])));
//         }

//         return mx;
//     }
// }

// class Solution {
//     public int maxDistance(String st, int k) {
//         int n = 0;
//         int s = 0;
//         int e = 0;
//         int w = 0;

//         int result = 0;
//         char[] chars = st.toCharArray();

//         for (int i = 0; i < chars.length; i++) {
//             char c = chars[i];
//             if (c == 'N') {
//                 n++;
//             } else if (c == 'S') {
//                 s++;
//             } else if (c == 'E') {
//                 e++;
//             } else {
//                 w++;
//             }

//             int current = Math.abs(n-s) + Math.abs(e-w);
//             int distance = current + Math.min(2*k,i+1-current);
//             result = Math.max(result, distance);
//         }

//         return result;
//     }
// }

class Solution {
    public int maxDistance(String st, int k) {
        int north = 0, south = 0, east = 0, west = 0;
        int result = 0;
        char[] chars = st.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (c == 'N') {
                north++;
            } else if (c == 'S') {
                south++;
            } else if (c == 'E') {
                east++;
            } else {
                west++;
            }

            int currentDistance = Math.abs(north - south) + Math.abs(east - west);
            int stepsUsed = i + 1;

            // Max we can boost the distance by changing up to k steps (each gives +2)
            int maxBoost = Math.min(2 * k, stepsUsed - currentDistance);
            int possibleDistance = currentDistance + maxBoost;

            result = Math.max(result, possibleDistance);
        }

        return result;
    }
}

