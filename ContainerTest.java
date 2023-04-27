import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ContainerTest {
    @Test
    public void Test() {
        int[] a = {1,1};
        assertEquals(1, new ContainerWithMostWater().maxArea(a));

        int[] b = {1,8,6,2,5,4,8,3,7};
        assertEquals(49, new ContainerWithMostWater().maxArea(b));
    }
}
