package Task2;

public class Task2Thread3 extends Thread {

    public Task2Thread3(String name) {
        super(name);
    }

    @Override
    public void run() {
        System.out.println(getName() + " started");
        System.out.println(getName() + " finished");
    }
}
