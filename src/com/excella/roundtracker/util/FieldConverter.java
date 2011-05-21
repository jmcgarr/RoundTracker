package com.excella.roundtracker.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import android.text.Editable;

public class FieldConverter
{
    private static final SimpleDateFormat SQLITEFORMAT = new SimpleDateFormat("YYYY-MM-dd");
    private static final SimpleDateFormat FORMFIELDFORMAT = new SimpleDateFormat("MM/dd/yy");

    /**
     * @param scoreText
     * @return
     */
    public static int convertTextToInt(Editable scoreText)
    {
        int score = -1;
        if (scoreText != null)
        {
            score = Integer.parseInt(scoreText.toString());
        }
        return score;
    }

    /**
     * @param dateText
     * @return
     * @throws ParseException 
     */
    public static Date convertTextToDate(Editable dateText) throws ParseException
    {
        Date date = null;
        if (dateText != null)
        {
            date = FORMFIELDFORMAT.parse(dateText.toString());
        }
        return date;
    }
    
    /**
     * @param date
     * @return
     */
    public static String convertDateToDBString(Date date)
    {
        String convertedDate = null;
        if (date != null)
        {
            convertedDate = SQLITEFORMAT.format(date);
        }
        return convertedDate;
    }
}
