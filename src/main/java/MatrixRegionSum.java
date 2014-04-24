/**
 * Created by wnelson on 4/24/14.
 *
 * http://www.ardendertat.com/2011/09/20/programming-interview-questions-2-matrix-region-sum/
 *
 * Given a matrix of integers and coordinates of a rectangular region within the matrix,
 * find the sum of numbers falling inside the rectangle. Our program will be called
 * multiple times with different rectangular regions from the same matrix.
 */
public class MatrixRegionSum {
    static int[] row1 = { 1, 2,  3,  4,  5,  6,  7,  8,  9,  10};
    static int[] row2 = { 2, 4,  6,  8,  10, 12, 14, 16, 18, 20};
    static int[] row3 = { 3, 6,  9,  12, 15, 18, 21, 24, 27, 30};
    static int[] row4 = { 4, 8,  12, 16, 20, 24, 28, 32, 36, 40};
    static int[] row5 = { 5, 10, 15, 20, 25, 30, 35, 40, 45, 50};
    static int[] row6 = { 6, 12, 18, 24, 30, 36, 42, 48, 54, 60};
    static int[] row7 = { 7, 14, 21, 28, 35, 42, 49, 56, 63, 70};
    static int[] row8 = { 8, 16, 24, 32, 40, 48, 56, 64, 72, 80};
    static int[] row9 = { 9, 18, 27, 36, 45, 54, 63, 72, 81, 90};
    static int[][] matrix = { row1, row2, row3, row4, row5, row6, row7, row8, row9};

    public static void main(String[] args) {
        bruteForce(0, 0, 1, 1);
        bruteForce(0, 0, 9, 9);
        bruteForce(0, 0, 8, 9);
    }

    private static void bruteForce(int topLeftX, int topLeftY, int bottomRightX, int bottomRightY) {
        System.out.println(String.format("\nBrute Force for matrix (%d, %d), (%d, %d)", topLeftX, topLeftY, bottomRightX, bottomRightY));
        if (topLeftX > matrix.length-1 || bottomRightX > matrix.length-1) {
            System.out.println(String.format("topLeftX %d or bottomRightX %d is larger than the number of rows %d", topLeftX, bottomRightX, matrix.length));
            return;
        }

        int sum = 0;
        for (int row = topLeftX; row < bottomRightX+1; row++) {
            for (int column = topLeftY; column < bottomRightY+1; column++) {
                System.out.println(String.format("Row %d Column %d = %d", row, column, matrix[row][column]));
                sum += matrix[row][column];
            }
        }
        System.out.printf(String.format("Sum of inside matrix = %d", sum));
    }
}
