package sg.edu.rp.c346.fyp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;



public class MainActivity extends AppCompatActivity {

    EditText etUserId;
    EditText etPassword;
    Button btnLogin;
    TextView tvUser;
    TextView tvPassword;

    private String userIDFK = "";
    private String passwordFK = "";

    DatabaseReference ref = FirebaseDatabase.getInstance().getReference();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etUserId = findViewById(R.id.editTextUserId);
        etPassword = findViewById(R.id.editTextPassword);
        btnLogin = findViewById(R.id.buttonLogin);
        tvUser = findViewById(R.id.textViewUser);
        tvPassword = findViewById(R.id.textViewPassword);

        DatabaseReference takePasslaCB = ref.child("fypfirebaseproject-c6074").child("Users").child("password");
        DatabaseReference takeUserlaCB = ref.child("fypfirebaseproject-c6074").child("Users").child("userID");




        takePasslaCB.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String password = dataSnapshot.getValue(String.class);
                passwordFK += password;

                //do what you want with the email
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        takeUserlaCB.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String usecb = dataSnapshot.getValue(String.class);
                userIDFK += usecb;
                //do what you want with the email
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        // Read from the database




        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (etUserId.getText().toString().equalsIgnoreCase(userIDFK) && etPassword.getText().toString().equalsIgnoreCase(passwordFK)) {
                    Toast.makeText(getApplicationContext(),
                            "Redirecting...", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getBaseContext(), LoginDetailActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(getApplicationContext(), userIDFK + passwordFK, Toast.LENGTH_SHORT).show();
                    tvUser.setText(userIDFK);
                    tvPassword.setText(passwordFK);

                }
            }
        });




    }
}