import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Leetcode994 {
    static class Orange {
        int x;
        int y;

        public Orange(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Orange orange = (Orange) o;
            return x == orange.x && y == orange.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    public static void main(String[] args) {
        Leetcode994 leetcode994 = new Leetcode994();
        System.out.println(leetcode994.orangesRotting(new int[][]{{2, 1,1},{0,1,1},{1,0,1}}));
        System.out.println(Objects.hash(1,2)==Objects.hash(2,1));
    }

    public int orangesRotting(int[][] grid) {
        Set<Orange> fresh = new HashSet<Orange>();
        Set<Orange> rotten = new HashSet<Orange>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    fresh.add(new Orange(i, j));
                }
                if (grid[i][j] == 2) {
                    rotten.add(new Orange(i, j));
                }
            }
        }
        int timer = 0;
        int dir[][] = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        while (!fresh.isEmpty()) {
            Set<Orange> set = new HashSet<Orange>();
            int freshCount= fresh.size();
            for (Orange o : rotten) {
                for (int i = 0; i < 4; i++) {
                    Orange orange = new Orange(o.x + dir[i][0], o.y + dir[i][1]);
                    if (fresh.contains(orange)) {
                        set.add(orange);
                        fresh.remove(orange);
                    }
                }
            }
            rotten.addAll(set);
            if(freshCount==fresh.size()){
                return -1;
            }
            timer++;
        }
        return timer;
    }
}
