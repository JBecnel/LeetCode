import static org.junit.Assert.assertEquals;

import org.junit.Test;


public class NumIslandTest {
    @Test
    public void testNumIslands() {
        char[][] grid = {
            {'1','1','1','1','0'},
            {'1','1','0','1','0'},
            {'1','1','0','0','0'},
            {'0','0','0','0','0'}
        };
        int actual = new NumberOfIslands().numIsland(grid);
        int expected = 1;
        assertEquals(expected, actual);

    }
}
