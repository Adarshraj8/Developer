class Solution {
    public String mapWordWeights(String[] words, int[] weights) {

       int n = words.length;
       StringBuilder sb = new StringBuilder();
       for(int i=0;i<n;i++){
        int sum=0;
          for(char c : words[i].toCharArray()){
               
             int digit =   c-'a';
             sum+=weights[digit];
          }
          int num = sum %26;
           char cc = (char)('z'-num);
           
            sb.append(cc);
       } 
         
      return sb.toString();   
         
    }
}