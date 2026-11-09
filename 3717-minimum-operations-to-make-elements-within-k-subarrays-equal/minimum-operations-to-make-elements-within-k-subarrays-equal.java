// class Window {
//     private final int[] nums;
//     private final int x, odd;
//     private final Comparator<Integer> order;  // by value, then by index
//     private final TreeSet<Integer> s;         // indices of the window
//     private int mid;                          // index of the (h+1)-th smallest: everything before it is the low half
//     private long low, total;

//     Window(int[] nums, int x) {
//         this.nums = nums;
//         this.x = x;
//         odd = x & 1;
//         order = (a, b) -> nums[a] != nums[b] ? Integer.compare(nums[a], nums[b]) : Integer.compare(a, b);
//         s = new TreeSet<>(order);
//         for (int i = 0; i < x; i++) {
//             s.add(i);
//             total += nums[i];
//         }
//         Iterator<Integer> it = s.iterator();
//         for (int i = 0; i < x / 2; i++)
//             low += nums[it.next()];
//         mid = it.next();
//     }

//     long cost() {  // larger half minus smaller half
//         return total - 2 * low - (long) odd * nums[mid];
//     }

//     long slide(int in) {
//         int out = in - x;
//         s.add(in);
//         if (order.compare(in, mid) < 0) {  // in joins the low half and pushes its largest up
//             mid = s.lower(mid);
//             low += nums[in] - nums[mid];
//         }
//         if (order.compare(out, mid) < 0) {  // out leaves the low half: mid moves down into it
//             low += nums[mid] - nums[out];
//             mid = s.higher(mid);
//         } else if (out == mid) {
//             mid = s.higher(mid);
//         }
//         s.remove(out);
//         total += nums[in] - nums[out];
//         return cost();
//     }
// }

// class Solution {
//     public long minOperations(int[] nums, int x, int k) {
//         int n = nums.length;
//         Window win = new Window(nums, x);
//         long[] cost = new long[n - x + 1];
//         cost[0] = win.cost();
//         for (int i = x; i < n; i++)
//             cost[i - x + 1] = win.slide(i);

//         long[] best = new long[n + 1];  // best[i]: min ops for the windows placed so far inside nums[0..i)
//         for (int j = 0; j < k; j++) {
//             long[] layer = new long[n + 1];
//             Arrays.fill(layer, 0, x, Long.MAX_VALUE / 2);
//             for (int i = x; i <= n; i++)
//                 layer[i] = Math.min(layer[i - 1], best[i - x] + cost[i - x]);
//             best = layer;
//         }
//         return best[n];
//     }
// }
class Solution {
    public long minOperations(int[] nums, int x, int k) {
        int n = nums.length;
        int[] vals = nums.clone();
        Arrays.sort(vals);
        int m = 0;
        for (int i = 0; i < n; i++) {
            if (m == 0 || vals[i] != vals[m - 1]) {
                vals[m++] = vals[i];
            }
        }
        int[] rk = new int[n];
        for (int i = 0; i < n; i++) {
            rk[i] = Arrays.binarySearch(vals, 0, m, nums[i]) + 1;
        }
        int[] cnt = new int[m + 1];
        long[] sm = new long[m + 1];
        int top = 1;
        while (top * 2 <= m) top *= 2;
        int need = (x + 1) / 2;
        int w = n - x + 1;
        long[] cost = new long[w];
        long total = 0;
        for (int i = 0; i < n; i++) {
            total += nums[i];
            for (int p = rk[i]; p <= m; p += p & -p) {
                cnt[p] += 1;
                sm[p] += nums[i];
            }
            if (i >= x) {
                total -= nums[i - x];
                for (int p = rk[i - x]; p <= m; p += p & -p) {
                    cnt[p] -= 1;
                    sm[p] -= nums[i - x];
                }
            }
            if (i >= x - 1) {
                int pos = 0, rem = need;
                long s0 = 0;
                for (int pw = top; pw > 0; pw >>= 1) {
                    int nxt = pos + pw;
                    if (nxt <= m && cnt[nxt] < rem) {
                        pos = nxt;
                        rem -= cnt[nxt];
                        s0 += sm[nxt];
                    }
                }
                long med = vals[pos];
                long c0 = need - rem;
                cost[i - x + 1] = med * c0 - s0 + (total - s0) - med * (x - c0);
            }
        }
        long INF = 1000000000000000000L;
        long[] prev = new long[n + 1];
        long[] cur = new long[n + 1];
        for (int j = 0; j < k; j++) {
            for (int i = 0; i < x; i++) cur[i] = INF;
            for (int i = x; i <= n; i++) {
                long a = cur[i - 1];
                long b = prev[i - x] + cost[i - x];
                cur[i] = a < b ? a : b;
            }
            long[] t = prev;
            prev = cur;
            cur = t;
        }
        return prev[n];
    }
}