package com.excella.roundtracker.model;

import static com.excella.roundtracker.util.FieldConverter.convertDateToDBString;
import static com.excella.roundtracker.util.FieldConverter.convertTextToDate;
import static com.excella.roundtracker.util.FieldConverter.convertTextToInt;

import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;

import android.text.Editable;
import android.util.Log;

/**
 * TODO Review the need for this class.  OO model objects may not be needed with the way the ContentProviders work.
 * @author jmcgarr
 */
public class Round
{
    public static final String DATE = "date_of_round";
    public static final String SCORE = "score";
    
    private int score;
    private Date date;

    public Round(Date date, int score)
    {
        this.date = date;
        this.score = score;
    }
    
    public int getScore()
    {
        return score;
    }

    public void setScore(int score)
    {
        this.score = score;
    }

    public Date getDate()
    {
        return date;
    }
    
    public String getDateString()
    {
        return convertDateToDBString(date);
    }

    public void setDate(Date date)
    {
        this.date = date;
    }

    /**
     * @param dateText
     * @param scoreText
     * @return
     */
    public static Round buildRound(Editable dateText, Editable scoreText)
    {
        Log.i("RoundTracker", "Building a Round with date [" + dateText.toString() + "] and score [" + scoreText + "]");
        Date date = null;
        int score = -1;
        try
        {
            date = convertTextToDate(dateText);
            score = convertTextToInt(scoreText);
        }
        catch (Exception e)
        {
            // log the exception
            throw new IllegalArgumentException("Unable to parse the field inputs", e);
        }
        return new Round(date, score);
    }
    
    @Override
    public String toString()
    {
        return ToStringBuilder.reflectionToString(this);
    }
}
