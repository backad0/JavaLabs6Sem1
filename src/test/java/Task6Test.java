import Task6.AddThread;
import Task6.DelThread;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Task6Test {

    @Test
    public void test() {
        List<Integer> list = Collections.synchronizedList(new ArrayList<>());
        AddThread addThread = new AddThread(list, "addThread");
        DelThread delThread = new DelThread(list, "delThread");
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
