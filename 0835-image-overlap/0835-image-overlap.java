class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {
        
        int n = img1.length;

        List<int[]> oneA = new ArrayList<>();
        List<int[]> oneB = new ArrayList<>();

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(img1[i][j]==1) oneA.add(new int[]{i,j});
                if(img2[i][j]==1) oneB.add(new int[]{i,j});
             }
        }
             Map<String,Integer> count = new HashMap<>();
             int max=0;
             for(int [] a :oneA){
                for(int [] b:oneB){
                    int dx = b[0]-a[0];
                    int dy = a[1]-b[1];
                    String key = dx + "," +dy;

                    // if(count.containsKey(key))
                    // count.put(key,count.get(key)+1);
                    // else
                    //  count.put(key,1);
                   count.merge(key,1,Integer::sum);
                     max = Math.max(max,count.get(key));
                }
             }
        return max;
    }
}