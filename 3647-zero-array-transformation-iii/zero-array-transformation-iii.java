// class Solution {
//     public static int maxRemoval(int[] nums, int[][] queries) {
//         int n = nums.length, q = queries.length;
//         List<List<Integer>> qEnd = new ArrayList<>();
//         for (int i = 0; i < n; i++) qEnd.add(new ArrayList<>());
//         for (int[] query : queries) {
//             qEnd.get(query[0]).add(query[1]);
//         }

//         PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
//         int[] cntQ = new int[n + 1];
//         int dec = 0;

//         for (int i = 0; i < n; i++) {
//             dec += cntQ[i];
//             for (int end : qEnd.get(i)) {
//                 pq.offer(end);
//             }

//             int x = nums[i];
//             while (x > dec && !pq.isEmpty() && pq.peek() >= i) {
//                 int k = pq.poll();
//                 cntQ[k + 1]--;
//                 dec++;
//             }

//             if (x > dec) return -1;
//         }

//         return pq.size();
//     }
// }


class Solution {
    public int maxRemoval(int[] nums, int[][] queries) {
        IntPriorityQueue pq = new IntPriorityQueue(queries.length + 1);
        pq.add(-1);
        int[][] ends = ends(nums.length, queries);
        int[] diff = new int[nums.length +1];
        int r = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > 0) diff[i] += diff[i - 1];
            for (int end : ends[i]) {
                pq.add(end);
            }
            while (diff[i] < nums[i]) {
                int idx = pq.poll();
                if (idx < i) return -1;
                diff[i]++;
                diff[idx + 1]--;
                r++;
            }
        }
        return queries.length - r;
    }

    static int[][] ends(int len, int[][] queries) {
        int[] counts = new int[len];
        for (int[] q : queries) {
            counts[q[0]]++;
        }
        int[][] ends = new int[len][];
        for (int i = 0; i < len; i++) {
            ends[i] = new int[counts[i]];
        }
        for (int[] q : queries) {
            final int q0 = q[0];
            ends[q0][--counts[q0]] = q[1];
        }
        return ends;
    }

    public class IntPriorityQueue {
        public int[] vals;
        private int size;

        IntPriorityQueue(int maxSize) {
            this.vals = new int[maxSize];
        }

        void add(int v) {
            vals[size] = v;
            moveUp(size++);
        }

        int poll() {
            int r = vals[0];
            moveDown(0, vals[--size]);
            return r;
        }

        private void moveDown(int idx, int val) {
            while (true) {
                int l = idx * 2 + 1;
                if (l >= size) break;
                int r = l + 1;
                int toSwap = r < size && vals[r] > vals[l] ? r : l;
                if (val < vals[toSwap]) {
                    vals[idx] = vals[toSwap];
                    idx = toSwap;
                } else {
                    break;
                }
            }
            vals[idx] = val;
        }

        private void moveUp(int idx) {
            while (idx > 0) {
                int parent = (idx - 1) / 2;
                if (vals[idx] <= vals[parent]) {
                    break;
                }
                swap(idx, parent);
                idx = parent;
            }
        }

        void swap(int a, int b) {
            int old = vals[a];
            vals[a] = vals[b];
            vals[b] = old;
        }

        int size() {
            return size;
        }
    }
}