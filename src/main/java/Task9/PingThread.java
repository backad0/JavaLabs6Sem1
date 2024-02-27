package Task9;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class PingThread extends Thread {

    private final Condition condition;
    private final ReentrantLock lock;
    private AtomicBoolean flag;

    public PingThread(Condition condition, AtomicBoolean flag, ReentrantLock lock) {
        this.condition = condition;
        this.flag = flag;
        this.lock = lock;
    }

    @Override
    public void run() {
        while (true){
                lock.lock();
                while (flag.get()){
                    try {
                        condition.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                flag.set(true);
                System.out.println("ping");
                condition.signal();
                lock.unlock();
        }
    }
}
