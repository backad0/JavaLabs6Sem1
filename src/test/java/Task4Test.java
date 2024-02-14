import Task4.AddThread;
import Task4.DelThread;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
/*
В основном потоке создать ArrayList<Integer>. Запустить 2 потока на базе разных
классов, один поток 10000 раз добавляет в список случайное целое число, другой
10000 раз удаляет элемент по случайному индексу. Использоватьвнешний
synchronized блок
*/
public class Task4Test {

    @Test
    public void test() {
        List<Integer> list = new ArrayList<>();
        AddThread addThread = new AddThread(list, "addThread");
        DelThread delThread = new DelThread(list, "delThread");
        addThread.start();
        delThread.start();
        try {
            addThread.join();
            delThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(list.toString());
    }
}
