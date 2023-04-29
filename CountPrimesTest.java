import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CountPrimesTest {
    @Test
    public void countPrimes_test() {
        CountPrimes c = new CountPrimes();
        assertEquals(4, c.countPrimes(10));
        assertEquals(0, c.countPrimes(0));
        assertEquals(0, c.countPrimes(1));
        assertEquals(0, c.countPrimes(2));
        assertEquals(8, c.countPrimes(20));
    }
}
