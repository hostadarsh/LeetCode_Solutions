// class Solution {
//     public boolean uniformArray(int[] nums1) {

//         Arrays.sort(nums1);

//         if(nums1[0] % 2 != 0){
//             return true;
//         }
//         else{

//             for(int i = 1 ; i < nums1.length; i++){
//                 if(nums1[i] % 2 != 0 ){
//                     return false;
//                 }
//             }

//         }

//         return true;
        
//     }
// }


class Solution {
    public boolean uniformArray(int[] nums1) {
        int min=Integer.MAX_VALUE;
        for(int num:nums1){
            min=Math.min(min,num);
        }

        //minimum is odd -> always possible hoga
        if(min%2==1){
            return true;
        }
        //minimum is even -> all elements must be even tabhi hoga
        for(int num:nums1){
            if(num%2==1){
                return false;
            }
        }
        return true;
    }
}