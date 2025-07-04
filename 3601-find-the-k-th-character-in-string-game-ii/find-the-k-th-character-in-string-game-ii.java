// class Solution {
//     public char kthCharacter(long k, int[] operations) {
//         int shift = 0; // total number of +1 (mod 26) operations
//         List<Long> lengths = new ArrayList<>();
//         long len = 1;

//         for (int op : operations) {
//             len *= 2;
//             lengths.add(len);
//             if (len >= k) break;
//         }

//         for (int i = lengths.size() - 1; i >= 0; i--) {
//             long half = lengths.get(i) / 2;
//             int op = operations[i];

//             if (k > half) {
//                 k -= half;
//                 if (op == 1) shift++;
//             }
//             // else: k remains the same
//         }

//         // Apply total shift from 'a'
//         return (char) ((('a' - 'a' + shift) % 26) + 'a');
//     }
// }


class Solution {
    public char kthCharacter(long k, int[] A) {
        int res = 0, n = A.length;
        k -= 1;
        for (int i = 0; i < n && i < 60; ++i)
            if ((k >> i) % 2 > 0)
                res += A[i];
        return (char)('a' + res % 26);
    }
}