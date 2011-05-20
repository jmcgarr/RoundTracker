package com.excella.roundtracker;

import java.util.Date;

import com.excella.roundtracker.model.Round;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class NewScoreActivity extends Activity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.newscore);

        initLayout();
    }

    private void initLayout()
    {
        Button saveScoreButton = (Button) findViewById(R.id.saveScoreButton);
        saveScoreButton.setOnClickListener(new OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                saveRound(view);
            }
        });
    }
    
    private void saveRound(View view)
    {
        Editable dateText = ((EditText) findViewById(R.id.dateField)).getText();
        Editable scoreText = ((EditText) findViewById(R.id.scoreField)).getText();
        
        Round round = Round.buildRound(dateText, scoreText);
        saveRound(round);
    }

    private void saveRound(Round round)
    {
        // Make a call to the Content Provider to persist the Round
    } 
}
