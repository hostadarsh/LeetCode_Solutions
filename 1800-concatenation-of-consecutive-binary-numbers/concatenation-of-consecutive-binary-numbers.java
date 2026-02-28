// class Solution {
//   public int concatenatedBinary(int n) {
//     final int MOD = 1_000_000_007;
//     long ans = 0;

//     for (int i = 1; i <= n; ++i)
//       ans = ((ans << numberOfBits(i)) % MOD + i) % MOD;

//     return (int) ans;
//   }

//   private int numberOfBits(int n) {
//     return (int) (Math.log(n) / Math.log(2)) + 1;
//   }
// }

class Solution {
  public int concatenatedBinary(int n) {
    long res=0;
    long mod=1000000007;
        int bits=0;
        for(int i=1;i<=n;i++)
        {
           // bits=1;
            if((i&(i-1))==0)
            bits++;
            res= ((res<<bits)+i)%mod;
        }
        return (int)res;
  }
}


