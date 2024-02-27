package Task5;

import java.util.concurrent.atomic.AtomicBoolean;

public class ListManageThread extends Thread {

    private final ListManager list;
    private final AtomicBoolean isAdd;

    public ListManageThread(ListManager list, String name, AtomicBoolean idAdd) {
        super(name);
        this.list = list;
        this.isAdd = idAdd;
    }


    @Override
    public void run() {
        if (isAdd.get()) {
            for (int i = 0; i < 10000; i++) {
                list.addRandomNumber();
            }
        } else {
            for (int i = 0; i < 10000; i++) {
                list.delRandomNumber();
            }
        }
    }
}
