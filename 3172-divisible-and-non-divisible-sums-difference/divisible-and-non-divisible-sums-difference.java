class Solution {
    public int differenceOfSums(int n, int m) {

        int sum = 0;
        for(int i = m; i <= n ; i = i + m){
            sum = sum + i;
        }

        return (n*(n+1)/2) - 2 * sum;
    }
}