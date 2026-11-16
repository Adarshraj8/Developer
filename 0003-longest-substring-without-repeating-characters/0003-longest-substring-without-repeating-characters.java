class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max_sub_length=0;
        
        for(int i=0;i<s.length();i++){
            
             HashSet<Character> seen  = new HashSet<>();
            for(int j=i;j<s.length();j++){

                
                if(seen.contains(s.charAt(j)))
                {
                     break;
                }
                 seen.add(s.charAt(j));

            }
            max_sub_length = Math.max(max_sub_length,seen.size());
        }
        return max_sub_length;
    }
}