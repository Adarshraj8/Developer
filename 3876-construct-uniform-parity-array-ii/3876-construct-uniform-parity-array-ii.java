class Solution {
    public boolean uniformArray(int[] nums1) {
        int min = Integer.MAX_VALUE;
        for (int x : nums1) min = Math.min(min, x);

        if (min % 2 == 1) return true;   // min odd -> always fixable

        for (int x : nums1) {
            if (x % 2 == 1) return false; // smallest odd can never be fixed
        }
        return true; // all even already
    }
}