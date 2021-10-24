package les1;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Exercize3 {
    @Test
    public void testFindCloseToMiddle() {
        int[] a = {1, 4, 5, 10};
        assertEquals(5, findCloseToMiddle(a));

        a = new int[]{1, 4, 8, 10};
        assertEquals(4, findCloseToMiddle(a));

        a = new int[]{1, 60, 3, 4, 2, 100};
        assertEquals(60, findCloseToMiddle(a));

        a = new int[]{100, 2, 3, 4, 95, 1};
        assertEquals(95, findCloseToMiddle(a));

    }

    // Сложность О(n^2) из-за сортировки
    // Сортировка для того, чтобы найти минимально и максимальное значения
    private int findCloseToMiddle(int[] a) {
        sortArr(a);
        int middle = (a[0] + a[a.length-1]) / 2;
        int res = middle - a[0];
        int returnVal = -1;

        for (int i = 1; i < a.length; i++) {
            int tmp = middle - a[i];
            if (Math.abs(tmp) < Math.abs(res)) {
                res = tmp;
                returnVal = a[i];
            }
        }
        return returnVal;
    }

    private void sortArr(int[] a) {
        for(int i = 0; i < a.length -1; i++) {
            for(int j = i + 1; j < a.length ; j++) {
                if(a[i] > a[j]) {
                    int tmp = a[j];
                    a[j]  = a[i];
                    a[i] = tmp;
                }
            }
        }
    }
}
