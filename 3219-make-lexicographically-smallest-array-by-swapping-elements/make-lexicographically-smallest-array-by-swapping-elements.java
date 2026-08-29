// class Solution {
//     public int[] lexicographicallySmallestArray(int[] nums, int limit) {
//         int n = nums.length;

//         int[] sorted = nums.clone();
//         Arrays.sort(sorted);

//         Map<Integer, List<Integer>> group = new HashMap<>();
//         Map<Integer, Integer> groupId = new HashMap<>();
//         Map<Integer, Integer> pos = new HashMap<>();

//         int id = 1;
//         group.computeIfAbsent(id, k -> new ArrayList<>()).add(sorted[0]);
//         groupId.put(sorted[0], id);

//         for(int i = 1; i < n; i++){
//             if(sorted[i] - sorted[i - 1] > limit){
//                 id++;
//             }

//             group.computeIfAbsent(id, k -> new ArrayList<>()).add(sorted[i]);
//             groupId.put(sorted[i], id);
//         }

//         // Rebuild nums using the smallest
//         // available value from its group
//         for(int i = 0; i < n; i++){
//             int grp = groupId.get(nums[i]);
//             int p = pos.getOrDefault(grp, 0);

//             nums[i] = group.get(grp).get(p);
//             pos.put(grp, p + 1);
//         }

//         return nums;
//     }
// }
class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int n = nums.length;
        int[][] arr = new int[n][2];

        for (int i = 0; i < n; i++) {
            arr[i][0] = nums[i];
            arr[i][1] = i;
        }

        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));

        int[] result = new int[n];
        int start = 0;

        while (start < n) {
            int end = start;

            while (end + 1 < n &&
                   (long) arr[end + 1][0] - arr[end][0] <= limit) {
                end++;
            }

            List<Integer> indices = new ArrayList<>();

            for (int i = start; i <= end; i++) {
                indices.add(arr[i][1]);
            }

            Collections.sort(indices);

            for (int i = 0; i < indices.size(); i++) {
                result[indices.get(i)] = arr[start + i][0];
            }

            start = end + 1;
        }

        return result;
    }
}