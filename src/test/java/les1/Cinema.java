package les1;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Cinema {

    // O(n). Проходим по массиву один раз, запоминаем появление занятых мест,
    // считаем расстояния в зависимости от появления занятых мест
    public static int calcBestDistance(int[] seats) {
        int left = -1, // показывает, что появилась первая (левая) единица
            countZero = 0, // считает количество 0 до и после левых 1
            dist = 0; // расстояние до свободных мест
        for (int i = 0; i < seats.length; i++) {
            if (seats[i] == 0) { // если 0, то просто считаем их
                countZero++;
            } else { // 1
                if (left == -1) { // если это первая 1, то
                    if (countZero > dist) // проверяем возможные посчитанные 0 до первой единицы
                        dist = countZero;
                } else {
                    countZero = (i - left) / 2; // иначе считаем расстояние между двумя 1
                    if (countZero > dist) // и сравниваем больше ли оно последнего рассчитанного расстояния
                        dist = countZero;
                }
                    left = i; // запоминаем новое начало 1
                countZero = 0; // обнуляем счётчик 0
            }
            // если массив заканчивается 0,
            // то нужно проверить посчитанные 0, больше ли они последнего рассчитанного расстояния
            if (i == (seats.length - 1) && seats[i] == 0 && countZero > dist)
                dist = countZero;
        }
        return dist;
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