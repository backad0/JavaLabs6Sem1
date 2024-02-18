package Task7;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;

public class PingThread extends Thread {

    private final Object lock;
    private AtomicBoolean flag;

    public PingThread(Object lock, AtomicBoolean flag) {
        this.lock = lock;
        this.flag = flag;
    }

    @Override
    public void run() {
        while (true){
            synchronized (lock) {
                while (flag.get()){
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                flag.set(true);
                System.out.println("ping");
                lock.notify();
            }
        }
    }
}
