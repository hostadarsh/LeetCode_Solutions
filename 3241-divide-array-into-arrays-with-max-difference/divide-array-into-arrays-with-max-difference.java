// class Solution {
//     public List<List<Integer>> divideArray(int[] nums, int k) {
//         Arrays.sort(nums);
//         List<List<Integer>> ans = new ArrayList<>();

//         for (int i = 0; i < nums.length; i += 3) {
//             if ( nums[i + 2] - nums[i] > k) {
//                 return new ArrayList<>();
//             }
//             ans.add(Arrays.asList(nums[i], nums[i + 1], nums[i + 2]));
//         }

//         return ans;
//     }
// }

// class Solution {
//     public int[][] divideArray(int[] nums, int k) {
//         Arrays.sort(nums);
//         List<List<Integer>> temp = new ArrayList<>();

//         for (int i = 0; i < nums.length; i += 3) {
//             if (nums[i + 2] - nums[i] > k) {
//                 return new int[0][];
//             }
//             temp.add(Arrays.asList(nums[i], nums[i + 1], nums[i + 2]));
//         }

//         // Convert List<List<Integer>> to int[][]
//         int[][] result = new int[temp.size()][3];
//         for (int i = 0; i < temp.size(); i++) {
//             for (int j = 0; j < 3; j++) {
//                 result[i][j] = temp.get(i).get(j);
//             }
//         }

//         return result;
//     }
// }


// class Solution {
//     public List<List<Integer>> divideArray(int[] nums, int k) {
//         PriorityQueue<Integer> pq = new PriorityQueue<>();
//         for (int num : nums) {
//             pq.offer(num);
//         }

//         List<List<Integer>> res = new ArrayList<>();

//         while (pq.size() >= 3) {
//             int low = pq.poll();
//             int mid = pq.poll();
//             int high = pq.poll();

//             if (high - low <= k) {
//                 res.add(Arrays.asList(low, mid, high));
//             } else {
//                 return new ArrayList<>();
//             }
//         }

//         return res;
//     }
// }

class Solution {
    public int[][] divideArray(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int[][] ans = new int[n/3][3];
        for(int i = 0; i < n; i += 3) {
            int[] arr = new int[3];
            for(int j = i; j < i + 3; ++j) arr[j-i] = nums[j];
            if(arr[2]-arr[0] > k) return new int[0][0];
            ans[i/3] = arr;
        }
        return ans;
    }
}
