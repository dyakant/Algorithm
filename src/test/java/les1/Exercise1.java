package les1;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class Exercise1 {

    @Test
    public void testCalculations() {
        int[] a = {2, 7, 3};
        assertEquals(3, findMiddle(a), 0);

        a = new int[]{1, 4, 7};
        assertEquals(4, findMiddle(a), 0);

        a = new int[]{10, 8, 7};
        assertEquals(8, findMiddle(a), 0);

        double[] d = new double[]{6.5, -4.0, 7.3};
        assertEquals(6.5, findMiddle(d), 0);
    }

    private double findMiddle(int[] a) {
        double[] d = new double[a.length];
        for (int i = 0; i<a.length; i++) {
            d[i] = a[i];
        }
        sortArr(d);
        return d[1]; // Работает только для массива с размером 1
    }

    private double findMiddle(double[] a) {
        // Вариант 2. С предварительной сортировкой.
        // Сложность О(1), т.к. известна размерность массиво - 3
        sortArr(a);
        return a[1];

        // Вариант 1. Сложность О(1).
        // Минус. Сложное условие
//        if((a[0] > a[1] && a[0] < a[2]) || (a[0] > a[2] && a[0] < a[1])) return a[0];
//        else if((a[1] > a[0] && a[1] < a[2]) || (a[1] > a[2] && a[1] < a[0])) return a[1];
//        else return a[2];

    }

    private void sortArr(double[] a) {
        for(int i = 0; i < a.length -1; i++) {
            for(int j = i + 1; j < a.length ; j++) {
                if(a[i] > a[j]) {
                    double tmp = a[j];
                    a[j]  = a[i];
                    a[i] = tmp;
                }
            }
        }
    }


}
