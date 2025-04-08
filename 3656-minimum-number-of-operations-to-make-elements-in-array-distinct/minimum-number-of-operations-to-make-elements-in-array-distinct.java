class Solution {
    public int minimumOperations(int[] nums) {
        HashMap<Integer, Integer> mpp = new HashMap<>();

        for(int i = nums.length - 1; i >= 0 ; i--){
            if(mpp.containsKey(nums[i])){
                return (i/3) + 1;
            }
            mpp.put(nums[i],1);
        }
        return 0;        
    }
}