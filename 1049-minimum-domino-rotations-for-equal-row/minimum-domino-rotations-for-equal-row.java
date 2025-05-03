// class Solution {
//     public int minDominoRotations(int[] tops, int[] bottoms) {
//         int n = tops.length, res = Integer.MAX_VALUE;
//         int[] face = new int[7];
//         for (int i = 0; i < n; i++) {
//             face[tops[i]]++;
//             if (bottoms[i] != tops[i]) face[bottoms[i]]++;
//         }
//         for (int x = 1; x <= 6; x++) {
//             if (face[x] < n) continue;
//             int maintainTop = 0, maintainBottom = 0;
//             boolean possible = true;
//             for (int i = 0; i < n; i++) {
//                 if (tops[i] != x && bottoms[i] != x) {
//                     possible = false;
//                     break;
//                 }
//                 if (tops[i] != x) maintainTop++;
//                 if (bottoms[i] != x) maintainBottom++;
//             }
//             if (possible) res = Math.min(res, Math.min(maintainTop, maintainBottom));
//         }
//         return res == Integer.MAX_VALUE ? -1 : res;
//     }
// }


class Solution {
    private int helper(int[] tops, int[] bottoms, int val) {
        int top_res = 0, bottom_res = 0;
        for (int i = 0; i < tops.length; i++) {
            if (tops[i] != val && bottoms[i] != val) {
                return -1;
            } else if (tops[i] != val) {
                top_res++;
            } else if (bottoms[i] != val) {
                bottom_res++;
            }
        }
        return Math.min(top_res, bottom_res);
    }



    public int minDominoRotations(int[] tops, int[] bottoms) {
        
        
        int ans = -1;
        for (int i = 1; i < 7; i++) {
            int cur_ans = helper(tops, bottoms, i);

            if (cur_ans != -1 && (ans == -1 || ans > cur_ans)) {
                ans = cur_ans;
            }
        }
        return ans;
    }
}