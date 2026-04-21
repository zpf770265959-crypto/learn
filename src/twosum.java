import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class twosum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int n = sc.nextInt();
            if (!sc.hasNextInt()) {
                System.out.println("missing target");
                return;
            }
            int target = sc.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                if (!sc.hasNextInt()) {
                    System.out.println("missing array element");
                    return;
                }
                nums[i] = sc.nextInt();
            }
            int[] ans = twoSum(nums, target);
            System.out.println(ans[0] + " " + ans[1]);
        }
    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int need = target - nums[i];
            if (map.containsKey(need)) {
                return new int[]{map.get(need), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{-1, -1};
    }
}
