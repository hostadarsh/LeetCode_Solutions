// class Solution {
//     public int[] constructDistancedSequence(int n) {
//         int[] result = new int[2 * n - 1];
//         boolean[] used = new boolean[n + 1];
//         backtrack(result, used, n, 0);
//         return result;
//     }
//     private boolean backtrack(int[] result, boolean[] used, int n, int index){
//         while(index < result.length && result[index] != 0){
//             index++;
//         }
//         if(index == result.length){
//             return true;
//         }
//         for(int i = n; i >= 1; i--){
//             if(used[i]) continue;

//             if(i == 1){
//                 result[index] = 1;
//                 used[1] = true;
//                 if(backtrack(result, used, n, index + 1)) return true;
//                 result[index] = 0;
//                 used[1] = false;
//             }
//             else{
//                 if(index + i < result.length && result[index + i] == 0){
//                     result[index] = i;
//                     result[index + i] = i;
//                     used[i] = true;
//                     if(backtrack(result, used, n, index + 1)) return true;
//                     result[index] = 0;
//                     result[index + i] = 0;
//                     used[i] = false;
//                 }
//             }
//         }
//         return false;
//     }
// }
public class Solution {

    public int[] constructDistancedSequence(int targetNumber) {
        // Initialize the result sequence with size 2*n - 1 filled with 0s
        int[] resultSequence = new int[targetNumber * 2 - 1];

        // Keep track of which numbers are already placed in the sequence
        boolean[] isNumberUsed = new boolean[targetNumber + 1];

        // Start recursive backtracking to construct the sequence
        findLexicographicallyLargestSequence(
            0,
            resultSequence,
            isNumberUsed,
            targetNumber
        );

        return resultSequence;
    }

    // Recursive function to generate the desired sequence
    private boolean findLexicographicallyLargestSequence(
        int currentIndex,
        int[] resultSequence,
        boolean[] isNumberUsed,
        int targetNumber
    ) {
        // If we have filled all positions, return true indicating success
        if (currentIndex == resultSequence.length) {
            return true;
        }

        // If the current position is already filled, move to the next index
        if (resultSequence[currentIndex] != 0) {
            return findLexicographicallyLargestSequence(
                currentIndex + 1,
                resultSequence,
                isNumberUsed,
                targetNumber
            );
        }

        // Attempt to place numbers from targetNumber to 1 for a
        // lexicographically largest result
        for (
            int numberToPlace = targetNumber;
            numberToPlace >= 1;
            numberToPlace--
        ) {
            if (isNumberUsed[numberToPlace]) continue;

            isNumberUsed[numberToPlace] = true;
            resultSequence[currentIndex] = numberToPlace;

            // If placing number 1, move to the next index directly
            if (numberToPlace == 1) {
                if (
                    findLexicographicallyLargestSequence(
                        currentIndex + 1,
                        resultSequence,
                        isNumberUsed,
                        targetNumber
                    )
                ) {
                    return true;
                }
            }
            // Place larger numbers at two positions if valid
            else if (
                currentIndex + numberToPlace < resultSequence.length &&
                resultSequence[currentIndex + numberToPlace] == 0
            ) {
                resultSequence[currentIndex + numberToPlace] = numberToPlace;

                if (
                    findLexicographicallyLargestSequence(
                        currentIndex + 1,
                        resultSequence,
                        isNumberUsed,
                        targetNumber
                    )
                ) {
                    return true;
                }

                // Undo the placement for backtracking
                resultSequence[currentIndex + numberToPlace] = 0;
            }

            // Undo current placement and mark the number as unused
            resultSequence[currentIndex] = 0;
            isNumberUsed[numberToPlace] = false;
        }

        return false;
    }
}