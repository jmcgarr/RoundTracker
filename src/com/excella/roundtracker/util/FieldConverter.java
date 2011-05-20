package com.excella.roundtracker.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import android.text.Editable;

public class FieldConverter
{
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
            SimpleDateFormat format = new SimpleDateFormat("MM/dd/yy");
            date = format.parse(dateText.toString());
        }
        return date;
    }
}
