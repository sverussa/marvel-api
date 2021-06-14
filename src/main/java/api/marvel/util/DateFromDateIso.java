package api.marvel.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFromDateIso {

    private static final DateFormat formatIso = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ");

    public static synchronized Date getDateFromString(String date) throws ParseException {
        return formatIso.parse(date);
    }
}
