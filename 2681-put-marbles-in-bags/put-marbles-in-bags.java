// class Solution {
//     public long putMarbles(int[] weights, int k) {
//         if (k == 1) {
//             return 0;
//         }

//         List<Integer> pairSums = new ArrayList<>();
//         for (int i = 0; i < weights.length - 1; i++) {
//             pairSums.add(weights[i] + weights[i + 1]);
//         }

//         Collections.sort(pairSums);

//         long minScore = 0, maxScore = 0;
//         for (int i = 0; i < k - 1; i++) {
//             minScore += pairSums.get(i);
//             maxScore += pairSums.get(pairSums.size() - 1 - i);
//         }

//         return maxScore - minScore;
//     }
// }


class Solution {

    public long putMarbles(int[] weights, int k) {
        // We collect and sort the value of all n - 1 pairs.
        int n = weights.length;
        int[] pairWeights = new int[n - 1];
        for (int i = 0; i < n - 1; ++i) {
            pairWeights[i] = weights[i] + weights[i + 1];
        }
        // We will sort only the first (n - 1) elements of the array.
        Arrays.sort(pairWeights, 0, n - 1);

        // Get the difference between the largest k - 1 values and the
        // smallest k - 1 values.
        long answer = 0l;
        for (int i = 0; i < k - 1; ++i) {
            answer += pairWeights[n - 2 - i] - pairWeights[i];
        }

        return answer;
    }
}