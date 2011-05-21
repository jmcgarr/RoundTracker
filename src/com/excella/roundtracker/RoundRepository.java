package com.excella.roundtracker;

import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.excella.roundtracker.model.Round;

public class RoundRepository
{
    private static final String DATABASE_NAME = "roundDB";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "rounds";
    private static final String ID_COLUMN_NAME = "_id";
    private static final String DATE_COLUMN_NAME = "date_of_round";
    private static final String SCORE_COLUMNE_NAME = "score";
    
    private Context context;
    private SQLiteDatabase db;

    public RoundRepository(Context ctx)
    {
        this.context = ctx;
        DataHelper dbHelper = new DataHelper(this.context);
        this.db = dbHelper.getWritableDatabase();
    }
    
    public long insert(Round round)
    {
        ContentValues values = new ContentValues();
        values.put(DATE_COLUMN_NAME, round.getDateString());
        values.put(SCORE_COLUMNE_NAME, round.getScore());
        return db.insert(TABLE_NAME, null, values);
    }
    
    public Round select(long id)
    {
        return null;
    }
    
    public List<Round> selectAll ()
    {
        return null;
    }
    
    private class DataHelper extends SQLiteOpenHelper
    {

        public DataHelper(Context context)
        {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db)
        {
            db.execSQL("CREATE TABLE " + TABLE_NAME + " (" +
                    ID_COLUMN_NAME + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    DATE_COLUMN_NAME + " DATE default CURRENT_DATE, " +
                    SCORE_COLUMNE_NAME + " INTEGER);");
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
        {
            Log.w("RoundTracker", "Upgrading database, this will drop tables and recreate.");
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
            onCreate(db);
        }
    }
}
