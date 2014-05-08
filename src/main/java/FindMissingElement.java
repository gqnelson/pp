import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

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


        xorTest();

        findMissingElement3(first, second);
        findMissingElement2(first, second);
        findMissingElement1(first, second);
    }

    /**
     * Initialize a variable to 0, then XOR every element in the first and second arrays with that variable.
     * In the end, the value of the variable is the result, missing element in array2.
     *
     * 0 XOR 4 = 4
     * 4 XOR 4 = 0
     *
     * We XOR all the numbers in array1 and array2.
     * All numbers in array2 also appear in array1, but there is an extra number in array1.
     * So the effect of each XOR from array2 is being reset by the corresponding same number in array1
     * (remember that the order of XOR is not important).
     * But we can’t reset the XOR of the extra number in array1, because it doesn’t appear in array2.
     * So the result is as if we XOR 0 with that extra number, which is the number itself.
     * Since XOR of a number with 0 is the number. Therefore, in the end we get the missing number in array2.
     * The space complexity of this solution is constant O(1) since we only use one extra variable.
     * Time complexity is O(N) because we perform a single pass from the arrays.
     */
    private static void findMissingElement3(int[] first, int[] second) {
        int result = 0;
        for (int i = 0; i < first.length; i++) {
            result = result ^ first[i];
            result = (i<second.length) ? result ^ second[i] : result;
        }
        System.out.println(String.format("findMissingElement3 Missing element = %d", result));
    }

    private static void xorTest() {
        int result = 0;
        result = result ^ 4;
        System.out.println(String.format("%d XOR 4 = %d", 0, result));
        System.out.println(String.format("%d XOR 4 = %d", result, result^4));
    }

    static class MutableInt {
        int value = 1; // note that we start at 1 since we're counting
        public void increment () { ++value;      }
        public int decrement() { return --value; }
    }

    /**
     * We can use a hashtable and store the number of times each element appears in the second array.
     * Then for each element in the first array we decrement its counter.
     * Once hit an element with zero count that’s the missing element.
     */
    private static void findMissingElement2(int[] first, int[] second) {
        Map<Integer, MutableInt> secondMap = new HashMap<Integer, MutableInt>(second.length);

        for (int i = 0; i < second.length; i++) {
            MutableInt mutableInt = secondMap.get(Integer.valueOf(second[i]));
            if (mutableInt == null) {
                secondMap.put(Integer.valueOf(second[i]), new MutableInt());
            } else {
                mutableInt.increment();
            }
        }

        for (int i = 0; i < first.length; i++) {
            MutableInt mutableInt = secondMap.get(Integer.valueOf(first[i]));
            if (mutableInt == null || mutableInt.decrement() == -1) {
                System.out.println(String.format("findMissingElement2 Missing element = %d", first[i]));
            }
        }
    }

    /**
     * If we don’t want to deal with the special case of duplicate numbers,
     * we can sort both arrays and iterate over them simultaneously.
     * Once two iterators have different values we can stop.
     * The value of the first iterator is the missing element. This solution is also O(NlogN).
     */
    private static void findMissingElement1(int[] first, int[] second) {
        Arrays.sort(first);
        Arrays.sort(second);

        for (int i = 0; i < first.length; i++) {
            if(first[i] != second[i]) {
                System.out.println(String.format("findMissingElement1 Missing element = %d", first[i]));
                break;
            }
        }
    }
}
