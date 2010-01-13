
package Common;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 * @author hvu
 */
public class Utility {
    public static final String DATE_FORMAT = "yyyyMMddHHmmss";

    public static String now() {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
        return sdf.format(cal.getTime());
    }
}
