class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {

        HashSet<Integer> hs = new HashSet<>();

        for (int num : arr1) {
            while (num > 0) {
                hs.add(num);
                num /= 10;
            }
        }

        int ans = 0;

        for (int num : arr2) {
            while (num > 0) {
                if (hs.contains(num)) {
                    ans = Math.max(ans, String.valueOf(num).length());
                }
                num /= 10;
            }
        }
        return ans;
    }
}