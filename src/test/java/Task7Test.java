import Task7.PingThread;
import Task7.PongThread;
import org.junit.jupiter.api.Test;

public class Task7Test {

    @Test
    public void test() {
        PingThread pingThread = new PingThread();
        PongThread pongThread = new PongThread();
        pingThread.start();
        pongThread.start();
    }
}
