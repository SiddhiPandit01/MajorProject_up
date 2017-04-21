package trainedge.majorproject;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class LogoutActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logout);
        btnLogout = (Button) findViewById(R.id.btnLogout);
        btnLogout.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

    }
}
