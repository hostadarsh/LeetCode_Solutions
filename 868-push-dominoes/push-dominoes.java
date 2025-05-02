// class Solution {
//     public String pushDominoes(String s) {
//         s = "L" + s + "R";
//         StringBuilder res = new StringBuilder();
//         int prev = 0;
//         for (int curr = 1; curr < s.length(); ++curr) {
//             if (s.charAt(curr) == '.') continue;
//             int span = curr - prev - 1;
//             if (prev > 0)
//                 res.append(s.charAt(prev));
//             if (s.charAt(prev) == s.charAt(curr)) {
//                 for (int i = 0; i < span; ++i)
//                     res.append(s.charAt(prev));
//             } else if (s.charAt(prev) == 'L' && s.charAt(curr) == 'R') {
//                 for (int i = 0; i < span; ++i)
//                     res.append('.');
//             } else {
//                 for (int i = 0; i < span / 2; ++i)
//                     res.append('R');
//                 if (span % 2 == 1)
//                     res.append('.');
//                 for (int i = 0; i < span / 2; ++i)
//                     res.append('L');
//             }
//             prev = curr;
//         }
//         return res.toString();
//     }
// }

class Solution {
    public String pushDominoes(String dominoes) {
        int n = dominoes.length();
        char ch[] = dominoes.toCharArray();
        int i = 0;
        while( i < n) {
            if(ch[i] != '.') {
                i++;
                continue;
            }
            int j = i; 
            while( j < n && ch[j] == '.')
                j++;
            if(i-1 >= 0 && j < n) {
                if(ch[i-1] == ch[j]) {
                    int k = i;
                    while(k < j)
                        ch[k++] = ch[i-1];
                } else {
                    if(ch[i-1] == 'R') {
                        int u = i, v = j-1;
                        while(u < v) {
                            ch[u++] = 'R';
                            ch[v--] = 'L';
                        }
                    }
                }
            } else if(i-1 >= 0) {
                if(ch[i-1] == 'R') {
                    int k = i;
                    while(k < j)
                        ch[k++] = 'R';
                }
            } else if(j < n) {
                if(ch[j] == 'L') {
                    int k = i;
                    while(k < j)
                        ch[k++] = 'L';
                }
            }
            i = j;
        }
        return String.valueOf(ch);
    }
}