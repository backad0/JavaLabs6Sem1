package Task5;

import java.util.List;

public class ListManager {

    private final List<Integer> list;

    public ListManager(List<Integer> list) {
        this.list = list;
    }

    public synchronized void addRandomNumber() {
        System.out.print("adding " + list.size() + "; \n");
        list.add((int) (Math.random() * Integer.MAX_VALUE * 2 + 1) - Integer.MAX_VALUE);
        this.notify();
    }

    public synchronized void delRandomNumber() {
        int deletedElement;
        while (list.isEmpty()) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        deletedElement = (int) (Math.random() * list.size());
        System.out.printf("%s[%d] " + list.size() + "; \n", Thread.currentThread().getName(), deletedElement);
        list.remove(deletedElement);
    }
}
