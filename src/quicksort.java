public class quicksort {
    public static void main(String[] args) {
        int[] nums = {2, 10, 6, 4, 7, 1};
        quick(nums, 0, nums.length - 1);
        for (int num : nums) {
            System.out.println(num);
        }
    }

    public static void quick(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int pivotIndex = part(nums, left, right);
        quick(nums, left, pivotIndex - 1);
        quick(nums, pivotIndex + 1, right);
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
        //我测试一下
    }
}
