package les2;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

// Занятие 2, упражнение 1
// Даны два упорядоченных массива. Требуется выполнить
// слияние этих массивов. Результат – упорядоченный массив;
public class Exercise1 {

    // Сложность О(n). Последовательный проход по каждому массиву
    // и копирование в новый
    public static int[] mergeArrays(int[] arr1, int[] arr2) {
        int arr1Length = arr1.length;
        int arr2Length = arr2.length;
        int[] res = new int[arr1Length + arr2Length];

        // в зависимости от направления сортировки выбирается необходимый цикл
        if (arr1[0] < arr1[arr1Length - 1]) {
            for (int i = 0; i < arr1Length; i++) {
                res[i] = arr1[i];
            }
        } else {
            int shift = 0;
            for (int i = arr1Length - 1; i >= 0; i--) {
                res[shift++] = arr1[i];
            }
        }

        // в зависимости от направления сортировки выбирается необходимый цикл
        int shift = arr1Length; // сдвиг для вставки элементов из второго массива
        if (arr2[0] < arr2[arr2Length - 1]) {
            for (int i = 0; i < arr2Length; i++) {
                res[shift++] = arr2[i];
            }
        } else {
            for (int i = arr2Length - 1; i >= 0; i--) {
                res[shift++] = arr2[i];
            }
        }

        return res;
    }

    @Test
    public void testCalculations() {
        int[] exp = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};

        int[] a1 = {1, 2, 3, 4, 5};
        int[] a2 = {6, 7, 8, 9, 10, 11};
        assertArrayEquals(exp, mergeArrays(a1, a2));

        a1 = new int[]{1, 2, 3, 4, 5};
        a2 = new int[]{11, 10, 9, 8, 7, 6};
        assertArrayEquals(exp, mergeArrays(a1, a2));

        a1 = new int[]{5, 4, 3, 2, 1};
        a2 = new int[]{6, 7, 8, 9, 10, 11};
        assertArrayEquals(exp, mergeArrays(a1, a2));

        a1 = new int[]{5, 4, 3, 2, 1};
        a2 = new int[]{11, 10, 9, 8, 7, 6};
        assertArrayEquals(exp, mergeArrays(a1, a2));
    }
}
