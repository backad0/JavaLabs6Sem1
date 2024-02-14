package Task2;

public class Task2Thread2 extends Thread {

    public Task2Thread2(String name) {
        super(name);
    }

    @Override
    public void run() {
        System.out.println(getName() + " started");
        System.out.println(getName() + " finished");
    }
}
