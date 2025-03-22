// class Solution {
//     public int maxProduct(int[] arr) {
//      int result = Integer.MIN_VALUE;
// 	    for(int i=0;i<arr.length-1;i++) 
// 	        for(int j=i+1;j<arr.length;j++) {
// 	            int prod = 1;
// 	            for(int k=i;k<=j;k++) 
// 	                prod *= arr[k];
// 	            result = Math.max(result,prod);
// 	        }
// 	   return result; 

//     }
// }


class Solution {
    public int maxProduct(int[] arr) {
        int result = Integer.MIN_VALUE;
        for(int i = 0; i < arr.length; i++){
            int prod = arr[i];
            for(int j = i + 1; j < arr.length; j++){
                result = Math.max(prod,result);
                prod = prod * arr[j];
                
            }
            result = Math.max(prod,result);
        }
        return result;

    }
}