package Task7;

public class PongThread extends Thread {

    @Override
    public void run() {
        try {
            wait();
            for (int i = 0; i < 1000; i++) {
                System.out.println("pong");
                notify();
                wait();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
