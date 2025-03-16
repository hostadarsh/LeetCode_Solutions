// class Solution {
//     public boolean timeIsSuff(int[] ranks, int cars, long minGiven) {
//         long carsDone = 0;
//         for (int r : ranks) {
//             long c2 = minGiven / r;
//             long c = (long) Math.sqrt(c2);
//             carsDone += c;
//         }
//         return carsDone >= cars;
//     }

//     public long repairCars(int[] ranks, int cars) {
//         long l = 1, r = (long) 1e14;
//         while (l < r) {
//             long mid = (l + r) / 2;
//             if (timeIsSuff(ranks, cars, mid)) {
//                 r = mid;
//             } else {
//                 l = mid + 1;
//             }
//         }
//         return l;
//     }
// }

class Solution {
    public long repairCars(int[] ranks, int cars) {
        int[] freq = new int[101];
        for (int i : ranks) {
            freq[i]++;
        }
        int minF = 100;
        for (int i = 1; i <= 100; i++) {
            if (0 < freq[i]) {
                minF = i;
                break;
            }
        }
        long l = 0, r = minF * (long) cars * cars;
        while (1 < r - l) {
            long mid = (l + r) / 2;
            if (check(freq, cars, mid)) {
                r = mid;
            } else {
                l = mid;
            }
        }
        return r;
    }

    private boolean check(int[] freq, long cars, long mid) {
        for (int i = 1; 0 < cars && i <= 100; i++) {
            if (freq[i] == 0) continue;
            long t = (long) Math.sqrt((double) mid / i);
            cars -= t * freq[i];
        }
        return cars <= 0;
    }

}