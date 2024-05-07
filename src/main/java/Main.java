import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {
    public static void main(String[] args){
        Date date = new Date(1, 1, 1);
        SimpleDateFormat format = new SimpleDateFormat();
        String res = format.format(date);
        System.out.println(res);
        System.out.println(date);
    }
}
