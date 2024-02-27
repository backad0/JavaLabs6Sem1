import Task5.ListManageThread;
import Task5.ListManager;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class Task5Test {

    @Test
    public void test() {
        List<Integer> list = new ArrayList<>();
        ListManager listManager = new ListManager(list);
        ListManageThread addThread = new ListManageThread(listManager,  "addThread", new AtomicBoolean(true));
        ListManageThread delThread = new ListManageThread(listManager, "delThread", new AtomicBoolean(false));
        addThread.start();
        delThread.start();
        try {
            addThread.join();
            delThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(list);
    }
}
