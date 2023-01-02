package LeetCode;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Solution method = new Solution();
        int[] arr = {3, 2, 2, 3};
        int val = 3;
//        method.removeElement(arr, val);
        System.out.println(mystery5(128, 343));
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        System.out.println(method.removeDuplicates(nums));

    }

    public static int mystery5(int x, int y) {
        if (x < 0) {
            return -1 * mystery5(-x, y);
        } else if (y < 0) {
            return -1 * mystery5(x, -y);
        } else if (x == 0 && y == 0) {
            return 0;
        } else {
            int val = 10 * (x % 10) + y % 10;
            return 100 * mystery5(x / 10, y / 10) + val;
        }
    }
}
