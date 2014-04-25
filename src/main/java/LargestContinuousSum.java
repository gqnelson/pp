/**
 * Created by wnelson on 4/25/14.
 *
 * http://www.ardendertat.com/2011/09/24/programming-interview-questions-3-largest-continuous-sum/
 * Given an array of integers (positive and negative) find the largest continuous sum.
 */
public class LargestContinuousSum {
    public static void main(String[] args) {
        int[] prob1 = { 1, 2, 3}; //Answer = 4
        int[] prob2 = { 1, -1, 3}; //Answer = 3
        int[] prob3 = { 1, -2, 3}; //Answer = 3
        int[] prob4 = { -3, -2, -1}; //Answer = -1

        findLargestSum(prob1);
        findLargestSum(prob2);
        findLargestSum(prob3);
        findLargestSum(prob4);
    }

    private static void findLargestSum(int[] problem) {
        if(problem.length==0) System.out.println("Empty Array");

        int maxSum = problem[0];
        int currentMaxSum = maxSum;
        for (int i = 1; i < problem.length; i++) {
            currentMaxSum = Math.max(currentMaxSum + problem[i], problem[i]);
            maxSum = Math.max(maxSum, currentMaxSum);
        }

        System.out.println(String.format("Largest continuous sum is %d", maxSum));
    }

}
