import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class three_adition {


    public static void main(String[] args) {
        int[] nums=new int[]{-1,0,1,2,-1,-4};
        List<List<Integer>> res=three(nums);
        for(List<Integer> list:res){
            System.out.println("["+list.get(0)+" "+list.get(1)+" "+list.get(2)+"]");
        }

    }
    public static List<List<Integer>> three(int[] nums){
        List<List<Integer>> res=new ArrayList<>();
        int left=0;
        int right=nums.length-1;
        int sum=0;
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            left=i+1;
            right=nums.length-1;
            if(nums[i]>0){
                return res;
            }
            if(i>0 && nums[i-1]==nums[i]){
                continue;
            }
            while(left<right){
                sum=nums[i]+nums[left]+nums[right];
                if(sum>0){
                    right--;
                }else if(sum<0){
                    left++;
                }else{
                    List<Integer> path=new ArrayList<>();
                    path.add(nums[i]);
                    path.add(nums[left]);
                    path.add(nums[right]);
                    res.add(path);
                    while(left<right && nums[left]==nums[left+1]){
                        left++;
                    }
                    while(left<right && nums[right]==nums[right-1]){
                        right--;
                    }
                    left++;
                    right--;
                }

            }
        }
        return res;
    }
}
