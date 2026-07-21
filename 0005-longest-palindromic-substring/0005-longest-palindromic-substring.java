class Solution {
    public String longestPalindrome(String s) {
        
     int n = s.length();
     String result="";
     for(int i=0;i<n;i++){
  
        for(int j=i;j<n;j++){
         String str = s.substring(i,j+1);
         if(isPalindrome(str)&&str.length()>result.length()){
            result=str;
         }
        }
        
     }   
   return result;
    }
      private boolean isPalindrome(String s){
        int right = s.length()-1;
        int left=0;
        while(left<right){

            if(s.charAt(left)!=s.charAt(right))
            return false;
            left++;
            right--;
        }
        return true;
     }
}