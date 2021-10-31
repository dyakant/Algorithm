package les3;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;

// Занятие 3, упражнение 3
// Реализовать сортировки: быстрая, timsort, подсчетом, поразрядная.
public class Exercise3 {

    // вызов бустрой сортировки
    public static int[] quickSortTest(int[] arr) {
        // копирование объекта выбрано для удобства тестирования
        int[] res = arr.clone();

        quickSort(res, 0, res.length - 1);

        return res;
    }

    // реализация быстрой сортировки
    private static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int p = partition(arr, low, high);
            quickSort(arr, low, p - 1);
            quickSort(arr, p + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int p = arr[high]; // запоминаем правый элемент, опорный
        int i = low; // нижняя граница это индекс левого
        for (int j = i; j <= high - 1; j++) { // проходим по всем элементам, кроме последнего, опорного
            if (arr[j] <= p) { // если текущий элемент меньше "опорного"
                // помещаем элемент в левую часть
                int tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
                i++; // сдвигаем нижний индекс
            }
        }
        int tmp = arr[i];
        arr[i] = p;
        arr[high] = tmp;
        return i;
    }

    // Сортировка подсчётом
    public static int[] sortByCount(int[] arr) {
        int[] helpArr = new int[100];
        for (int e : helpArr) e = 0;

        for (int j : arr) helpArr[j]++;

        int[] resArr = new int[arr.length];
        int resC = 0;
        for (int j = 0; j < helpArr.length; j++) {
            if (helpArr[j] != 0) {
                for (int i = 0; i < helpArr[j]; i++) {
                    resArr[resC++] = j;
                }
            }
        }
        return resArr;
    }

    int[] arrRand = new int[100];
    int[] arrSorted;

    @Before
    public void init() {
        for (int i = 0; i < arrRand.length; i++) {
            arrRand[i] = (int) (Math.random() * 100);
        }
        arrSorted = arrRand.clone();
        Arrays.sort(arrSorted);
    }

    @Test
    public void testQuickSort() {
        assertArrayEquals(arrSorted, quickSortTest(arrRand));
    }

    @Test
    public void testSortByCount() {
        assertArrayEquals(arrSorted, sortByCount(arrRand));
    }
}
