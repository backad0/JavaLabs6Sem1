package Task6;

import java.util.List;

public class DelThread extends Thread {
    private final List<Integer> list;

    public DelThread(List<Integer> list, String name) {
        super(name);
        this.list = list;
    }

    @Override
    public void run() {
        int deletedElement;
        int i = 0;
        while (i < 10000) {
            if (list.isEmpty()) {
                continue;
            }
            deletedElement = (int) (Math.random() * list.size());
            System.out.printf("%s[%d] " + list.size() + "; \n", Thread.currentThread().getName(), deletedElement);
            list.remove(deletedElement);
            i++;
        }
    }
}
