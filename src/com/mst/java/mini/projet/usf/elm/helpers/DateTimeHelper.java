package com.mst.java.mini.projet.usf.elm.helpers;

import java.time.YearMonth;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * This class is for purpose to handle the date time functions in this app
 */
public class DateTimeHelper {
    Date date=new Date();

    public static String[] getDays() {
        String[] days = new String[31];
        for (int i=0;i<=30;i++){
            days[i]=String.valueOf(i+1);
        }
        return days;
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
        final int currentYear = calendar.get(Calendar.YEAR);

        String[] years =new String[currentYear-1900];
        for(int i=0;i<=currentYear-1901;i++){
            years[i]=String.valueOf(1900+i);
        }
        return years;
    }

}
