package com.excella.roundtracker;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class HomeActivity extends Activity
{
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        addNewScoreButton();
    }

    /**
     * 
     */
    private void addNewScoreButton()
    {
        Button newButton = (Button) findViewById(R.id.newScoreButton);
        newButton.setOnClickListener(new OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                openAddScoreActivity();
            }
        });
    }
    
    /**
     * 
     */
    private void openAddScoreActivity ()
    {
        Intent newScoreIntent = new Intent(this, NewScoreActivity.class);
        startActivity(newScoreIntent);
    }
}