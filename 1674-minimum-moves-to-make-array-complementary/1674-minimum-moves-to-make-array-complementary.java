class Solution {
    public int minMoves(int[] nums, int limit) {
        int n = nums.length;
        int[] diff = new int[2 * limit + 2];
        
        for (int i = 0; i < n / 2; i++) {
            int a = nums[i];
            int b = nums[n - 1 - i];
            
            int lo = Math.min(a, b);
            int hi = Math.max(a, b);
            
            // 1 move zone: lo+1 se hi+limit tak
            diff[lo + 1]         -= 1;
            diff[hi + limit + 1] += 1;
            
            // 0 move point: exactly a+b pe
            diff[a + b]     -= 1;
            diff[a + b + 1] += 1;
        }
        
        // Worst case = n (2 moves × n/2 pairs)
        int ans = n;
        int current = n;
        
        // Har T ke liye actual moves nikalo
        for (int T = 2; T <= 2 * limit; T++) {
            current += diff[T];
            ans = Math.min(ans, current);
        }
        
        return ans;
    }
}