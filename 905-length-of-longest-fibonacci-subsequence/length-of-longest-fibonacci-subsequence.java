// class Solution {
//     public int lenLongestFibSubseq(int[] arr) {
//         int n = arr.length;
//         int[][] dp = new int[n][n];
//         int maxLen = 0;
        
//         for (int curr = 2; curr < n; curr++) {
//             int start = 0, end = curr - 1;
//             while (start < end) {
//                 int pairSum = arr[start] + arr[end];
//                 if (pairSum > arr[curr]) {
//                     end--;
//                 } else if (pairSum < arr[curr]) {
//                     start++;
//                 } else {
//                     dp[end][curr] = dp[start][end] + 1;
//                     maxLen = Math.max(dp[end][curr], maxLen);
//                     end--;
//                     start++;
//                 }
//             }
//         }
//         return maxLen == 0 ? 0 : maxLen + 2;
//     }
// }
class Solution {
    public int lenLongestFibSubseq(int[] arr) {
        int n = arr.length;
        int c = 1;
        while (n > 1) {
            n >>= 1;
            c++;
        }
        HashBrown yummy = new HashBrown(n << c);
        for (int i = 0; i < arr.length; i++) {
            yummy.place(arr[i]);
        }
        int high = arr[arr.length - 1];
        int max = 2;
        for (int i = 0; i < arr.length - max; i++) {
            int base = arr[i];
            int bound = arr.length - max + 1;
            for (int j = i + 1; j < bound; j++) {
                int[] last2 = fib(arr[j], base, max - 1);
                int last = last2[1];
                if (last > high) {
                    break;
                }
                int a = last2[0];
                int b = last;
                if (!checkPrev(yummy, a, b, base)) {
                    continue;
                }
                max++;
                while (yummy.has(a + b)) {
                    b = a + b;
                    a = b - a;
                    max++;
                }
            }
        }
        return (max == 2) ? 0 : max;
    }

    public boolean checkPrev(HashBrown yum, int a, int b, int base) {
        while (a != base) {
            if (!yum.has(b)) {
                return false;
            }
            a = b - a;
            b = b - a;
        }
        return true;
    }

    public int[] fib(int a1, int b1, int n) {
        
        int a = 1, b = 1, d = 0;
        int d1 = 0;
        int at = 0, bt = 0, dt = 0;

        while (n > 0) {
            if ((n & 1) == 1) {
                at = a1 * a + b1 * b;
                bt = a1 * b + b1 * d;
                dt = b1 * b + d1 * d;
                a1 = at;
                b1 = bt;
                d1 = dt;
            }
            n >>= 1;
            at = a * a + b * b;
            bt = a * b + b * d;
            dt = b * b + d * d;
            a = at;
            b = bt;
            d = dt;
        }
        return new int[] {b1, a1};
    }
}

class HashBrown {
    private Node[] buckets;
    private int cap;

    public HashBrown(int capacity) {
        cap = capacity;
        buckets = new Node[capacity];
    }
    public void place(int key) {
        buckets[key & cap - 1] = new Node(key, buckets[key & cap - 1]);
    }
    public boolean has(int key) {
        Node n = buckets[key & cap - 1];
        while (n != null) {
            if (n.key == key) {
                return true;
            }
            n = n.next;
        }
        return false;
    }
}

class Node {
    public int key;
    public Node next;

    public Node(int key, Node next) {
        this.key = key;
        this.next = next;
    }
}