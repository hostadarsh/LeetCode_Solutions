// class Solution {
//     public int countDays(int days, int[][] meetings) {
//         Arrays.sort(meetings, Comparator.comparingInt(a -> a[0]));

//         List<int[]> mergedMeetings = new ArrayList<>();
//         for (int[] meeting : meetings) {
//             if (mergedMeetings.isEmpty() || meeting[0] > mergedMeetings.get(mergedMeetings.size() - 1)[1]) {
//                 mergedMeetings.add(meeting);
//             } else {
//                 mergedMeetings.get(mergedMeetings.size() - 1)[1] = 
//                     Math.max(mergedMeetings.get(mergedMeetings.size() - 1)[1], meeting[1]);
//             }
//         }

//         int meetingDaysCount = 0;
//         for (int[] m : mergedMeetings) {
//             meetingDaysCount += (m[1] - m[0] + 1);
//         }

//         return days - meetingDaysCount;
//     }
// }

class Solution {
    public int countDays(int days, int[][] meetings) {
        int freeDays = days;
        TreeMap<Integer, Integer> meetingDays = new TreeMap<>();
        for (int[] meeting : meetings) {
            int start = meeting[0];
            int end = meeting[1];
            // System.out.printf("Meeting: (%d, %d)\n", start, end);
            int overlapDays = 0;

            Map.Entry<Integer, Integer> previousMeetingDays = meetingDays.floorEntry(start);
            if (previousMeetingDays != null && previousMeetingDays.getValue() >= start - 1) {
                if (previousMeetingDays.getValue() >= end) continue; // Complete overlap
                overlapDays = previousMeetingDays.getValue() - previousMeetingDays.getKey() + 1;
                // System.out.printf("Overlapping previous: (%d, %d)\n", previousMeetingDays.getKey(), previousMeetingDays.getValue());
                start = previousMeetingDays.getKey();
            }

            Map.Entry<Integer, Integer> nextMeetingDays = meetingDays.ceilingEntry(start + 1);
            while (nextMeetingDays != null && nextMeetingDays.getKey() <= end + 1) {
                meetingDays.remove(nextMeetingDays.getKey());
                overlapDays += nextMeetingDays.getValue() - nextMeetingDays.getKey() + 1;
                // System.out.printf("Overlapping next: (%d, %d)\n", nextMeetingDays.getKey(), nextMeetingDays.getValue());
                if (nextMeetingDays.getValue() >= end) {
                    end = nextMeetingDays.getValue();
                    break;
                }
                nextMeetingDays = meetingDays.ceilingEntry(start + 1);
            }

            meetingDays.put(start, end);
            freeDays -= (end - start + 1) - overlapDays;
            // System.out.printf("Result: (%d, %d)\n", start, end);
            // System.out.printf("FreeDays - ((%d - %d + 1) - %d) = %d\n\n", end, start, overlapDays, freeDays);
            if (freeDays == 0) break;
        }
        return freeDays;

    }
}