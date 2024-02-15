import Task7.PingThread;
import Task7.PongThread;
import org.junit.jupiter.api.Test;

import java.util.concurrent.Semaphore;

public class Task7Test {

    @Test
    public void test() {
        Semaphore sem = new Semaphore(1);
        PingThread pingThread = new PingThread(sem);
        PongThread pongThread = new PongThread(sem);
        pingThread.start();
        pongThread.start();
    }
}
