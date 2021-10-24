package les1;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class Exercize4 {
    @Test
    public void testShiftArray() {
        int[] a = {1, 2, 3, 4, 5};
        assertArrayEquals(new int[]{3, 4, 5, 1, 2}, shiftArray(a, 2));

        a = new int[]{1, 2, 3, 4, 5};
        assertArrayEquals(new int[]{5, 1, 2, 3, 4}, shiftArray(a, 4));

        a = new int[]{1, 2, 3, 4, 5};
        assertArrayEquals(new int[]{2, 3, 4, 5, 1}, shiftArray(a, 6));

        a = new int[]{1, 2, 3, 4, 5};
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, shiftArray(a, 5));
    }

    // Сложность O(n). Массив разбивается на две части и копируется в новый
    private int[] shiftArray(int[] a, int step) {
        if (step > a.length) step = step % a.length;
        int[] newArr = new int[a.length];
        for (int i = step; i < a.length; i++) {
            newArr[i - step] = a[i];
        }
        for (int i = 0; i < step; i++) {
            newArr[a.length - step + i] = a[i];
        }
        return newArr;
    }
}
