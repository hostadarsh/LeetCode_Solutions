// class Solution {
//     static class Node {
//         int prod;
//         int[] freq;
//         Node(int k) {
//             prod = 1;
//             freq = new int[k];
//         }
//     }
    
//     int k;
//     Node[] tree;
//     int[] nums;
    
//     Node merge(Node L, Node R) {
//         Node res = new Node(k);
//         res.prod = (int)((1L * L.prod * R.prod) % k);
//         System.arraycopy(L.freq, 0, res.freq, 0, k);
//         for (int r = 0; r < k; r++) {
//             if (R.freq[r] != 0) {
//                 int nr = (int)((1L * L.prod * r) % k);
//                 res.freq[nr] += R.freq[r];
//             }
//         }
//         return res;
//     }
    
//     void build(int v, int tl, int tr) {
//         if (tl == tr) {
//             tree[v].prod = nums[tl] % k;
//             tree[v].freq[tree[v].prod] = 1;
//             return;
//         }
//         int tm = (tl + tr) / 2;
//         build(v * 2, tl, tm);
//         build(v * 2 + 1, tm + 1, tr);
//         tree[v] = merge(tree[v * 2], tree[v * 2 + 1]);
//     }
    
//     void update(int v, int tl, int tr, int pos, int val) {
//         if (tl == tr) {
//             tree[v].prod = val % k;
//             Arrays.fill(tree[v].freq, 0);
//             tree[v].freq[tree[v].prod] = 1;
//             return;
//         }
//         int tm = (tl + tr) / 2;
//         if (pos <= tm) update(v * 2, tl, tm, pos, val);
//         else update(v * 2 + 1, tm + 1, tr, pos, val);
//         tree[v] = merge(tree[v * 2], tree[v * 2 + 1]);
//     }
    
//     Node query(int v, int tl, int tr, int l, int r) {
//         if (l > r) return new Node(k);
//         if (l == tl && r == tr) return tree[v];
//         int tm = (tl + tr) / 2;
//         return merge(query(v * 2, tl, tm, l, Math.min(r, tm)),
//                      query(v * 2 + 1, tm + 1, tr, Math.max(l, tm + 1), r));
//     }
    
//     public int[] resultArray(int[] nums, int k, int[][] queries) {
//         this.k = k;
//         this.nums = nums;
//         int n = nums.length;
//         tree = new Node[4 * n];
//         for (int i = 0; i < tree.length; i++) tree[i] = new Node(k);
//         build(1, 0, n - 1);
//         int[] ans = new int[queries.length];
//         for (int i = 0; i < queries.length; i++) {
//             int idx = queries[i][0], val = queries[i][1], start = queries[i][2], x = queries[i][3];
//             update(1, 0, n - 1, idx, val);
//             Node res = query(1, 0, n - 1, start, n - 1);
//             ans[i] = res.freq[x];
//         }
//         return ans;
//     }
// }

class SegmentTree {

    private static final int MAXK = 6;
    private int k;
    private int n;
    private int[][] tree;

    public SegmentTree(int[] nums, int k) {
        this.k = k;
        this.n = nums.length;
        int size = 2 << Integer.toBinaryString(n).length();
        tree = new int[size][MAXK];
        build(nums, 1, 0, n - 1);
    }

    private void makeLeaf(int o, int value) {
        Arrays.fill(tree[o], 0);
        int r = value % k;
        tree[o][r] = 1;
        tree[o][k] = r;
    }

    private void mergePre(int[] left, int[] right, int[] result) {
        int mulL = left[k];
        int mulR = right[k];
        result[k] = (mulL * mulR) % k;

        for (int x = 0; x < k; x++) {
            result[x] = left[x];
        }
        for (int x = 0; x < k; x++) {
            result[(mulL * x) % k] += right[x];
        }
    }

    private void maintain(int o) {
        mergePre(tree[o * 2], tree[o * 2 + 1], tree[o]);
    }

    private void build(int[] nums, int o, int l, int r) {
        if (l == r) {
            makeLeaf(o, nums[l]);
            return;
        }
        int m = (l + r) / 2;
        build(nums, o * 2, l, m);
        build(nums, o * 2 + 1, m + 1, r);
        maintain(o);
    }

    public void update(int o, int l, int r, int index, int value) {
        if (l == r) {
            makeLeaf(o, value);
            return;
        }
        int m = (l + r) / 2;
        if (index <= m) {
            update(o * 2, l, m, index, value);
        } else {
            update(o * 2 + 1, m + 1, r, index, value);
        }
        maintain(o);
    }

    public int[] query(int o, int l, int r, int L, int R) {
        if (L <= l && r <= R) {
            return tree[o];
        }

        int m = (l + r) / 2;
        if (R <= m) {
            return query(o * 2, l, m, L, R);
        }
        if (L > m) {
            return query(o * 2 + 1, m + 1, r, L, R);
        }

        int[] left = query(o * 2, l, m, L, R);
        int[] right = query(o * 2 + 1, m + 1, r, L, R);
        int[] result = new int[MAXK];
        mergePre(left, right, result);
        return result;
    }
}

class Solution {

    public int[] resultArray(int[] nums, int k, int[][] queries) {
        int n = nums.length;
        SegmentTree seg = new SegmentTree(nums, k);
        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int[] q = queries[i];
            int index = q[0];
            int value = q[1];
            int start = q[2];
            int x = q[3];

            seg.update(1, 0, n - 1, index, value);
            int[] pre = seg.query(1, 0, n - 1, start, n - 1);
            ans[i] = pre[x];
        }

        return ans;
    }
}