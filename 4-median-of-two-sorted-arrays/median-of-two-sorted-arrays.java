class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int m = nums1.length;
        int n = nums2.length;

        int[] mergeArray = new int[m+n];
        int idx = 0;
        int i = 0, j = 0;
        while(i != m && j != n ){
            if(nums1[i] < nums2[j]){
                mergeArray[idx++] = nums1[i++];
            }
            else{
                mergeArray[idx++] = nums2[j++];
            }
        }

        while(i != m){
            mergeArray[idx++] = nums1[i++];
        }
        while( j != n){
            mergeArray[idx++] = nums2[j++];
        }
    double median = 0;
        if((m+n) % 2 == 0){
            median = (double)((mergeArray[(m+n)/2] + mergeArray[((m+n)/2) - 1])) / (double)2;
            
        }
        else{
            median = mergeArray[(m+n-1)/2];
        }
        return median;
    }
}