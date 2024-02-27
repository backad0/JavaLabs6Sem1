package Task8;

import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class DelThread extends Thread {
    private final List<Integer> list;
    private final ReentrantLock locker;
    private final Condition condition;

    public DelThread(List<Integer> list, String name, ReentrantLock locker, Condition condition) {
        super(name);
        this.list = list;
        this.locker = locker;
        this.condition = condition;
    }

    @Override
    public void run() {
        int deletedElement;
        int i = 0;
        while (i < 10000) {
            locker.lock();
            if (list.isEmpty()) {
                try {
                    condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            deletedElement = (int) (Math.random() * list.size());
            System.out.printf("%s[%d] " + list.size() + "; \n", Thread.currentThread().getName(), deletedElement);
            list.remove(deletedElement);
            i++;
            locker.unlock();
        }
    }
}
