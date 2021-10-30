package les2;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

// Занятие 2, упражнение 3
// Дан массив целых чисел размера 2n + 1. Известно, что для
// каждого числа есть пара, но только для одного пары нет. Найти
// такое число;
public class Exercise3 {

    // Сложность О(n).
    // Упорядочить по возрастанию, если массивы упорядочены по убыванию
    // последовательное копирование элементов из двух массивов в конечный массив
    // с предварительным сравнением элементов в обоих массивах
    public static int findAlone(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if(map.containsKey(arr[i])) map.remove(arr[i]);
            else map.put(arr[i], arr[i]);
        }
        int res = -1;
        for (Integer el: map.keySet()) res = el;
        return res;
    }

    @Test
    public void testCalculations() {

        int[] a = {1, 2, 3, 4, 5, 1, 2, 3, 4};
        assertEquals(5, findAlone(a));
    }
}
