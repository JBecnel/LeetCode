import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class SurroundedTest {
    @Test
    public void surroundedTest() {
       char[][] input =  {{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}};
       char[][] expected =  {{'X','X','X','X'},{'X','X','X','X'},{'X','X','X','X'},{'X','O','X','X'}};
       new SurroundedRegions().solve(input);
       assertArrayEquals(expected, input);
    }
}
