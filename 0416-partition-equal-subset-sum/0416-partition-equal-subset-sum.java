class Solution {
    public boolean canPartition(int[] nums) {
        int total = 0;
        for (int n : nums) total += n;
        if (total % 2 != 0) return false;
        int target = total / 2;
        
        // 2D array - andar rakho
        Boolean[][] memo = new Boolean[nums.length][target + 1];
        return solve(nums, 0, 0, target, memo);
    }

    public boolean solve(int[] nums, int index, int currSum, int target, Boolean[][] memo) {
        if (currSum == target) return true;
        if (currSum > target || index == nums.length) return false;

        // Already calculated?
        if (memo[index][currSum] != null) return memo[index][currSum];

        boolean lo = solve(nums, index + 1, currSum + nums[index], target, memo);
        boolean chodo = solve(nums, index + 1, currSum, target, memo);

        memo[index][currSum] = lo || chodo;
        return memo[index][currSum];
    }
}