public class Solution {
    public String[] createGrid(int m, int n) {
        // Step 1: Initialize grid with '#'
        char[][] grid = new char[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = '#';
            }
        }
        
        // Step 2: Open the first row
        for (int j = 0; j < n; j++) {
            grid[0][j] = '.';
        }
        
        // Step 3: Open the last column
        for (int i = 0; i < m; i++) {
            grid[i][n - 1] = '.';
        }
        
        // Convert the 2D char array to an array of Strings
        String[] result = new String[m];
        for (int i = 0; i < m; i++) {
            result[i] = new String(grid[i]);
        }
        
        return result;
    }
}
