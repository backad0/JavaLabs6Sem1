import Task5.ListManageThread;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class Task5Test {

    @Test
    public void test() {
        List<Integer> list = new ArrayList<>();
        ListManageThread addThread = new ListManageThread(list, "addThread");
        ListManageThread delThread = new ListManageThread(list, "delThread");
        addThread.start();
        delThread.start();
        addThread.addRandomNumbers();
        delThread.delRandomNumbers();
        try {
            addThread.join();
            delThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(list);
    }
}
