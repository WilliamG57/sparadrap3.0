package fr.afpa.pompey.cda22045.sparadrap.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DateManagment {

    public static String parse(String date, String message) throws MyException {
        try {
            if (date == null) {
                throw new MyException(message);
            }
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
            sdf.parse(date);
            return date;
        } catch (ParseException pe) {
            throw new MyException(message);
        }
    }

    public static java.sql.Date convertString(String date) {

        java.util.Date tampon;
        java.sql.Date result = null;
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        try {
            tampon = sdf.parse(date);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        result = new java.sql.Date(tampon.getTime());
        return result;
    }
}
