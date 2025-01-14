// class Solution {
//     public int[] findThePrefixCommonArray(int[] A, int[] B) {

//         int length = A.length;
//         int[] maxFreqA = new int[50];
//         int[] maxFreqB = new int[50];
//         int[] result = new int[length];
//         int count = 0;


//         for(int i = 0; i< length; i++){
//             maxFreqA[A[i]]++; 
//             maxFreqB[B[i]]++;
            

//             if(Arrays.equals(maxFreqA, maxFreqB)){
//                 count = countCommonElements(maxFreqA, maxFreqB);
//                 result[i] = count;
//             }           
//         }

//         return result;
       
//     }


//    public static int countCommonElements(int[] array1, int[] array2) {
//         // Add elements of the first array to a set
//         HashSet<Integer> set = new HashSet<>();
//         for (int num : array1) {
//             set.add(num);
//         }

//         // Check elements of the second array against the set
//         int count = 0;
//         for (int num : array2) {
//             if (set.contains(num)) {
//                 count++;
//                 set.remove(num); // Ensure no duplicates are counted
//             }
//         }

//         return count;
//     }
// }


class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        int[] freq = new int[n + 1];
        int[] ans = new int[n];
        int common = 0;

        for (int i = 0; i < n; i++) {
            if (++freq[A[i]] == 2) common++;
            if (++freq[B[i]] == 2) common++;
            ans[i] = common;
        }
        return ans;
    }
}