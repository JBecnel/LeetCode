//https://leetcode.com/problems/number-of-islands/description/
public class NumberOfIslands {

    public int numIsland(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++)
            for (int j = 0; j < grid[0].length; j++)
                if (grid[i][j] == '1') {
                    count++;
                    removeIsland(i, j, grid);
                }

        return count;
    }

    private void removeIsland(int i, int j, char[][] grid) {
        // if we go off the grid, this should not add to the island
        if (i >= 0 && j >= 0 && i < grid.length && j < grid[0].length) {

            if (grid[i][j] == '1') {
                grid[i][j] = '0'; // mark as visited
                // remove the 1 to a search of surrounding grid points
                removeIsland(i + 1, j, grid);
                removeIsland(i - 1, j, grid);
                removeIsland(i, j + 1, grid);
                removeIsland(i, j - 1, grid);
            }
        }

    }
}
