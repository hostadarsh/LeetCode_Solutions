// class Solution {
//     public int countSymmetricIntegers(int low, int high) {
//         int count = 0; // \U0001f365 Shadow Clone counter

//         for (int num = low; num <= high; num++) {
//             String str = Integer.toString(num); // \U0001f3ad Transform number to string
//             int len = str.length();

//             // \U0001f525 Skip if it doesn't have even chakra balance (odd number of digits)
//             if (len % 2 != 0) continue;

//             int half = len / 2;
//             int leftSum = 0;
//             int rightSum = 0;

//             // ⬅️ Sum of the left half (first n digits)
//             for (int i = 0; i < half; i++) {
//                 leftSum += str.charAt(i) - '0';
//             }

//             // ➡️ Sum of the right half (last n digits)
//             for (int i = half; i < len; i++) {
//                 rightSum += str.charAt(i) - '0';
//             }

//             // ☯️ If chakra is balanced, count it
//             if (leftSum == rightSum) {
//                 count++;
//             }
//         }

//         return count; // \U0001f365 Final mission report
//     }
// }

class Solution {
    private static final short[] symCount = new short[10_001];
    
    
    public int countSymmetricIntegers(int low, int high) {
        if (symCount[11] == 0)  buildCounts();
        return symCount[high] - symCount[low - 1];
    }
    
    
    // One time build of the array of how many symmetric numbers 
    // exist at or below any index value.  After the first 
    // leetcode test case, this will not be called for the 
    // remainder of the submit test cases.  The values in 
    // symCount[] will be preserved between a submit's test cases.
    private void buildCounts() {
        // Fill in 0 to 99.
        for (int num = 11; num <= 99; num++)
            symCount[num] = (short)(num / 11);
        
        // Fill in 100 to 999.  No symmetric numbers in this range 
        // since odd number of digits, to just copy the count for 
        // symCount[99].
        short prev = symCount[99];
        for (int num = 100; num <= 999; num++)
            symCount[num] = prev;
        
        // Fill in 1000 to 9999
        prev = symCount[999];
        int idx = 1000;
        for (int high10 = 1; high10 <= 9; high10++) {
            for (int high1 = 0; high1 <= 9; high1++) {
                final int highSum = high10 + high1;
                for (int low10 = 0; low10 <= 9; low10++) 
                    for (int low1 = 0; low1 <= 9; low1++) 
                        symCount[idx++] = (short)((highSum == low10 + low1) ? ++prev : prev);
            }
        }
        
        // Fill in 10_000.
        symCount[10_000] = symCount[9999];
    }
}