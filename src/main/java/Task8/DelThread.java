package Task8;

import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public class DelThread extends Thread {
    private final List<Integer> list;
    private ReentrantLock locker;

    public DelThread(List<Integer> list, String name, ReentrantLock locker) {
        super(name);
        this.list = list;
        this.locker = locker;
    }

    @Override
    public void run() {
        int deletedElement;
        locker.lock();
        for (int i = 0; i < 10000; i++) {

            deletedElement = (int) (Math.random() * list.size());
            System.out.printf("%s[%d] " + list.size() + "; ", Thread.currentThread().getName(), deletedElement);
            list.remove(deletedElement);

        }
        locker.unlock();
        System.out.println();
    }
}
