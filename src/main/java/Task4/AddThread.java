package Task4;

import java.util.List;

public class AddThread extends Thread {
    private final List<Integer> list;

    public AddThread(List<Integer> list, String name) {
        super(name);
        this.list = list;
    }

    @Override
    public void run() {
        synchronized (list) {
            for (int i = 0; i < 10000; i++) {
                System.out.printf("%s " + list.size() + "; ", Thread.currentThread().getName());
                list.add((int) (Math.random() * Integer.MAX_VALUE*2+1) - Integer.MAX_VALUE);
            }
            System.out.println();
        }
    }
}
