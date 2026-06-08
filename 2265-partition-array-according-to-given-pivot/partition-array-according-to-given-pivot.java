class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        List<Integer> lesser = new ArrayList<>();
        List<Integer> pivotCount = new ArrayList<>();
        List<Integer> greater = new ArrayList<>();

        for(int i = 0; i < nums.length; i++){
            if(nums[i] < pivot){
                lesser.add(nums[i]);
            }
            else if(nums[i] > pivot){
                greater.add(nums[i]);
            }
            else{
                pivotCount.add(pivot);
            }
        }

        int [] ans = new int [nums.length];

        int i = 0;

        for(int n : lesser){
            ans[i++] = n;
        }
        for(int n : pivotCount){
            ans[i++] = n;
        }
        for(int n : greater){
            ans[i++] = n;
        }

return ans;
    }
}