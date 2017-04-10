package trainedge.majorproject;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

public class FirebaseDatabaseDemo extends AppCompatActivity implements View.OnClickListener {



    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:

                    return true;
                case R.id.navigation_dashboard:

                    return true;
                case R.id.navigation_notifications:

                    return true;
            }
            return false;
        }

    };
    private EditText etName;
    private EditText etComment;
    private Button btnSend;
    private FirebaseDatabase db;
    private DatabaseReference commentRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firebase_database_demo);


        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        //our code
        etName = (EditText) findViewById(R.id.etName);
        etComment = (EditText) findViewById(R.id.etComment);
        btnSend = (Button) findViewById(R.id.btnSend);

        db = FirebaseDatabase.getInstance();
        commentRef = db.getReference("comments");
        btnSend.setOnClickListener(this);
        commentRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                if (snapshot.hasChildren()) {
                    DataSnapshot userinfo = snapshot.child("user info");
                    String name = userinfo.child("name").getValue(String.class);
                    String comment = userinfo.child("comment").getValue(String.class);



                    DataSnapshot messages = snapshot.child("messages");
                }

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }


    @Override
    public void onClick(View v) {
        String name = etName.getText().toString();
        String comment = etComment.getText().toString();

        if (name.isEmpty()) {
            etName.setError("Fill Your name");
            return;
        }
        if (comment.isEmpty()) {
            etComment.setError("Add Comment here");
            return;
        }

        //firebase upload
        HashMap<String, String> map = new HashMap<>();
        map.put("msg", comment);
        map.put("user", name);

        commentRef.push().setValue(map);
        //you may add on onCompletionListener Too
        //update ui

        etName.setText("");
        etComment.setText("");
    }
}
