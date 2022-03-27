import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=1 lang=java
 *
 * [1] 两数之和
 */

// @lc code=start
class Solution {
    public int[] twoSum(int[] nums, int target) {
        return mapSolution(nums, target);
    }

    // 字典, 复杂度 o(n)
    private int[] mapSolution(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if (map.containsKey(diff)) {
                return new int[] { map.get(diff), i };
            }
            map.put(nums[i], i);
        }
        return null;
    }

    // 字典, 复杂度 o(n)
    private int[] mapSolution1(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        // 使用字典查找, o(n)
        for (int i = 0; i < nums.length; i++) {
            int value = target - nums[i];
            if (map.get(value) != null && map.get(value) != i) {
                return new int[] { i, map.get(value) };
            }
        }
        return null;
    }

    // 暴力破解 o(n^2)
    private int[] loopFor(int[] nums, int target) {

        for (int i = 0; i < nums.length; i++) {
            for (int j = 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target && i != j) {
                    return new int[] { i, j };
                }
            }
        }
        return null;
    }
}
// @lc code=end
