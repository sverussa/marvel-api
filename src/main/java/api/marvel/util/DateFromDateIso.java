package api.marvel.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFromDateIso {

    private static final DateFormat formatIso = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ");
    private static final DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static synchronized Date getDateFromString(String date) throws ParseException {
        if (date == null) {
            return null;
        }
        return formatIso.parse(date);
    }

    public static synchronized Date getDatePatternFromString(String date) throws ParseException {
        if (date == null) {
            return null;
        }
        return format.parse(date);
    }
}
