package util;

import java.sql.Date;
import java.sql.Timestamp;

public class DateUtil {
    private static Timestamp current;

    private DateUtil() {
    }

    public static Timestamp getCurrentDateTime() {
        if (current == null) {
            current = new Timestamp(System.currentTimeMillis());
        }
        return current;
    }
}
