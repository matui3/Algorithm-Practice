package LeetCode;

public class SearchInsertPosition {
    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6};
        int target = 7;
        System.out.println(searchInsert(nums, target));
    }

    public static int searchInsert(int[] nums, int target) {
        int first = 0;
        int last = nums.length - 1;
        boolean flag1 = false;

        while (first <= last) {
            flag1 = false;
            int mid = (first + last)/2;
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
            return last+1;
        }
    }
}
