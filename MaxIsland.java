public class MaxIsland {
    public int maxAreaOfIsland(int[][] grid) {
        int area = 0;
        for (int i = 0; i < grid.length; i++)
            for (int j = 0; j < grid[0].length; j++) 
                if (grid[i][j] == 1)
                    area = Math.max(area, getAreaOfIslandAt(i,j, grid));
        
        return area;
    }

    private int getAreaOfIslandAt(int i, int j, int[][] grid) {
        // if we go off the grid, this should not add to the island
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length)
            return 0;
        else {
            if (grid[i][j] == 0)
                return 0;
            else { // grid is a 1
                grid[i][j] = 0; // mark as visited
                // add the 1 to a search of surrounding grid points
                return 1 + getAreaOfIslandAt(i+1, j, grid)
                         + getAreaOfIslandAt(i-1, j, grid)
                         + getAreaOfIslandAt(i, j+1, grid)
                         + getAreaOfIslandAt(i, j-1, grid);
            }
        }
    }
}