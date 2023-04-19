package easy;

import java.math.BigInteger;
import java.util.Arrays;

public class PlusOne {  //9,8,7,6,5,4,3,2,1,0

    int[] stringToIntArray(int[] arr, String digitString, int index) {
        if (index >= arr.length) return arr;
        else {
            arr[index] = digitString.charAt(index++) - '0';
            return stringToIntArray(arr, digitString, index);
        }
    }
    StringBuilder intArrayToString(int[] arr, StringBuilder sb, int index) {
        if (index >= arr.length) return sb;
        else return intArrayToString(arr, sb.append(arr[index++]), index);
    }
    public int[] plusOne(int[] digits) {
        StringBuilder sb = intArrayToString(digits, new StringBuilder(), 0);
        BigInteger digit = new BigInteger(sb.toString());
        digit = digit.add(BigInteger.ONE);
        return stringToIntArray(new int[digit.toString().length()], digit.toString(), 0);
    }

}


/*


// Print the resulting int array
        // System.out.println(Arrays.toString(intArray));

    long makeZeros(int count, long base) {
        if (1 >= count) return base;
        else return makeZeros(--count, 10 * base);

    }
    long convertArrayToInt(int[] digits, long sum, int index) {
        if (index >= digits.length) return sum;
        else return convertArrayToInt(digits,
                sum + digits[index] * makeZeros(digits.length - index, 1), ++index);
    }
    public int[] plusOne(int[] digits) {
        long digit = convertArrayToInt(digits, 0, 0);
        digits = Long.toString(digit + 1).chars().map(c -> c - '0').toArray();
        return digits;
    }

 */