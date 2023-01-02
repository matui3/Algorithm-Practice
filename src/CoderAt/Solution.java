package CoderAt;

import java.util.Arrays;

public class Solution {

    public void sandwichNumber(String s) {
        boolean one = false;
        boolean two = false;
        boolean three = false;
        if (s.charAt(0) >= 'A' && s.charAt(0) <= 'Z') {
            one = true;
        }
        if (s.charAt(s.length() - 1) >= 'A' && s.charAt(s.length() - 1) <= 'Z') {
            three = true;
        }
        String sub = s.substring(1, s.length() - 1);
        if (sub.length() > 6) {
            two = false;
        } else {
            if (Integer.parseInt(sub) > 100000 && Integer.parseInt(sub) < 999999) {
                two = true;
            }
        }

        if (one && two && three) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }

    public int removeDuplicates(int[] nums) {
        if (nums.length == 1) {
            return 1;
        }
        int k = 0;
        for (int i = 1; i < nums.length; i++) {
            if(nums[i-1] != nums[i]) {
                nums[k] = nums[i];
                k++;
            }
        }
        return k;
    }
}
