package com.excella.roundtracker.model;

import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;

import android.text.Editable;
import android.util.Log;
import static com.excella.roundtracker.util.FieldConverter.*;

/**
 * @author jmcgarr
 *
 */
public class Round
{
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
