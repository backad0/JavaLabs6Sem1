package Task7;

public class PingThread extends Thread {

    @Override
    public void run() {
        System.out.println("ping");
        for (int i = 0; i < 999; i++) {
            System.out.println("ping");
            notify();
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
