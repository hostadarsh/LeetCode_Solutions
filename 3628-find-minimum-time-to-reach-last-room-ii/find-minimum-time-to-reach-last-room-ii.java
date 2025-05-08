// class Solution {
//     public int minTimeToReach(int[][] moveTime) {
//         int n = moveTime.length;
//         int m = moveTime[0].length;

//         int[][] minTime = new int[n][m];
//         for (int i = 0; i < n; i++) {
//             for (int j = 0; j < m; j++) {
//                 minTime[i][j] = Integer.MAX_VALUE;
//             }
//         }

//         int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
//         PriorityQueue<int[]> minh = new PriorityQueue<>((a, b) -> a[2] - b[2]);
//         minh.offer(new int[]{0, 0, 0, 0});
//         minTime[0][0] = 0;

//         while (!minh.isEmpty()) {
//             int[] top = minh.poll();
//             int x = top[0], y = top[1], currTime = top[2], alt = top[3];

//             if (currTime > minTime[x][y]) continue;
//             if (x == n - 1 && y == m - 1) return currTime;

//             for (int[] d : dir) {
//                 int nx = x + d[0];
//                 int ny = y + d[1];

//                 if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;

//                 int waitTime = Math.max(moveTime[nx][ny] - currTime, 0);
//                 int moveCost = (alt % 2 == 0 ? 1 : 2);
//                 int nextTime = currTime + waitTime + moveCost;

//                 if (nextTime < minTime[nx][ny]) {
//                     minTime[nx][ny] = nextTime;
//                     minh.offer(new int[]{nx, ny, nextTime, alt + 1});
//                 }
//             }
//         }

//         return -1;
//     }
// }
/* Copyright (c) 2024 by https://leetcode.com/brinuke/. All rights reserved. */
class Solution {
	private static class Room implements Comparable<Room> {
		final int openTime;
		final boolean longStay;
		Room[] adjacent;
		Room next;

		Room() {
			openTime = Integer.MAX_VALUE;
			longStay = true;
		}

		Room(int openTime, boolean longStay) {
			this.openTime = openTime;
			this.longStay = longStay;
			next = this; // indicates that this Room hasn't been approached yet
		}

		@Override
		public int compareTo(Room other) {
			return openTime - other.openTime;
		}
	}

	private static final Room DUMMY_ROOM = new Room();

	private static Room initRooms(int[][] moveTime) {
		int n = moveTime.length;
		int m = moveTime[0].length;
		Room[][] rooms = new Room[n][m];
		for (int i = 0; i < n; i++) {
			int[] mtRow = moveTime[i];
			Room[] rRow = rooms[i];
			for (int j = 0; j < m; j++)
				rRow[j] = new Room(mtRow[j], ((i + j) & 1) == 0);
		}
		Room[] dummyRow = new Room[m];
		Arrays.fill(dummyRow, DUMMY_ROOM);
		Room[] prevRow = dummyRow;
		Room[] curRow = rooms[0];
		n--;
		m--;
		for (int i = 0; i <= n; i++) {
			Room[] nextRow = i < n ? rooms[i + 1] : dummyRow;
			Room prev = DUMMY_ROOM;
			Room cur = curRow[0];
			for (int j = 0; j <= m; j++) {
				Room next = j < m ? curRow[j + 1] : DUMMY_ROOM;
				cur.adjacent = new Room[] { prev, prevRow[j], next, nextRow[j] };
				prev = cur;
				cur = next;
			}
			prevRow = curRow;
			curRow = nextRow;
		}
		Room start = rooms[0][0];
		start.next = rooms[n][m]; // finish
		return start;
	}

	public static int minTimeToReach(int[][] moveTime) {
		Room start = initRooms(moveTime);
		Room finish = start.next;
		Queue<Room> waitingToEnter = new PriorityQueue<>();
		waitingToEnter.add(DUMMY_ROOM); // guard Room to prevent NPE
		start.next = null;
		Room exitingShortHead = start;
		Room exitingLongHead = null;
		int currentTime = 0;
		while (true) {
			Room exitingLongHeadNew = null;
			while (exitingShortHead != null) {
				for (Room adj : exitingShortHead.adjacent)
					if (adj.next == adj) {
						if (adj == finish)
							return Math.max(currentTime, finish.openTime) + (finish.longStay ? 2 : 1);
						if (adj.openTime <= currentTime) {
							if (adj.longStay) {
								adj.next = exitingLongHeadNew;
								exitingLongHeadNew = adj;
							} else {
								adj.next = exitingLongHead;
								exitingLongHead = adj;
							}
						} else {
							adj.next = null;
							waitingToEnter.offer(adj);
						}
					}
				exitingShortHead = exitingShortHead.next;
			}
			exitingShortHead = exitingLongHead;
			exitingLongHead = exitingLongHeadNew;
			int queueTime;
			while ((queueTime = waitingToEnter.peek().openTime) <= currentTime) {
				Room entering = waitingToEnter.poll();
				if (entering.longStay) {
					entering.next = exitingLongHead;
					exitingLongHead = entering;
				} else {
					entering.next = exitingShortHead;
					exitingShortHead = entering;
				}
			}
			if (++currentTime < queueTime && exitingShortHead == null && exitingLongHead == null)
				currentTime = queueTime;
		}
	}
}