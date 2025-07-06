class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";

        int min = Integer.MAX_VALUE;
        for (String s : strs) {
            min = Math.min(min, s.length());
        }

        StringBuilder sb = new StringBuilder();

        for(int i=0;i<min;i++){
            char current = strs[0].charAt(i);

            for(int j=1;j<strs.length;j++){
                if(strs[j].charAt(i)!=current){
                    return sb.toString();
                }
            }
            sb.append(current);
        }
        return sb.toString();
    }
}
