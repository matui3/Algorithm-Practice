package LeetCode;

import java.util.Arrays;

public class PlusOne {
    public static void main(String[] args) {
        int[] arr = {9, 9, 9};
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(plusOne(arr)));
    }

    public static int[] plusOne(int[] digits) {
        int length = digits.length;
        boolean increment = false;
        if (digits[0] == 9 && digits.length == 1) {
            int[] digit = new int[2];
            digit[0] = 1;
            digit[1] = 2;
            return digit;
        } else if (digits.length == 1) {
            digits[0] += 1;
            return digits;
        }
        digits[digits.length-1] = digits[digits.length - 1] + 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] == 10 && i != 0) {
                digits[i] = 0;
                increment = true;
            }
            if (increment && i != 0) {
                digits[i-1] = digits[i-1] + 1;
                increment = false;
            }
        }
        if (digits[0] == 10) {
            length += 1;
        }
        int[] arr = new int[length];
        for (int i = 0; i < digits.length; i++) {
            if (arr.length > digits.length) {
                arr[i+1] = digits[i];
            } else {
                arr[i] = digits[i];
            }
        }
        if (arr[1] == 10) {
            arr[0] = 1;
            arr[1] = 0;
        }
        return arr;
    }
    // proper solution
    public static int[] plusOneSoln(int[] digits) {
        int len = digits.length;
        for (int i = len-1; i >= 0; i--) {
            if (digits[i] != 9) {
                digits[i] += 1;
                return digits;
            } else {
                digits[i] = 0;
            }
        }
        int[] arr = new int[len+1];
        arr[0] = 1;
        return arr;
    }
}
