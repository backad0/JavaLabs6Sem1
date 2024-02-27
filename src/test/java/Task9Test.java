import Task9.PingThread;
import Task9.PongThread;
import org.junit.jupiter.api.Test;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Task9Test {

    @Test
    public void test() {
        ReentrantLock lock = new ReentrantLock();
        Condition condition = lock.newCondition();
        AtomicBoolean flag = new AtomicBoolean(false);
        PingThread pingThread = new PingThread(condition, flag, lock);
        PongThread pongThread = new PongThread(condition, flag, lock);
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
