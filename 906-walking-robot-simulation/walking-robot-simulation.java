// import java.util.*;

// class Solution {
//     public int robotSim(int[] commands, int[][] obstacles) {
//         // Store obstacles
//         Set<String> blocked = new HashSet<>();
//         for (int[] o : obstacles) {
//             blocked.add(o[0] + "," + o[1]);
//         }

//         // Directions: North, East, South, West
//         int[][] directions = {
//             {0, 1}, {1, 0}, {0, -1}, {-1, 0}
//         };

//         int x = 0, y = 0;
//         int dir = 0; // initially facing North
//         int maxDist = 0;

//         for (int cmd : commands) {
//             if (cmd == -1) {
//                 dir = (dir + 1) % 4; // turn right
//             } 
//             else if (cmd == -2) {
//                 dir = (dir + 3) % 4; // turn left
//             } 
//             else {
//                 while (cmd-- > 0) {
//                     int nx = x + directions[dir][0];
//                     int ny = y + directions[dir][1];

//                     // check obstacle
//                     if (blocked.contains(nx + "," + ny)) break;

//                     x = nx;
//                     y = ny;

//                     maxDist = Math.max(maxDist, x * x + y * y);
//                 }
//             }
//         }

//         return maxDist;
//     }
// }

class Solution {
    private static final class Coord {
        private int x, y;
        private Coord(int x, int y) {
            this.x = x;
            this.y = y;
        }

        private int getDist() {
            return x * x + y * y;
        }

        @Override
        public boolean equals(Object other) {
            if(!(other instanceof Coord coord)) return false;
            return x == coord.x && y == coord.y;
        }
        @Override
        public int hashCode() {
            return x * 31 + y;
        }
    }
    private static final int[] dx = {0, 1, 0, -1}, dy = {1, 0, -1, 0};
    public int robotSim(int[] commands, int[][] obstacles) {
        int dir = 0, max = 0;
        Set<Coord> invalid = new HashSet<>(obstacles.length, 1.0f);
        for(int[] x : obstacles) invalid.add(new Coord(x[0], x[1]));
        Coord current = new Coord(0, 0);
        for(int command : commands) {
            if(command == -1) dir = dir == 3 ? 0 : dir + 1;
            else if(command == -2) dir = dir == 0 ? 3 : dir - 1;
            else {
                for(int i = 0; i < command; i++) {
                    current.x += dx[dir];
                    current.y += dy[dir];
                    if(invalid.contains(current)) {
                        current.x -= dx[dir];
                        current.y -= dy[dir];
                        break;
                    }
                }
                max = Math.max(max, current.getDist());
            }
        }
        return max;
    }
}