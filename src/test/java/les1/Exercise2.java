package les1;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Exercise2 {
    @Test
    public void testReverse() {
        int a = 103;
        assertEquals(301, reverse(a));

        a = 2487;
        assertEquals(7842, reverse(a));
    }

    // Сложность О(n).
    // Перевод числа в строку, реверс строки
    private int reverse(int a) {
        String s = String.valueOf(a);
        StringBuilder sb = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            sb.append(s.charAt(i));
        }
        s = sb.toString();
        return Integer.parseInt(s);
    }
}
