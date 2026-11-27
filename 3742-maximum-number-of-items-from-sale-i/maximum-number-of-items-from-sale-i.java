class Solution {
    public int maximumSaleItems(int[][] items, int budget) {
         int n = items.length;

        int[] bonus = new int[n];

        for (int i = 0; i < n; i++) {
            int factorI = items[i][0];

            for (int j = 0; j < n; j++) {
                if (i != j && items[j][0] % factorI == 0) {
                    bonus[i]++;
                }
            }
        }

        int minPrice = Integer.MAX_VALUE;
        for (int[] item : items) {
            minPrice = Math.min(minPrice, item[1]);
        }

        int[] dp = new int[budget + 1];

        for (int i = 0; i < n; i++) {
            int price = items[i][1];
            int gain = bonus[i] + 1; 

            for (int b = budget; b >= price; b--) {
                dp[b] = Math.max(
                    dp[b],
                    dp[b - price] + gain
                );
            }
        }

        int ans = 0;

        for (int spent = 0; spent <= budget; spent++) {
            int remaining = budget - spent;

            
            int extraCopies = remaining / minPrice;

            ans = Math.max(
                ans,
                dp[spent] + extraCopies
            );
        }

        return ans;
    }
}