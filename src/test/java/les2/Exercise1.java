package les2;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;

// Занятие 2, упражнение 1
// Даны два упорядоченных массива. Требуется выполнить
// слияние этих массивов. Результат – упорядоченный массив;
public class Exercise1 {

    // Сложность О(n).
    // Упорядочить по возрастанию, если массивы упорядочены по убыванию
    // последовательное копирование элементов из двух массивов в конечный массив
    // с предварительным сравнением элементов в обоих массивах
    public static int[] mergeArrays(int[] arr1, int[] arr2) {
        int arr1Length = arr1.length;
        int arr2Length = arr2.length;
        int[] res = new int[arr1Length + arr2Length];

        // Упорядочить по возрастанию, если массив 1 упорядочен по убыванию
        if (arr1[0] > arr1[arr1Length - 1]) {
            int tmp;
            for (int i = 0; i < arr1Length / 2; i++) {
                tmp = arr1[i];
                arr1[i] = arr1[arr1Length - 1 - i];
                arr1[arr1Length - 1 - i] = tmp;
            }
        }
        // Упорядочить по возрастанию, если массив 2 упорядочен по убыванию
        if (arr2[0] > arr2[arr2Length - 1]) {
            int tmp;
            for (int i = 0; i < arr2Length / 2; i++) {
                tmp = arr2[i];
                arr2[i] = arr2[arr2Length - 1 - i];
                arr2[arr2Length - 1 - i] = tmp;
            }
        }

        // заполенение конечного массива за один проход
        int i1 = 0, i2 = 0; // счётчики для каждого массива
        for (int i = 0; i < res.length; i++) {
            if (i1 == arr1Length) res[i] = arr2[i2++]; // если 1-ый массив закончился, то копировать только из 2-го
            else if (i2 == arr2Length) res[i] = arr1[i1++]; // если 2-ой массив закончился, то копировать только из 1-го
            // взять очередной элемент 1-го массива если он меньше чем очередной элемент 2-го массива, увеличить счётчик 1-го
            else if (arr1[i1] < arr2[i2]) res[i] = arr1[i1++];
            // взять очередной элемент 2-го массива если он меньше чем очередной элемент 1-го массива, увеличить счётчик 2-го
            else res[i] = arr2[i2++];
        }

        return res;
    }

    @Test
    public void testCalculations() {
        int[] exp = new int[]{1, 2, 3, 4, 5, 5, 6, 6, 7, 8, 9, 10};

        int[] a1 = {1, 5, 7, 8, 10};
        int[] a2 = {2, 3, 4, 5, 6, 6, 9};
        assertArrayEquals(exp, mergeArrays(a1, a2));

        a1 = new int[]{1, 5, 7, 8, 10};
        a2 = new int[]{9, 6, 6, 5, 4, 3, 2};
        assertArrayEquals(exp, mergeArrays(a1, a2));

        a1 = new int[]{10, 8, 7, 5, 1};
        a2 = new int[]{2, 3, 4, 5, 6, 6, 9};
        assertArrayEquals(exp, mergeArrays(a1, a2));

        a1 = new int[]{10, 8, 7, 5, 1};
        a2 = new int[]{9, 6, 6, 5, 4, 3, 2};
        assertArrayEquals(exp, mergeArrays(a1, a2));
    }
}
