package Task4;

import java.util.List;

public class DelThread extends Thread {
    private final List<Integer> list;
    private final Object mutex;

    public DelThread(List<Integer> list, String name, Object mutex) {
        super(name);
        this.list = list;
        this.mutex = mutex;
    }

    @Override
    public void run() {
        try {
            int deletedElement;
            for (int i = 0; i < 10000; i++) {
                synchronized (mutex) {
                    if (list.size() == 0) mutex.wait();
                    deletedElement = (int) (Math.random() * list.size());
                    System.out.printf("%s[%d] " + list.size() + "; ", Thread.currentThread().getName(), deletedElement);
                    list.remove(deletedElement);
                }
            }
            System.out.println();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
