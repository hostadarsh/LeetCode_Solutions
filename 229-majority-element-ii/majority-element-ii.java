class Solution {
    public List<Integer> majorityElement(int[] nums) {
        
        List<Integer> ls = new ArrayList<>();
        int s = nums.length;

        for(int i = 0; i < s; i++ ){
            if(ls.size() == 0 || ls.get(0) != nums[i]){
                int count = 0;
                for(int j = 0; j < s; j++){
                    if(nums[i] == nums[j]){
                        count++;
                    }
                }
                if(count > (s/3)){
                    ls.add(nums[i]);
                }
            }

            if(ls.size() == 2){
                break;
            }
        }
        return ls;

    }
}