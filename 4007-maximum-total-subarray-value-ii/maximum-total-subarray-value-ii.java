// // class Solution {
// //     public long maxTotalValue(int[] nums, int k) {
// //         long min = nums[0];
// //         long max = nums[0];

// //         for (int num : nums) {
// //             min = Math.min(min, num);
// //             max = Math.max(max, num);
// //         }

// //         return (long) k * (max - min);
// //     }
// // }

// // class Solution {
// //     public long maxTotalValue(int[] nums, int k) {
// //         long ans = 0;
// //         List<Long> diff = new ArrayList<>();

// //         for(int i = 0; i < nums.length; i++) {

// //         long max = nums[i];
// //         long min = nums[i];

// //         for(int j = i; j < nums.length; j++) {

// //         max = Math.max(max, nums[j]);
// //         min = Math.min(min, nums[j]);

// //         diff.add(max - min);
// //     }
// // }

// //         diff.sort(Collections.reverseOrder());

// //         for(int i = 0; i < k; i++){
// //             ans += diff.get(i);
// //         }

// //         return ans;
// //     }
// // }



// class Solution {
//     public long maxTotalValue(int[] nums, int k) {
        
//         PriorityQueue<Integer> pq = new PriorityQueue<>();

//         for(int i = 0; i < nums.length; i++){
//             int max = nums[i];
//             int min = nums[i];

//             for(int j = i; j < nums.length; j++){

//                 max = Math.max(max, nums[j]);
//                 min = Math.min(min, nums[j]);

//                 int value = max - min;

//                 pq.add(value);

//                 if(pq.size() > k){
//                     pq.poll();
//                 }
//             }
//         }

//         long ans = 0;

//         for(int i = 0; i < k; i++){
//             ans += pq.poll();
//         }

//         return ans;
//     }
// }

class Solution {
    int size;
    int[] segMax, segMin;

    private int[] query(int l, int r) {
        int mx = 0, mn = (int)1e9;
        for (l += size, r += size; l <= r; l /= 2, r /= 2) {
            if (l % 2 == 1) {
                mx = Math.max(mx, segMax[l]); 
                mn = Math.min(mn, segMin[l]); 
                l++;
            }
            if (r % 2 == 0) { 
                mx = Math.max(mx, segMax[r]); 
                mn = Math.min(mn, segMin[r]); 
                r--; 
            }
        }
        return new int[]{mx, mn};
    }

    public long maxTotalValue(int[] nums, int k) {
        int n = nums.length;
        size = 1; while (size < n) size *= 2;
        segMax = new int[2 * size];
        segMin = new int[2 * size];
        Arrays.fill(segMin, (int)1e9);
        for (int i = 0; i < n; i++) { 
            segMax[size + i] = segMin[size + i] = nums[i]; 
        }
        for (int i = size - 1; i > 0; i--) {
            segMax[i] = Math.max(segMax[2 * i], segMax[2 * i + 1]);
            segMin[i] = Math.min(segMin[2 * i], segMin[2 * i + 1]);
        }
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        for (int l = 0; l < n; l++) {
            int[] res = query(l, n - 1);
            heap.add(new int[]{res[0] - res[1], l, n - 1});
        }
        long ans = 0;
        for (int i = 0; i < k; i++) {
            int[] top = heap.poll();
            ans += top[0];
            if (top[2] > top[1]) {
                int[] res = query(top[1], top[2] - 1);
                heap.add(new int[]{res[0] - res[1], top[1], top[2] - 1});
            }
        }
        return ans;
    }
}