package Task7;

import java.util.concurrent.Semaphore;

public class PingThread extends Thread {

    Semaphore sem;

    public PingThread(Semaphore sem) {
        this.sem = sem;
    }
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            try {
                sem.acquire();
                System.out.println("ping");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            sem.release();
        }
    }
}
