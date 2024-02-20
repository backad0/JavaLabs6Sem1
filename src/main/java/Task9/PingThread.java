package Task9;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Condition;

public class PingThread extends Thread {

    private final Condition condition;
    private AtomicBoolean flag;

    public PingThread(Condition condition, AtomicBoolean flag) {
        this.condition = condition;
        this.flag = flag;
    }

    @Override
    public void run() {
        while (true){
            synchronized (condition) {
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
            }
        }
    }
}
