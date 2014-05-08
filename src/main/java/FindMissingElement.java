import java.util.Arrays;

/**
 * There is an array of non-negative integers.
 * A second array is formed by shuffling the elements of the first array and deleting a random element.
 * Given these two arrays, find which element is missing in the second array.
 *
 * http://www.ardendertat.com/2012/01/09/programming-interview-questions/
 */
public class FindMissingElement {
    public static void main(String[] args) {
        int[] first = {4, 1, 0, 2, 9, 6, 8, 7, 5, 3};
        int[] second = {6, 4, 7, 2, 1, 0, 8, 3, 9};

        findMissingElement(first, second);

    }

    private static void findMissingElement(int[] first, int[] second) {
        Arrays.sort(first);
        Arrays.sort(second);

        for (int i = 0; i < first.length; i++) {
            if(first[i] != second[i]) {
                System.out.println(String.format("Missing element = %d", first[i]));
                break;
            }
        }
    }
}
