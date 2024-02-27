package Task4;

import java.util.List;

public class AddThread extends Thread {
    private final List<Integer> list;
    private final Object mutex;

    public AddThread(List<Integer> list, String name, Object mutex) {
        super(name);
        this.list = list;
        this.mutex = mutex;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            synchronized (mutex) {
                System.out.printf("%s " + list.size() + "; ", Thread.currentThread().getName());
                list.add((int) (Math.random() * Integer.MAX_VALUE * 2 + 1) - Integer.MAX_VALUE);
                mutex.notify();
            }
        }
        System.out.println();
    }
}

