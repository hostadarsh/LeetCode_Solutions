class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        
        Stack<Integer> st = new Stack<>();

        int[] ans = new int[nums1.length];

        int n = nums2.length;

        int[] res = new int[n];
        
        for(int i = n - 1; i >= 0; i-- ){
            while(!st.isEmpty() && nums2[st.peek()] <= nums2[i]){
                st.pop();
            }

            if(st.isEmpty()){
                res[i] = -1;
            }
            else{
                res[i] = nums2[st.peek()];
            }

            st.push(i);
        }

        for(int i = 0; i < nums1.length; i++){
            for(int j = 0; j < nums2.length; j++){
                if(nums1[i] == nums2[j]){
                    ans[i] = res[j];
                }
            }
        }

        return ans;

    }
}