import Task10.MapThread;
import Task10.MyHashMap;
import org.junit.jupiter.api.Test;

public class Task10Test {

    @Test
    public void test() throws InterruptedException {
        MyHashMap<Integer> map = new MyHashMap<>();
        Thread thread0 = new MapThread(0, map,1);
        Thread thread1 = new MapThread(1, map,1);
        Thread thread2 = new MapThread(2, map,1);
        Thread thread3 = new MapThread(3, map,1);
        Thread thread4 = new MapThread(4, map,1);

        System.out.println(map);

        Thread thread5 = new MapThread(0, map,3);
        Thread thread6 = new MapThread(1, map,3);
        Thread thread7 = new MapThread(2, map,3);
        Thread thread8 = new MapThread(3, map,3);
        Thread thread9 = new MapThread(4, map,3);

        thread0.start();
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
        thread6.start();
        thread7.start();
        thread8.start();
        thread9.start();

        thread0.join();
        thread1.join();
        thread2.join();
        thread3.join();
        thread4.join();

        thread5.join();
        thread6.join();
        thread7.join();
        thread8.join();
        thread9.join();

        System.out.println(map);
    }
}
