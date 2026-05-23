class Solution {
    public List<Integer> majorityElement(int[] nums) {

         int n = nums.length;
        int cnt1 = 0, cnt2 = 0;
        int el1 = Integer.MIN_VALUE, el2 = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            if (cnt1 == 0 && el2 != nums[i]) {
                cnt1 = 1;
                el1 = nums[i]; 
            } else if (cnt2 == 0 && el1 != nums[i]) {
                cnt2 = 1;
                el2 = nums[i]; 
            } else if (nums[i] == el1) {
                cnt1++;
            } else if (nums[i] == el2) {
                cnt2++; 
            } else {
                cnt1--; 
                cnt2--;
            }
        }

        cnt1 = 0; cnt2 = 0; 
        for (int i = 0; i < n; i++) {
            if (nums[i] == el1) cnt1++; 
            if (nums[i] == el2) cnt2++;
        }

        int mini = n / 3 + 1;
        List<Integer> result = new ArrayList<>(); 
        if (cnt1 >= mini) result.add(el1);
        if (cnt2 >= mini && el1 != el2) result.add(el2);

        return result;


    }

}







//         class Solution {
//     public List<Integer> majorityElement(int[] nums) {

//        List<Integer> ans = new ArrayList<>();

//         HashMap<Integer,Integer> map = new HashMap<>();

//         for(int i = 0; i < nums.length; i++){
//             map.put(nums[i], map.getOrDefault(nums[i],0) + 1);
//         }

//         for(int key : map.keySet()){

//             if(map.get(key) > nums.length / 3){
//                 ans.add(key);
//             }
//         }

//         return ans;

//     }

// }