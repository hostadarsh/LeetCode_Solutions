class Solution {
    public int maxProfit(int[] arr) {

        int[] res = new int[arr.length];
        res[arr.length -1 ] = arr[arr.length - 1];
        //int max = 0;
        int maxd = 0;

        for(int i = arr.length - 2 ; i>=0; i--){
            res[i] = Math.max(arr[i],res[i+1]);
        }

    for(int i = 0; i< arr.length; i++){
        int diff = res[i] - arr[i];
        if(diff > maxd){
            maxd = diff;
        }
    }
    return maxd;
        
    }
}