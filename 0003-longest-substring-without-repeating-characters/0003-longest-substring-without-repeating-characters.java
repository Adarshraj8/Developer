class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max_sub_length=0;
        
        for(int i=0;i<s.length();i++){
            
             HashSet<Character> seen  = new HashSet<>();
            for(int j=i;j<s.length();j++){

                char c = s.charAt(j);
                if(seen.contains(c))
                {
                    break;
                }
                
                   seen.add(c);  
                    max_sub_length = Math.max(max_sub_length,j-i+1);
            }
           
        }
        return max_sub_length;
    }
}