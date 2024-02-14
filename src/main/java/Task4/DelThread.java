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
        synchronized (list) {
            for (int i = 0; i < 10000; i++) {
                System.out.printf("%s " + list.size() + "; ", Thread.currentThread().getName());
                list.remove((int) (Math.random() * list.size()));
            }
            System.out.println();
        }
    }
}
