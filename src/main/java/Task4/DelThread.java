package Task4;

import java.util.List;

public class DelThread extends Thread{
    private final List<Integer> list;

    public DelThread(List<Integer> list, String name) {
        super(name);
        this.list = list;
    }

    @Override
    public void run() {
        int deletedElement;
        synchronized (list) {
            for (int i = 0; i < 10000; i++) {
                deletedElement = (int) (Math.random() * list.size());
                System.out.printf("%s[%d] " + list.size() + "; ", Thread.currentThread().getName(), deletedElement);
                list.remove(deletedElement);
            }
            System.out.println();
        }
    }
}
