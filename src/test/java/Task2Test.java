import Task2.Task2Thread1;
import Task2.Task2Thread2;
import Task2.Task2Thread3;
import org.junit.jupiter.api.Test;

public class Task2Test {
    @Test
    public void task2Test1() {
        System.out.println("Main thread started");
        try {
            Task2Thread1 thread1 = new Task2Thread1("thread1");
            Task2Thread2 thread2 = new Task2Thread2("thread2");
            Task2Thread3 thread3 = new Task2Thread3("thread3");
            thread1.start();
            thread2.start();
            thread3.start();
            thread1.join();
            thread2.join();
            thread3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Main thread finished");
    }
}
