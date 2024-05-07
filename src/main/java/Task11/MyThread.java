package Task11;

import java.util.Date;

public class MyThread extends Thread {

    private Formatter formatter;
    private Date date;


    public MyThread(Formatter formatter, Date date) {
        this.formatter = formatter;
        this.date = date;
    }

    @Override
    public void run() {
        String res = formatter.format(date);
        System.out.println(res);
    }
}
