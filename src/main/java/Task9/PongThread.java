package Task9;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class PongThread extends Thread {

    private final Condition condition;
    private final ReentrantLock lock;
    private AtomicBoolean flag;

    public PongThread(Condition condition, AtomicBoolean flag, ReentrantLock lock) {
        this.condition = condition;
        this.flag = flag;
        this.lock = lock;
    }

    @Override
    public void run() {
        while (true){
//            synchronized (condition) {
                lock.lock();
                while (!flag.get()){
                    try {
                        condition.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                flag.set(false);
                System.out.println("pong");
                condition.signal();
                lock.unlock();
//            }
        }
    }
}
