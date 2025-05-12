// class Solution {
//     public int[] nextGreaterElement(int[] nums1, int[] nums2) {
//         int[] ans = new int[nums1.length];

//         for(int i = 0; i < nums1.length; i++){
//             int index = -1;

//             for(int j = 0; j < nums2.length; j++){
//                 if(nums1[i] == nums2[j]){
//                     index = j;
//                     break;
//                 }
//             }

//             int nextGreaterElement = -1;
//             for(int k = index + 1; k < nums2.length; k++){
//                 if( nums2[k] > nums1[i] ){
//                     nextGreaterElement = nums2[k];
//                     break;
//                 }
//             }
//             ans[i] = nextGreaterElement;
//         }

//         return ans;

//     }
// }

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {

        HashMap<Integer, Integer> mp = new HashMap<>();
        int[] ans = new int[nums1.length];
        
        Stack<Integer> st = new Stack<>(); 
        st.push(nums2[nums2.length-1]);

        for(int i = nums2.length-1; i >= 0; i--){

            while(!st.isEmpty() && st.peek() <= nums2[i]){
                st.pop();
            }
            if(st.isEmpty()){
                mp.put(nums2[i], -1);
            }
            else{
                mp.put(nums2[i], st.peek());
            }

            st.push(nums2[i]);
        }

        for(int i = 0; i < nums1.length; i++){
            ans[i] = mp.get(nums1[i]);
        }
        return ans;
        
    }
}