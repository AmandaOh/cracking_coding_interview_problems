import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TripleStep {

    private int solve(int n) {
        int[] counts = new int[n + 1];
        Arrays.fill(counts, -1);
        counts[0] = 1;

        return getCount(counts, n);
    }

    private int getCount(int[] counts, int n) {
        if (n < 0) return 0;
        if (counts[n] < 0) {
            return getCount(counts,n - 1) + getCount(counts, n - 2) + getCount(counts, n - 3);
        }

        return counts[n];
    }

    @Test
    void three_steps_returns_4() {
        assertEquals(4, solve(3));
    }

    @Test
    void five_steps_returns_13() {
        assertEquals(13, solve(5));
    }

    @Test
    void ten_steps_returns_274() {
        assertEquals(274, solve(10));
    }
}
