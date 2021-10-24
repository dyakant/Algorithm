package les1;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Cinema {

    public static int calcBestDistance(int[] seats) {
        return 0;
    }

    @Test
    public void testCalculations() {
        int[] a = {1, 0};
        assertEquals(1, calcBestDistance(a));

        a = new int[]{1, 0, 1};
        assertEquals(1, calcBestDistance(a));

        // в конце 0
        a = new int[]{1, 0, 1, 0, 0};
        assertEquals(2, calcBestDistance(a));

        // в начале 0
        a = new int[]{0, 0, 1, 0, 1};
        assertEquals(2, calcBestDistance(a));

        // в середине, нечетное
        a = new int[]{1, 0, 1, 0, 0, 0, 1};
        assertEquals(2, calcBestDistance(a));

        // в середине, четное
        a = new int[]{1, 0, 1, 0, 0, 0, 0, 1};
        assertEquals(2, calcBestDistance(a));

        // если внутри
        a = new int[]{1, 0, 0, 0, 0, 0, 1};
        assertEquals(3, calcBestDistance(a));

        // если с 0
        a = new int[]{0, 0, 0, 0, 1};
        assertEquals(4, calcBestDistance(a));

        // если с 1
        a = new int[]{1, 0, 0, 0, 0};
        assertEquals(4, calcBestDistance(a));

        // равнозначные варианты
        a = new int[]{0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0};
        assertEquals(5, calcBestDistance(a));
    }
}