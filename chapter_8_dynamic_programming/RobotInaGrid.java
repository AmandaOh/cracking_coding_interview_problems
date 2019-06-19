import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class RobotInaGrid {

    private class Coordinate {
        private int r;
        private int c;
        private boolean offLimits;

        private Coordinate(int r, int c, boolean isOffLimits) {
            this.r = r;
            this.c = c;
            this.offLimits = isOffLimits;
        }

        @Override
        public String toString() {
            return "Coordinate{" +
                    "r=" + r +
                    ", c=" + c +
                    ", offLimits=" + offLimits +
                    '}';
        }
    }

    private List<Coordinate> solve(Coordinate[][] grid) {
        List<Coordinate> coordinates = new ArrayList<>();
        if (getPath(grid, grid[0][0], coordinates)) {
            return coordinates;
        }

        return null;
    }

    private boolean getPath(Coordinate[][] grid, Coordinate current, List<Coordinate> coordinates) {
        if (current.offLimits) return false;

        boolean atTheEnd = current.r == grid.length - 1 && current.c == grid[0].length - 1;
        if (atTheEnd ||
            getPath(grid, grid[current.r + 1][current.c], coordinates) ||
            getPath(grid, grid[current.r][current.c + 1], coordinates)
        ) {
            coordinates.add(current);
            return true;
        }

        return false;
    }

    @Test
    void finds_path() {
        Coordinate[][] grid = new Coordinate[][] {
                { new Coordinate(0, 0, false), new Coordinate(1, 0, false) },
                { new Coordinate(0, 1, false), new Coordinate(1, 1, false) }
        };

        List<Coordinate> coordinates = solve(grid);
        for(Coordinate coordinate : coordinates) {
            System.out.println(coordinate.toString());
        }
    }
}
