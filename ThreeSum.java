import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
     public List<List<Integer>> threeSum(int[] nums) {
      List<List<Integer>> solutions = new ArrayList<>();
        Arrays.sort(nums);
        int i = 0;
        while (i < nums.length - 2) {
            // move in from left and right towards i

            if (i == 0 || (nums[i] != nums[i - 1])) {

                int left = i + 1;
                int right = nums.length - 1;
                int sum = 0;
                while (left < right) {
                    sum = nums[left] + nums[right] + nums[i];
                    if (sum == 0) {

                        solutions.add(Arrays.asList(nums[i], nums[left], nums[right]));

                        // skip duplicated elements
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }

                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }

                        left++;
                        right--;
                    } else if (sum < 0) // get bigger
                        left++;
                    else // sum > 0, get smaller
                        right--;
                }
            }
            i++;
        }
        return solutions;
    }
}
