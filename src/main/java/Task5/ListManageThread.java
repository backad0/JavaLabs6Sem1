package Task5;

import java.util.List;

public class ListManageThread extends Thread {

    private final List<Integer> list;

    public ListManageThread(List<Integer> list, String name) {
        super(name);
        this.list = list;
    }

    public synchronized void addRandomNumbers() {
        for (int i = 0; i < 10000; i++) {
            System.out.printf("adding " + list.size() + "; ");
            list.add((int) (Math.random() * Integer.MAX_VALUE*2+1) - Integer.MAX_VALUE);
        }
        System.out.println();
    }

    public synchronized void delRandomNumbers() {
        for (int i = 0; i < 10000; i++) {
            System.out.printf("deleting " + list.size() + "; ", Thread.currentThread().getName());
            list.remove((int) (Math.random() * list.size()));
        }
        System.out.println();
    }
}
