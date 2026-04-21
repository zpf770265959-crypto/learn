import java.util.Scanner;

public class topk {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.hasNextInt() ? sc.nextInt() : 2;
        int[] nums = {3, 2, 4, 1, 5, 6, 3};
        int res = findk(nums, k);
        System.out.println(res);
    }

    public static int findk(int[] nums, int k) {
        if (k <= 0 || k > nums.length) {
            throw new IllegalArgumentException("k must be between 1 and " + nums.length);
        }

        int target = nums.length - k;
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int index = part(nums, left, right);
            if (index == target) {
                return nums[target];
            }
            if (index < target) {
                left = index + 1;
            } else {
                right = index - 1;
            }
        }
        return 0;
    }

    public static int part(int[] nums, int left, int right) {
        int pivot = nums[left];
        while (left < right) {
            while (left < right && nums[right] >= pivot) {
                right--;
            }
            nums[left] = nums[right];
            while (left < right && nums[left] <= pivot) {
                left++;
            }
            nums[right] = nums[left];
        }
        nums[left] = pivot;
        return left;
    }
}
