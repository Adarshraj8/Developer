class Solution {
    public int myAtoi(String s) {
        int i=0;int result=0;
        int n=s.length();int sign=1;
        //Ignore any leading whitespace 
       while(i<n&& s.charAt(i)==' '){
           i++;
       }
        //handling sign
        if(i<n&&(s.charAt(i)=='-'||s.charAt(i)=='+')){
            sign = s.charAt(i)=='-'?-1:1;
            i++;
        }
          // 3. Read digits and stop at first non-digit
        while(i<n&&Character.isDigit(s.charAt(i))){
            int digit = s.charAt(i)-'0';
             // 4. Check for overflow/underflow
            if(result>(Integer.MAX_VALUE-digit)/10){
                return sign==1?Integer.MAX_VALUE:Integer.MIN_VALUE;
            }
            
            result =result*10+digit;
            i++;
        }
        return result*sign;
         
    }
}