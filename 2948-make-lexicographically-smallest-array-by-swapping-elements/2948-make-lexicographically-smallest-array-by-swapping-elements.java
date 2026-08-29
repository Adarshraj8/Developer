class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        
        int n = nums.length;
        int pairs[][] = new int[n][2];
        for(int i=0;i<n;i++){

             pairs[i][0]=nums[i];
             pairs[i][1]= i;
        }

        Arrays.sort(pairs,(a,b)->a[0]-b[0]);

        int result[] = new int[n];
        List<int[]> group = new ArrayList<>();
        group.add(pairs[0]);

        for(int i=1;i<n;i++){
              if (pairs[i][0] - pairs[i-1][0] <= limit) {
                group.add(pairs[i]);
            } else {
                processGroup(group, result);
                group = new ArrayList<>();
                group.add(pairs[i]);
            }
        }
         processGroup(group, result);

        return result;

    }

     private void processGroup(List<int[]> group, int[] result) {
        List<Integer> indices = new ArrayList<>();
        for (int[] p : group) indices.add(p[1]);
        Collections.sort(indices);

        for (int k = 0; k < indices.size(); k++) {
            result[indices.get(k)] = group.get(k)[0];
        }
    }
}