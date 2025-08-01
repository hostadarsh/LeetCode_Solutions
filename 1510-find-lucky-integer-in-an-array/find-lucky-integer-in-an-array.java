class Solution {
    public int findLucky(int[] arr) {
        int[] freq = new int[501];
        int max = -1;
        for(int num : arr){
            freq[num]++;
        }

        for(int i = 500; i > 0 ; i--){
            if( freq[i] == i){
                return i;
          }
        }

        return -1;
    }
}