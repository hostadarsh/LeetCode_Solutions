// class Solution {
//     public int mincostTickets(int[] days, int[] costs) {
//         int maxDay = days[days.length - 1];
//         boolean[] travelDay = new boolean[maxDay + 1];

//         for (int day : days)
//           travelDay[day] = true;

//         int[] dp = new int[maxDay + 1];
//         dp[0] = 0;

//         for (int i = 1; i <= maxDay; i++) {
//             if (!travelDay[i]) {
//                 dp[i] = dp[i - 1];
//                 continue;
//             }

//             dp[i] = costs[0] + dp[i - 1];
//             dp[i] = Math.min(dp[Math.max(0, i - 7)] + costs[1], dp[i]);
//             dp[i] = Math.min(dp[Math.max(0, i - 30)] + costs[2], dp[i]);
//         }

//         return dp[maxDay];
//     }
// }
class Solution {
    public int solve(int i, int n, int[] d, int[] c, int[] dp) {
        if (i >= n) {
            return 0;
        }

        if (dp[i] != -1) {
            return dp[i];
        }

        int o1 = c[0] + solve(i + 1, n, d, c, dp);

        int ni = n;
        for (int q = i; q < n; q++) {
            if (d[i] + 7 <= d[q]) {
                ni = q;
                break;
            }
        }
        int o2 = c[1] + solve(ni, n, d, c, dp);

        ni = n;
        for (int q = i; q < n; q++) {
            if (d[i] + 30 <= d[q]) {
                ni = q;
                break;
            }
        }
        int o3 = c[2] + solve(ni, n, d, c, dp);

        int res = Math.min(o1, Math.min(o2, o3));
        dp[i] = res;
        return res;
    }

    public int rec(int[] d, int[] c) {
        int n = d.length;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return solve(0, n, d, c, dp);
    }

    public int mincostTickets(int[] days, int[] costs) {
        return rec(days, costs);
    }
}



