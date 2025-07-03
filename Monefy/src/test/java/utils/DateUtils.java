package utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateUtils {

    public static String getCurrentMonth() {
        return new SimpleDateFormat("MMMM", Locale.ENGLISH).format(new Date());
    }

    public static String getFormattedCurrentDate() {
        return new SimpleDateFormat("EEEE, d MMMM", Locale.ENGLISH).format(new Date());
    }
}
