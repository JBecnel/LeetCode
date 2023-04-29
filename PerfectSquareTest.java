import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PerfectSquareTest {
    @Test
    public void numSquares_Test() {
        assertEquals(3, new PerfectSquares().numSquares(12));
        assertEquals(2, new PerfectSquares().numSquares(13));
        assertEquals(1, new PerfectSquares().numSquares(1));
        assertEquals(1, new PerfectSquares().numSquares(4));
    }
}
