package com.mst.java.mini.projet.usf.elm.helpers;

import java.time.YearMonth;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateTimeHelper {
    Date date=new Date();

    public static String[] getDays(int monthOfYear, int year) {
        YearMonth yearMonthObject = YearMonth.of(year, monthOfYear);
        int daysInMonthLength = yearMonthObject.lengthOfMonth();
        String[] daysInMonth = new String[daysInMonthLength];
        for (int i = 0; i < daysInMonthLength; i++) {
            daysInMonth[i] = String.valueOf(daysInMonthLength + 1);
        }
        return daysInMonth;
    }

    public static String[] getMonths() {
        return new String[]{"Janvier",
                "Février",
                "Mars",
                "Avril",
                "Mai",
                "Juin",
                "Juillet",
                "Août",
                "Septembre",
                "Octobre",
                "Novembre",
                "Décembre"};
    }


    public static String[] getYears() {
        Calendar calendar = new GregorianCalendar();
        final int currentYear = calendar.get(Calendar.YEAR) - 1900;

        return new String[]{"2010","2020","®2020"};
    }

}
