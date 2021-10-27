package les2;

import org.junit.Test;

import java.sql.SQLOutput;
import java.util.*;

import static org.junit.Assert.assertArrayEquals;

// Занятие 2, упражнение 2
// Дан односвязный список [first half] → [last half]. Требуется
// выполнить перестроение [last half] → [first half];
public class Exercise2 {

    @Test
    public void testCalculations() {
        shiftHalfOfList();
    }

    public void shiftHalfOfList() {

        MyList list = new MyList();
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        list.add(50);
        list.add(60);
        System.out.println(list);

        // Первый способ с двойным полным пробегом по всему списку
        // list.shiftHalfOfList();

        // Второй способ с одним пробегом по списку и двойным бегунком
        // Сложность O(n)
        list.shiftHalfOfListWithDoubleRunner();
        System.out.println(list);
    }

}

class MyList {
    private MyList next;
    private MyList head;
    private int val;

    MyList() {}
    MyList(int i) { this.val = i; }

    public void add(int i) {
        MyList el = new MyList(i);
        if (this.head == null) {
            this.head = el;
        } else {
            MyList e = this.head;
            while (e.next != null) {
                e = e.next;
            }
            e.next = el;
        }
    }

    public void shiftHalfOfList() {
        if (this.head == null) return;

        MyList oldTail;
        int count = 0;

        // Первый пробег по списку
        // подсчёт элементов
        // запоминаем хвост
        MyList el = this.head;
        do {
            count++;
            oldTail = el;
            el = el.next;
        } while (el != null);

        // Второй пробге по списку
        // останавливаемся на середине
        el = this.head;
        for (int j = 1; j < count / 2; j++) {
            el = el.next;
        }

        oldTail.next = this.head; // старый head станоивтся продолжением списка
        this.head = el.next; // новая голова это следующий элемент от середины
        el.next = null; //  обнуление следуещего элемента для нового "хвоста"
    }

    public void shiftHalfOfListWithDoubleRunner() {
        if (this.head == null) return;

        MyList elOneStep = this.head; // бегунок с одним шагом
        MyList elDoubleStep = this.head; // бегунок с двойным шагом

        // пробегаем один раз по всему списку
        do {
            if(elDoubleStep.next != null) elDoubleStep = elDoubleStep.next; // шаг 1
            if(elDoubleStep.next != null) elDoubleStep = elDoubleStep.next; // шаг 2
            if(elDoubleStep.next != null) elOneStep = elOneStep.next; // если не конец списка, то сдвигаем одиночный бегунок
        } while (elDoubleStep.next != null);


        elDoubleStep.next = this.head; // старый "хвост" теперь указывает на старую "голову"
        this.head = elOneStep.next; // новая "голова" теперь следующий элемент после середины
        elOneStep.next = null; // обнуление следуещего элемента для нового "хвоста"
    }


    @Override
    public String toString() {
        List<Integer> arr = new ArrayList<>();
        MyList e = this.head;
        do {
            arr.add(e.val);
            e = e.next;
        } while (e != null);
        return arr.toString();
    }
}
