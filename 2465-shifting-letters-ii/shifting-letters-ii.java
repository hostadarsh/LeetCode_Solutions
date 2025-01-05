// class Solution {
//     public String shiftingLetters(String s, int[][] shifts) {
//         int n = s.length();
//         int[] shift = new int[n + 1];

//         for (int[] shiftOp : shifts) {
//             int start = shiftOp[0], end = shiftOp[1], direction = shiftOp[2];
//             shift[start] += (direction == 1 ? 1 : -1);
//             if (end + 1 < n) shift[end + 1] -= (direction == 1 ? 1 : -1);
//         }

//         int currentShift = 0;
//         for (int i = 0; i < n; ++i) {
//             currentShift += shift[i];
//             shift[i] = currentShift;
//         }

//         StringBuilder result = new StringBuilder(s);
//         for (int i = 0; i < n; ++i) {
//             int netShift = (shift[i] % 26 + 26) % 26;
//             result.setCharAt(i, (char) ('a' + (s.charAt(i) - 'a' + netShift) % 26));
//         }

//         return result.toString();
//     }
// }


class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        char arr[]=s.toCharArray();
        int[] map=new int[arr.length+1];
        for(int[] num:shifts){
            if(num[2]==0){
                map[num[0]]-=1;
                map[num[1]+1]+=1;
            }else{
                map[num[0]]+=1;
                map[num[1]+1]-=1;
            }
        }
        int sum=0;
        for(int i=0;i<arr.length;i++){
            sum+=map[i];
            int n=((arr[i]-'a')+sum)%26;
            if(n<0) n+=26;
            arr[i]=(char)(n+'a');
        }
        return new String(arr);
    }
}