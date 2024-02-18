package Task8;

import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public class AddThread extends Thread {
    private final List<Integer> list;
    private ReentrantLock locker;

    public AddThread(List<Integer> list, String name, ReentrantLock locker) {
        super(name);
        this.list = list;
        this.locker = locker;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            locker.lock();
            System.out.printf("%s " + list.size() + "; ", Thread.currentThread().getName());
            list.add((int) (Math.random() * Integer.MAX_VALUE * 2 + 1) - Integer.MAX_VALUE);
            locker.unlock();
        }
        System.out.println();
    }
}
