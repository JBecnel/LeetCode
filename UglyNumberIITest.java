import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class UglyNumberIITest {
    @Test
    public void uglyNumber_Test() {
        assertEquals( 12, new UglyNumberII().nthUglyNumber(10));
        assertEquals( 1, new UglyNumberII().nthUglyNumber(1));
        assertEquals( 15, new UglyNumberII().nthUglyNumber(11));
    }
}
