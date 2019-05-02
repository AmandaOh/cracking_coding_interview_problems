import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ZeroMatrix {

    @Test
    void one_zero_3x3_matrix() {
        int[][] matrix = new int[][] {
            { 1, 1, 0 },
            { 1, 1, 1 },
            { 1, 1, 1 },
        };

        int[][] expectedMatrix = new int[][] {
                { 0, 0, 0 },
                { 1, 1, 0 },
                { 1, 1, 0 },
        };

        assertTrue(Arrays.deepEquals(solve(matrix), expectedMatrix));
    }

    @Test
    void one_zero_5x5_matrix() {
        int[][] matrix = new int[][] {
                { 1, 1, 0, 1, 1 },
                { 1, 1, 1, 1, 1 },
                { 1, 1, 1, 1, 1 },
                { 1, 1, 1, 1, 1 },
                { 1, 1, 1, 1, 1 },
        };

        int[][] expectedMatrix = new int[][] {
                { 0, 0, 0, 0, 0 },
                { 1, 1, 0, 1, 1 },
                { 1, 1, 0, 1, 1 },
                { 1, 1, 0, 1, 1 },
                { 1, 1, 0, 1, 1 },
        };

        assertTrue(Arrays.deepEquals(solve(matrix), expectedMatrix));
    }

    @Test
    void two_zeros_3x3_matrix() {
        int[][] matrix = new int[][] {
                { 1, 1, 0 },
                { 0, 1, 1 },
                { 1, 1, 1 },
        };

        int[][] expectedMatrix = new int[][] {
                { 0, 0, 0 },
                { 0, 0, 0 },
                { 0, 1, 0 },
        };

        assertTrue(Arrays.deepEquals(solve(matrix), expectedMatrix));
    }

    @Test
    void two_zeros_5x5_matrix() {
        int[][] matrix = new int[][] {
                { 1, 1, 0, 1, 1 },
                { 1, 1, 1, 1, 1 },
                { 1, 1, 0, 1, 1 },
                { 1, 1, 1, 1, 1 },
                { 1, 1, 1, 1, 1 },
        };

        int[][] expectedMatrix = new int[][] {
                { 0, 0, 0, 0, 0 },
                { 1, 1, 0, 1, 1 },
                { 0, 0, 0, 0, 0 },
                { 1, 1, 0, 1, 1 },
                { 1, 1, 0, 1, 1 },
        };

        assertTrue(Arrays.deepEquals(solve(matrix), expectedMatrix));
    }

    static int[][] solve(int[][] matrix) {
        int columnLength = matrix.length;
        int rowLength = matrix[0].length;
        int[][] newMatrix = new int[columnLength][rowLength];

        for (int i = 0; i < columnLength; i++) {
            for (int j = 0; j < rowLength; j++) {
                newMatrix[i][j] = matrix[i][j];
            }
        }

        for (int i = 0; i < columnLength; i++) {
            for (int j = 0; j < rowLength; j++) {
                if(matrix[i][j] == 0){
                    for (int k = 0; k < rowLength; k++) {
                        newMatrix[i][k] = 0;
                    }
                    for (int k = 0; k < columnLength; k++) {
                        newMatrix[k][j] = 0;
                    }
                }
            }
        }

        return newMatrix;
    }
}
