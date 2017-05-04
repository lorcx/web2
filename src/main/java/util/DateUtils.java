package util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 日期处理
 * Created by Administrator on 2017/3/6 0006.
 */
public class DateUtils {
    public static final String DATE_PATTERN = "yyyy-MM-dd";

    public static final String DATE_TIME_PATTERN = "yyyy-MM-dd HH:mm:ss";

    public static String format(Date date) {
        return format(date, DATE_PATTERN);
    }

    public static String format(Date date, String datePattern) {
        if (null != date) {
            SimpleDateFormat format = new SimpleDateFormat(datePattern);
            return format.format(date);
        }
        return null;
    }
}
