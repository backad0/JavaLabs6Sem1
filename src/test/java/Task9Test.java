import Task7.PingThread;
import Task7.PongThread;
import org.junit.jupiter.api.Test;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Task9Test {

    @Test
    public void test() {
        ReentrantLock lock = new ReentrantLock();
        Condition condition = lock.newCondition();
        AtomicBoolean flag = new AtomicBoolean(true);
        PingThread pingThread = new PingThread(condition, flag);
        PongThread pongThread = new PongThread(condition, flag);
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
