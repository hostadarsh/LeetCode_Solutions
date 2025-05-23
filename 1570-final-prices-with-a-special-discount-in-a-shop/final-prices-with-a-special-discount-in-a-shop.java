// class Solution {
//     public int[] finalPrices(int[] prices) {
//         int n=prices.length;
//         Stack<Integer> st=new Stack();

//         for(int i=n-1; i>=0; i--){
//             // Remove elements from the stack that are greater than the current price
//             while(!st.isEmpty() && st.peek()>prices[i]){
//                 st.pop();
//             }
            
//             // Get the discount from the stack or 0 if no valid discount
//             int discount=st.isEmpty()?0:st.peek();
            
//             // Push the original value before updating
//             st.push(prices[i]);

//             // Update the current price with the discount
//             prices[i]-=discount;           
//         }

//         return prices;
//     }
// }

class Solution {
    private int getDiscountedPrice(int index, int[] prices) {
        for (int i = index + 1; i < prices.length; i++) {
            if (prices[index] >= prices[i]) {
                return prices[index] - prices[i];
            }
        }
        return prices[index];
    }
    public int[] finalPrices(int[] prices) {
        int[] result = new int[prices.length];
        for (int i = 0; i < prices.length; i++) {
            result[i] = getDiscountedPrice(i, prices);
        }
        return result;
    }
}