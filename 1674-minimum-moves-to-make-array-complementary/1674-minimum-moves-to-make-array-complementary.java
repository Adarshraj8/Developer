class Solution {
    public int minMoves(int[] nums, int limit) {
        int n = nums.length;
        
        // diff array size = 2*limit + 2 (T ranges from 2 to 2*limit)
        int[] diff = new int[2 * limit + 2];
        
        // Start: assume 2 moves needed for ALL pairs
        // We will REDUCE this using ranges
        
        for (int i = 0; i < n / 2; i++) {
            int a = nums[i];
            int b = nums[n - 1 - i];
            
            int lo = Math.min(a, b);
            int hi = Math.max(a, b);
            
            // Range where only 1 move needed (save 1 from 2)
            // T in [lo+1, hi+limit]
            diff[lo + 1]      -= 1;
            diff[hi + limit + 1] += 1;
            
            // Range where 0 moves needed (save 1 more)
            // T = a+b exactly
            diff[a + b]     -= 1;
            diff[a + b + 1] += 1;
        }
        
        // Now find minimum using prefix sum
        int moves = n; // worst case (2 moves × n/2 pairs)
        int current = n;
        
        for (int T = 2; T <= 2 * limit; T++) {
            current += diff[T];
            moves = Math.min(moves, current);
        }
        
        return moves;
    }
}