// class Solution {
//     public List<Integer> majorityElement(int[] nums) {
        
//         List<Integer> ls = new ArrayList<>();
//         int s = nums.length;

//         for(int i = 0; i < s; i++ ){
//             if(ls.size() == 0 || ls.get(0) != nums[i]){
//                 int count = 0;
//                 for(int j = 0; j < s; j++){
//                     if(nums[i] == nums[j]){
//                         count++;
//                     }
//                 }
//                 if(count > (s/3)){
//                     ls.add(nums[i]);
//                 }
//             }

//             if(ls.size() == 2){
//                 break;
//             }
//         }
//         return ls;

//     }
// }



class Solution {
    public List<Integer> majorityElement(int[] nums) {

        List<Integer> ans = new ArrayList<>();

        HashMap<Integer, Integer> mpp = new HashMap<>();
        int min = (int)(nums.length/3) + 1;

        for(int i = 0; i< nums.length; i++){
            
            int value = mpp.getOrDefault(nums[i],0);
            mpp.put(nums[i], value+1);

            if(mpp.get(nums[i]) == min){
                ans.add(nums[i]);
            }
            if(ans.size() == 2){
                break;
            }        }

        return ans;

    }
}