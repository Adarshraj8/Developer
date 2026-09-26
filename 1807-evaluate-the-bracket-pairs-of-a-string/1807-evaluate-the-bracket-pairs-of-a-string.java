class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        
        Map<String,String> lookupMap = new HashMap<>();
        for(List<String> pair:knowledge){
            if(pair.size()>=2)
            lookupMap.put(pair.get(0),pair.get(1));
        }

        StringBuilder result = new StringBuilder();
        int lastIndex=0;

        while(true){
            int openBracket = s.indexOf("(",lastIndex);
            if(openBracket==-1) break;

            int closeBracket = s.indexOf(")",openBracket);
            if(closeBracket==-1) break;

            result.append(s,lastIndex,openBracket);
           
           String key = s.substring(openBracket+1,closeBracket);
           String replacementValue=lookupMap.getOrDefault(key,"?");

            result.append(replacementValue);

            lastIndex=closeBracket+1;

        }
        result.append(s.substring(lastIndex));
        return result.toString();
    }
}