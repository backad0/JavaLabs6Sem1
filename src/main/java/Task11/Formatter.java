package Task11;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Formatter {

    private static final ThreadLocal<SimpleDateFormat> sdf = ThreadLocal.withInitial(SimpleDateFormat::new);

    public String format(Date date) {
        return sdf.get().format(date);
    }
}
