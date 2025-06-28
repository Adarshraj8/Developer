class Solution {
    public boolean isPalindrome(String s) {
        
        if(s.length()==0)return true;
// Step 1: Remove all non-alphanumeric characters (keep only letters and digits)
// Step 2: Remove all spaces (if required) 
         // String cleaned =  s.replaceAll("[^a-zA-Z0-9]", "");
        StringBuilder cleaned = new StringBuilder();
        for(char ch : s.toCharArray()) {
            if(Character.isLetterOrDigit(ch)){
                cleaned.append(ch);
            }
        }
          String result = cleaned.toString().toLowerCase();

          int left =0;
          int right=result.length()-1;
          while(left<=right){
            if(result.charAt(left)!=result.charAt(right)){
                return false;
            }
            left++;
            right--;
          }
          return true;
    }
}