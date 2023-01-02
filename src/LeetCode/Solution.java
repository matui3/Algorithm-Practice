package LeetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {

    public Solution() {

    }

    public int searchInsert(int[] nums, int target) {
        int first = 0;
        int last = nums.length - 1;
        boolean flag1 = false;

        while (first <= last) {
            flag1 = false;
            int mid = (first + last) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                first = mid + 1;
                flag1 = true;
            } else {
                last = mid - 1;
            }
        }
        if (flag1) {
            return first;
        } else {
            return last + 1;
        }
    }

    public int romanToInt(String s) {
        Map<Character, Integer> romanMap = new HashMap<>();
        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);

        int n = s.length();
        int num = romanMap.get(s.charAt(n-1));

        for (int i = n - 2; i >= 0; i--) {
            if (romanMap.get(s.charAt(i)) >= romanMap.get(s.charAt(i+1))) {
                num += romanMap.get(s.charAt(i));
            } else {
                num -= romanMap.get(s.charAt(i));
            }
        }
        return num;
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode();
        ListNode current = head;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                current.next = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next;
        }
        if (list1 != null) {
            current.next = list1;
        } else {
            current.next = list2;
        }
        return head.next;
    }

    public int[] plusOneSoln(int[] digits) {
        int len = digits.length;
        for (int i = len - 1; i >= 0; i--) {
            if (digits[i] != 9) {
                digits[i] += 1;
                return digits;
            } else {
                digits[i] = 0;
            }
        }
        int[] arr = new int[len + 1];
        arr[0] = 1;
        return arr;
    }

    public String addBinary(String a, String b) {
        int carry = 0;
        int aLength = a.length()-1;
        int bLength = b.length()-1;
        StringBuilder result = new StringBuilder();
        while (aLength >= 0 || bLength >= 0) {
            int sum = carry;
            if (aLength >= 0) {
                sum += a.charAt(aLength--) - '0';
            }
            if (bLength >= 0) {
                sum += b.charAt(bLength--) - '0';
            }
            result.insert(0, sum % 2);
            carry = sum/2;
        }
        if (carry > 0) {
            result.insert(0, 1);
        }
        return result.toString();
    }

    public int mySqrt(int x) {
        if (x <= 1) {
            return x;
        }
        int left = 1;
        int right = x/2;
        int mid = 0;
        int ans = 0;
        double temp;

        while (left <= right) {
            mid = (left + (right - left) /2);
            temp = (double)mid * (double)mid;

            if (temp == x) {
                return mid;
            }
            if (temp < x) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }

        }
        return ans;
    }

    public int climbStairs(int n) {
        int[] stairs = new int[n+2];
        stairs[0] = 1;
        stairs[1] = 1;

        for (int i = 2; i <= n; i++) {
            stairs[i] = stairs[i-2] + stairs[i-1];
        }

        return stairs[n];
    }


    public ListNode deleteDuplicates(ListNode head) {
        ListNode current = head;
        while (current.next != null) {
            if (current.val == current.next.val) {
                current.next = current.next.next;
            }
            if (current.next != null && current.val != current.next.val) {
                current = current.next;
            }
        }
        return head;
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // Step 0. Create new array of size (n+m) (will copy over all elements here into nums1)
        // Step 1. Create pointers for array nums1 and nums2
        // Step 2. Compare the values of nums1 and nums2
        // Step 3. If value of nums1 is less than nums2, place keep nums1 in place
        // Step 4. Move the pointer on nums1, check the next element
        // Step 5. If nums2 element is less than nums1, place this into new array
        // Step 6. Fill rest with 0's;
        if (m == 0) {
            nums1 = nums2;
        }
        if (m == 0) {
            nums1[0] = nums2[0];
        }
        int i = 0;
        int j = 0;
        int k = 0;
        int[] nums3 = new int[m+n];
        while (i < m && j < n) {
            if (nums1[i] < nums2[j]) {
                nums3[k++] = nums1[i++];
            } else {
                nums3[k++] = nums2[j++];
            }
        }
        while (i < m) {
            nums3[k++] = nums1[i++];
        }

        while (j < n) {
            nums3[k++] = nums2[j++];
        }
        for (i = 0; i < nums1.length; i++) {
            nums1[i] = nums3[i];
        }
    }

    public int removeElement(int[] nums, int val) {
        // figure out occurences of val, shift everything by that occurence
        // step 1. iterate over the array
        // Step 2. iterate over array and reassign points to new location based off occurences
        int occurence = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) {
                occurence += 1;
                nums[i] = 0;
            }
            nums[i] = nums[i+occurence];
        }
        System.out.println(Arrays.toString(nums));
        return nums.length - occurence;
    }

    public int removeDuplicates(int[] nums) {
        // initialize unique element index
        // iterate over array and if there is a duplicate change it to a diff value;
        // nums[i+1] now becomes nums[i];
        if (nums.length == 0 || nums.length == 1) {
            return nums.length;
        }
        int j = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] != nums[i + 1]) {
                nums[j++] = nums[i];
            }
        }
        nums[j++] = nums[nums.length - 1];

        return j;
    }
}
