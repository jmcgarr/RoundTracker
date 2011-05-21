package com.excella.roundtracker;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import com.excella.roundtracker.model.Round;

public class NewScoreActivity extends Activity
{
    private static final int DIALOG_SUCCESSFUL_SAVE = 0;
    private static final int DIALOG_FAILED_SAVE = 1;
    private RoundRepository repo;

    /* (non-Javadoc)
     * @see android.app.Activity#onCreate(android.os.Bundle)
     */
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.newscore);
        initRepository();
        initLayout();
    }
    
    private void initRepository()
    {
        this.repo = new RoundRepository(this);
    }

    @Override
    protected Dialog onCreateDialog(int id)
    {
        Log.i("RoundTracker", "Opening a Dialog on the NewScoreActivity [" + id + "]");
        Dialog dialog;
        switch (id)
        {
            case DIALOG_SUCCESSFUL_SAVE:
                dialog = createSuccessfulSaveDialog();
                break;
            case DIALOG_FAILED_SAVE:
                dialog = null;
                break;
            default:
                dialog = null;
        }
        return dialog;
    }

    private Dialog createSuccessfulSaveDialog()
    {
        Log.i("RoundTracker", "Creating a Successful Save Alert Dialog.");
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Round successfully saved!")
               .setCancelable(false)
               .setPositiveButton("Ok", new DialogInterface.OnClickListener()
                    {
                        @Override
                        public void onClick(DialogInterface dialog, int which)
                        {
                            NewScoreActivity.this.finish();
                        }
                    });
        return builder.create();
    }

    /**
     * Initializes the layout for the Activity.
     */
    private void initLayout()
    {
        Button saveScoreButton = (Button) findViewById(R.id.saveScoreButton);
        saveScoreButton.setOnClickListener(new OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                saveRound(view);
                // TODO need to determine if the save was successful or not
                showDialog(DIALOG_SUCCESSFUL_SAVE);
            }
        });
    }
    
    /**
     * Given a view, will build a Round object and then persist it.
     * TODO remove this code into a Repository pattern or something like that.
     * 
     * @param view the current view.
     */
    private void saveRound(View view)
    {
        Editable dateText = ((EditText) findViewById(R.id.dateField)).getText();
        Editable scoreText = ((EditText) findViewById(R.id.scoreField)).getText();
        
        Round round = Round.buildRound(dateText, scoreText);

        Log.i("RoundTracker", "Saving a Round: " + round.toString());
        long roundId = repo.insert(round);        
        Log.i("RoundTracker", "Round Saved - " + roundId);
    }
}
