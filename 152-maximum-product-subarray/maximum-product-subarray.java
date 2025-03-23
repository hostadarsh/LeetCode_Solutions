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


// class Solution {
//     public int maxProduct(int[] arr) {
//         int result = Integer.MIN_VALUE;
//         for(int i = 0; i < arr.length; i++){
//             int prod = arr[i];
//             for(int j = i + 1; j < arr.length; j++){
//                 result = Math.max(prod,result);
//                 prod = prod * arr[j];
                
//             }
//             result = Math.max(prod,result);
//         }
//         return result;

//     }
// }



class Solution {
    public int maxProduct(int[] arr) {

       int pref = 1, suff = 1;
       int ans = Integer.MIN_VALUE;
       for(int i = 0; i< arr.length; i++){
            if(pref == 0) pref = 1;
            if(suff == 0) suff = 1;

            pref *= arr[i];
            suff *= arr[arr.length -i-1];

            ans = Math.max(ans, Math.max(pref,suff));
            
       }
       return ans;

    }
}