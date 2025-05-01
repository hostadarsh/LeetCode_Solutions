// class Solution {
//     public int maxTaskAssign(int[] tasks, int[] workers, int pills, int strength) {
//         int left = 0, right = Math.min(tasks.length, workers.length);
//         Arrays.sort(tasks);
//         Arrays.sort(workers);

//         while (left < right) {
//             int mid = (left + right + 1) / 2;
//             int usedPills = 0;
//             TreeMap<Integer, Integer> avail = new TreeMap<>();
//             for (int i = workers.length - mid; i < workers.length; ++i)
//                 avail.put(workers[i], avail.getOrDefault(workers[i], 0) + 1);

//             boolean canAssign = true;
//             for (int i = mid - 1; i >= 0; --i) {
//                 int t = tasks[i];
//                 int w = avail.lastKey();
//                 if (w >= t) {
//                     decrement(avail, w);
//                 } else {
//                     Integer key = avail.ceilingKey(t - strength);
//                     if (key == null || ++usedPills > pills) {
//                         canAssign = false;
//                         break;
//                     }
//                     decrement(avail, key);
//                 }
//             }

//             if (canAssign)
//                 left = mid;
//             else
//                 right = mid - 1;
//         }

//         return left;
//     }

//     private void decrement(TreeMap<Integer, Integer> m, int k) {
//         int c = m.get(k);
//         if (c == 1) m.remove(k);
//         else m.put(k, c - 1);
//     }
// }
class Solution {
    public int maxTaskAssign(int[] tasks, int[] workers, int pills, int strength) {

        int m = tasks.length, n = workers.length;
        Arrays.sort(tasks);
        Arrays.sort(workers);

        int l = 0, r = Math.min(m, n);
        while(l <= r){
            int mid = l + r >> 1;
            if(check(tasks, workers, pills, strength, mid, n - mid))
                l = mid+1;
            else
                r = mid-1;
        }

        return r;
    }
    
    public boolean check(int[] tasks, int[] workers, int pills, int strength, int mid, int start){
        
        int[] que = new int[mid];
        int write = 0, read = 0; 

        for(int i = 0, j = 0; i < mid; i++){
            int curStrength  = workers[start + i];
            if(read == write){

                if(curStrength >= tasks[j]){
                    j++;
                    continue;
                }

                if(pills == 0)
                    return false;
                
                curStrength  += strength;
                pills--;

                while(j < mid && curStrength >= tasks[j])
                    que[write++] = tasks[j++];
                
                if(read == write)
                    return false;
                write--;
                
            }else{

                if(curStrength >= que[read]){
                    read++;
                    continue;
                }

                if(pills == 0)
                    return false;
                
                curStrength  += strength;
                pills--;

                while(j < mid && curStrength >= tasks[j])
                    que[write++] = tasks[j++];
                
                write--;
            }
        }

        return read == write;        
    }
}