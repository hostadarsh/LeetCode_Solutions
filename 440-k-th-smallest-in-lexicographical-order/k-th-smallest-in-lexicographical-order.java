// class Solution {
//     public int findKthNumber(int n, int k) {
//         int count = 1;  // This represents the current number in lexicographical order
//         int i = 1;

//         while (i < k) {
//             if (count * 10 <= n) {
//                 // Go deeper in lexicographical tree
//                 count = count * 10;
//             } else {
//                 // If at the end of a branch or exceeding n
//                 if (count >= n) {
//                     count = count / 10;
//                 }

//                 count++;  // Move to next lex number

//                 // Skip trailing zeros
//                 while (count % 10 == 0) {
//                     count = count / 10;
//                 }
//             }
//             i++;
//         }

//         return count;  // This is the k-th number
//     }
// }


class Solution {
    public int findKthNumber(int n, int k) {
        long curr = 1;
        k -= 1; // we already include 1 in our result

        while (k > 0) {
            long count = getCount(curr, n);
            if (count <= k) {
                // skip current prefix subtree
                curr++;
                k -= count;
            } else {
                // go deeper in the tree
                curr *= 10;
                k -= 1;
            }
        }
        return (int) curr;
    }

    private long getCount(long prefix, long n) {
        long count = 0;
        long current = prefix;
        long next = prefix + 1;

        while (current <= n) {
            count += Math.min(n + 1, next) - current;
            current *= 10;
            next *= 10;
        }
        return count;
    }
}