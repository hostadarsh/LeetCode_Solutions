class Solution {
    public boolean uniformArray(int[] nums1) {
        
        // ArrayList<Integer> oddIndex = new ArrayList<>();

        // for(int i = 0; i < nums1.length; i++){
        //     if(nums1[i] % 2 != 0){
        //         oddIndex.add(nums1[i]);
        //     }
        // }

        // if(oddIndex.size() == nums1.length || oddIndex.size() == 0){
        //     return true;
        // }

        Arrays.sort(nums1);

        if(nums1[0] % 2 != 0){
            return true;
        }
        else{

            for(int i = 1 ; i < nums1.length; i++){
                if(nums1[i] % 2 != 0 ){
                    return false;
                }
            }

        }

        return true;
        

    }
}