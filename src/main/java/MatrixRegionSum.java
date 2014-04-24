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

    static int[] sr1 = { 0, 1, 4};
    static int[] sr2 = { 2, 3, 2};
    static int[] sr3 = { 1, 2, 7};
    static int[][] smallMatrix = { sr1, sr2, sr3 };

    public static void main(String[] args) {
//        bruteForce(0, 0, 0, 0);
//        bruteForce(0, 0, 0, 1);
//        bruteForce(0, 0, 1, 1);
//        bruteForce(0, 0, 9, 9);
//        bruteForce(0, 0, 8, 9);

//        printMatrix(smallMatrix);
//        System.out.println("");
//        int[][] sat = computeSat(smallMatrix);
//        printMatrix(sat);

        printMatrix(matrix);
        System.out.println("");
        int[][] sat = computeSat(matrix);
        printMatrix(sat);
        System.out.println("");
        int matrixRegionSum = computeRegionSum(0,0,1,1,sat);
        System.out.println(String.format("The sum for (%d,%d) (%d,%d) = %d", 0, 0, 1, 1, matrixRegionSum));
        matrixRegionSum = computeRegionSum(1,1,2,2,sat);
        System.out.println(String.format("The sum for (%d,%d) (%d,%d) = %d", 1, 1, 2, 2, matrixRegionSum));
    }

    private static int computeRegionSum(int topX, int topY, int bottomX, int bottomY, int[][] sat) {
        if (topX==0 && topY==0) return sat[bottomX][bottomY];
        return sat[bottomX][bottomY] - sat[topX-1][bottomY] - sat[bottomX][topY-1] + sat[topX-1][topY-1];
    }

    private static int[][] computeSat(int[][] matrix) {
        int[][] sat = new int[matrix.length][matrix[0].length];

        for (int row = 0; row < matrix.length; row++) {
            int currentRowSum = 0;
            for (int column = 0; column < matrix[0].length; column++) {
                currentRowSum += matrix[row][column];
                sat[row][column] = previousRowSum(sat, row, column) + currentRowSum;
            }
        }
        return sat;
    }

    private static int previousRowSum(int[][] sat, int row, int column) {
        if (row==0) return 0;
        return sat[row-1][column];
    }

    private static void bruteForce(int topLeftX, int topLeftY, int bottomRightX, int bottomRightY) {
        //The complexity of this solution is O(MN) where M is the number of rows of the matrix, and N is the number of columns.
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

    private static void printMatrix(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            StringBuilder rowOut = new StringBuilder();
            for (int column = 0; column < matrix[0].length; column++) {
                rowOut.append(String.format("%d, ", matrix[row][column]));
            }
            System.out.println(rowOut.substring(0, rowOut.length()-2));
            System.out.printf("");
        }
    }
}
