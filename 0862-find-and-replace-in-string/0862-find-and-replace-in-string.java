class Solution {
    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
      
      int n = s.length();
      int match[] = new int[n];
      Arrays.fill(match,-1);
     StringBuilder sb = new StringBuilder();
      for(int i=0;i<indices.length;i++){
         String src = sources[i];
         int idx = indices[i];

         if(s.startsWith(src,idx)){
            match[idx]=i;
         }
      }

      int i=0;
      while(i<n){
        if(match[i]!=-1){
            sb.append(targets[match[i]]);
            i+=sources[match[i]].length();
        }
        else{
            sb.append(s.charAt(i));
            i++;
        }
      }
      return sb.toString();
    }
}