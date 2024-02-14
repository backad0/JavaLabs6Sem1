import Task1.FirstTaskThread;
import org.junit.jupiter.api.Test;

public class Task1Test {
    @Test
    public void task1Test1(){
        System.out.println("Main thread started");
        try {
            Thread fTT = new Thread(new FirstTaskThread(), "fTT");
            fTT.start();
            fTT.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Main thread finished");
    }
}
