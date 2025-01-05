import java.util.Arrays;

public class ThreeSumClosest {
    public static void main(String[] args) {
        ThreeSumClosest tsc = new ThreeSumClosest();
        System.out.println(tsc.threeSumClosest(new int[]{-1,2,1,4}, 1));
        System.out.println(tsc.threeSumClosest(new int[]{0, 0, 0}, 1));
    }

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int minDistance = Integer.MAX_VALUE;
        int solution = 0;
        for (int i = 0; i < nums.length-2; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == target)
                    return sum;
                else if (sum < target) 
                    left++;
                else 
                    right--;
                
                int dist = Math.abs(target-sum);
                if (dist < minDistance) {
                    solution = sum;
                    minDistance = dist;
                }

        
            }
        }
        return solution;
    }
}
