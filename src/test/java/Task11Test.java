import Task11.Formatter;
import Task11.MyThread;
import org.junit.jupiter.api.Test;

import java.util.Date;

public class Task11Test {

    @Test
    public void test() throws InterruptedException {
        Formatter formatter = new Formatter();
        MyThread thread1 = new MyThread(formatter, new Date(1,0,1,1,1,1));
        MyThread thread2 = new MyThread(formatter, new Date(2,1,2,1,1,11));
        MyThread thread3 = new MyThread(formatter, new Date(3,2,3,1,1,21));
        MyThread thread4 = new MyThread(formatter, new Date(4,3,4,1,1,31));
        MyThread thread5 = new MyThread(formatter, new Date(5,4,5,1,1,41));
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
        thread1.join();
        thread2.join();
        thread3.join();
        thread4.join();
        thread5.join();
    }
}
