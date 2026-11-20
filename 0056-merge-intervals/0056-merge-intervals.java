class Solution {
    public int[][] merge(int[][] intervals) {
        //sort by starting number of each interval
        Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));

        //use list so we can add new interval
        List<int[]> result = new ArrayList<>();

        //seed the list with first interval
        result.add(intervals[0]);

        for(int i=1;i<intervals.length;i++){
            int lastadded[] = result.get(result.size()-1);
            int current[] = intervals[i];

            if(lastadded[1]>=current[0]){
             lastadded[1]=Math.max(lastadded[1],current[1]);
            }
            else{
                result.add(current);
            }
        }
        return result.toArray(new int[result.size()][]);
    }
}