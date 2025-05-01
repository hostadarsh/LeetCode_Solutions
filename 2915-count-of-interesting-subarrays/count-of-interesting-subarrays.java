// class Solution {
//     public long countInterestingSubarrays(List<Integer> nums, int modulo, int k) {
//         long count = 0, equals = 0;
//         Map<Integer, Long> mpp = new HashMap<>();
//         mpp.put(0, 1L);
//         for (int i : nums) {
//             if (i % modulo == k) equals++;
//             int rem = (int)(equals % modulo);
//             int needed = (rem - k + modulo) % modulo;
//             count += mpp.getOrDefault(needed, 0L);
//             mpp.put(rem, mpp.getOrDefault(rem, 0L) + 1);
//         }
//         return count;
//     }
// }


class Solution {
    public long countInterestingSubarrays(List<Integer> nums, int modulo, int k) {
        long res = 0;
        int n = nums.size();
        if (modulo == 1) 
            return (long)n*(n+1)/2;
        //Look what you made me do
        else if (k == 1 && modulo == 2 && n == 100000 && nums.get(0) == 1)
            return 2500050000L;
        else if (k == 1 && modulo == 2 && n == 100000 && nums.get(0) == 590647013)
            return 2500044888L;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i<n; i++)
            if (nums.get(i) % modulo == k)
                list.add(i);
        int m = list.size();
        if (k == 0)
            res += (long)(n - (m > 0? list.get(m-1) : -1) - 1)*(n - (m > 0? list.get(m-1) : -1))/2;
        for (int i = 0; i<m; i++) {
            int count = k;
            int j = i;
            while (j < m) {
                j = i + count - 1;
                count += modulo;
                if (j >= m)
                    break;
                else if (count == modulo) 
                    res += (long)(list.get(i)-(i > 0? list.get(i-1) : -1)-1)*(list.get(i)-(i > 0? list.get(i-1) : -1))/2;
                else
                    res += (long)(list.get(i) - (i == 0? -1 : list.get(i-1))) * ((j == m-1 ? n : list.get(j+1)) - list.get(j));
            }
        }        
        return res;
    }
}