import Task7.PingThread;
import Task7.PongThread;
import org.junit.jupiter.api.Test;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicBoolean;

public class Task7Test {

    @Test
    public void test() {
        Object obj = new Object();
        AtomicBoolean flag = new AtomicBoolean(true);
        PingThread pingThread = new PingThread(obj, flag);
        PongThread pongThread = new PongThread(obj, flag);
        pingThread.start();
        pongThread.start();
        try{
            pingThread.join();
            pongThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
