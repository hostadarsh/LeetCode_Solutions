// import java.util.*;

// class Solution {
//     public int matchPlayersAndTrainers(int[] players, int[] trainers) {
//         Arrays.sort(players);
//         Arrays.sort(trainers);
//         int i = 0, j = 0, ans = 0;
//         while (i < players.length && j < trainers.length) {
//             if (players[i] <= trainers[j]) {  // can pair
//                 ++ans;
//                 ++i;
//             }
//             ++j;   // trainer consumed
//         }
//         return ans;
//     }
// }

class Solution {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        int m = players.length;
        int n = trainers.length;

        Thread t1 = new Thread(() -> Arrays.sort(players));
        Thread t2 = new Thread(() -> Arrays.sort(trainers));
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (Exception e) {
        }

        int left = 0;
        int right = 0;
        int count = 0;

        while (left < m && right < n) {
            if (trainers[right] >= players[left]) {
                count++;
                left++;
            }
            right++;
        }
        return count;
    }
}