class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        HashSet<Character> set = new HashSet<>();

        int n = s.length();
        int left=0;
        int maxLen=0;
        for(int i=0;i<n;i++){
            while(set.contains(s.charAt(i))){
                set.remove(s.charAt(left));
                left++;
            }

            set.add(s.charAt(i));
            maxLen = Math.max(maxLen,i-left+1);
        } 
        return maxLen;
    }
}