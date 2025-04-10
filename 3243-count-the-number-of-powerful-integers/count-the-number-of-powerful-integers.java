// class Solution {
//     private Long[][] dp;
//     private String suffix;
//     private int limit;

//     public long numberOfPowerfulInt(long start, long finish, int limit, String suffix) {
//         this.limit = limit;
//         this.suffix = suffix;

//         long countToFinish = countValid(finish);
//         long countToStart = countValid(start - 1);
//         return countToFinish - countToStart;
//     }

//     private long countValid(long num) {
//         if (num < Long.parseLong(suffix)) return 0;
//         String numStr = Long.toString(num);
//         dp = new Long[numStr.length()][2];
//         return dfs(0, true, numStr);
//     }

//     private long dfs(int idx, boolean tight, String num) {
//         if (idx == num.length()) return 1L;
//         if (dp[idx][tight ? 1 : 0] != null) return dp[idx][tight ? 1 : 0];

//         long res = 0;
//         int maxDigit = tight ? num.charAt(idx) - '0' : 9;

//         int suffixStart = num.length() - suffix.length();
//         if (idx >= suffixStart) {
//             int suffixIdx = idx - suffixStart;
//             int digit = suffix.charAt(suffixIdx) - '0';
//             if (digit <= maxDigit && digit <= limit)
//                 res += dfs(idx + 1, tight && digit == maxDigit, num);
//         } else {
//             for (int d = 0; d <= Math.min(maxDigit, limit); d++) {
//                 res += dfs(idx + 1, tight && d == maxDigit, num);
//             }
//         }
//         return dp[idx][tight ? 1 : 0] = res;
//     }
// }


class Solution {
    public long numberOfPowerfulInt(long start, long finish, int limit, String s) {
        long suffix = 0L;
        for (char c : s.toCharArray())
            suffix = suffix * 10 + c - '0';
        if (suffix > finish)
            return 0;
        long div = (long) Math.pow(10, s.length()), ps = start / div, pf = finish / div;
        if (finish % div >= suffix)
            pf++;
        if (start % div > suffix)
            ps++;
        return getAvailNum(pf, limit) - getAvailNum(ps, limit);
    }

    private long getAvailNum(long num, long limit) {
        if (num == 0)
            return 0;
        if (limit == 9)
            return num;
        int digits = (int) Math.log10(num);
        long div = (long) Math.pow(10, digits), res = 0L;
        for (int i = digits; i >= 0; i--) {
            int d = (int) (num / div);
            if (d > limit)
                return res + (long) Math.pow(limit + 1, i + 1);
            else
                res += d * (long) Math.pow(limit + 1, i);
            num %= div;
            div /= 10;
        }
        return res;
    }
}