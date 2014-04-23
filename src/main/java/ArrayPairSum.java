import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by wnelson on 4/23/14.
 * http://www.ardendertat.com/2011/09/17/programming-interview-questions-1-array-pair-sum/
 *
 * Given an integer array, output all pairs that sum up to a specific value k.
 */
public class ArrayPairSum {
    public static void main(String[] args) {

        int[] sum4 = {2,1,4,3,1,2,5}; //Answer 1,3
        int[] sum11 = {1, 2, 13, 34, 9, 3, 23, 45, 8, 7, 8, 3, 2};

        n2(sum4, 4);
        n2(sum11, 11);

        nlogn(sum4, 4);
        nlogn(sum11, 11);

        n(sum4, 4);
        n(sum11, 11);

    }

    private static void n(int[] sum4, int whatToMatch) {
        System.out.println("Algorithm n");
        Set targetNumbers = new HashSet<Integer>();
        for (int i = 0; i < sum4.length; i++) {
            int target = whatToMatch - sum4[i];
            if (targetNumbers.contains(target)) {
                System.out.println(String.format("n The sum of element %d and %d = %d", sum4[i], target, whatToMatch));
            } else
            {
                targetNumbers.add(target);
            }
        }
    }

    private static void nlogn(int[] input, int whatToMatch) {
        System.out.println("Algorithm nlogn");
        Arrays.sort(input);
        int left = 0;
        int right = input.length-1;
        while (left < right){
            int sum = input[left] + input[right];
            if (sum == whatToMatch){
                System.out.println(String.format("nlogn The sum of element %d and %d = %d", input[left], input[right], whatToMatch));
            }
            if (sum > whatToMatch) {
                right--;
            } else {
                left++;
            }
        }
    }

    private static void n2(int[] input, int whatToMatch) {
        System.out.println("Algorithm n2");
        for (int i = 0; i < input.length; i++) {
            for (int j = i+1; j < input.length; j++) {
                if (input[i] + input[j] == whatToMatch) {
                    System.out.println(String.format("n2 The sum of element %d and %d = %d", input[i], input[j], whatToMatch));
                }
            }
        }
    }

}
