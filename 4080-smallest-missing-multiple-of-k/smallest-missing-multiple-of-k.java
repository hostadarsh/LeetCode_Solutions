class Solution {
    public int missingMultiple(int[] nums, int k) {
        
        Map<Integer, Integer> mp = new HashMap<>();

        for(int i = 0; i < nums.length; i++){
            mp.put(i, nums[i]);
        }

        for(int j = 1; j <= 101; j++){
            int min = k * j;

            if(!mp.containsValue(min)){
                return min;
            }
        }

        return k;
    }
}