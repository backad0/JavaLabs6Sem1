package Task1;

public class FirstTaskThread implements Runnable{
    @Override
    public void run() {
        System.out.printf("%s started\n", Thread.currentThread().getName());
        try {
            System.out.println("Thread name: " + Thread.currentThread().getName());
            System.out.println("Thread priority: " + Thread.currentThread().getPriority());
            System.out.println("ThreadGroup name: " + Thread.currentThread().getThreadGroup().getName());
            System.out.println("Is thread alive: " + Thread.currentThread().isAlive());
            System.out.println("Is thread interrupted: " + Thread.currentThread().isInterrupted());
            System.out.println("Is thread daemon: " + Thread.currentThread().isDaemon());
        } catch (Exception e) {
            System.out.println("Thread has been interrupted");
        }
        System.out.printf("%s finished\n", Thread.currentThread().getName());
    }
}
