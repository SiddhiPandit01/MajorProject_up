package trainedge.majorproject;

import android.content.Intent;
import android.media.Rating;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;


public class Feedback extends AppCompatActivity implements View.OnClickListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        EditText edtName = (EditText) findViewById(R.id.edtName);
        EditText edtFeed = (EditText) findViewById(R.id.edtFeed);
        RatingBar rb = (RatingBar) findViewById(R.id.rb);
        Button btn1 = (Button) findViewById(R.id.btn1);
        btn1.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

    }
}

