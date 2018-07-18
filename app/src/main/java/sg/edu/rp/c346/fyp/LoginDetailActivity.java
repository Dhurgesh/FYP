package sg.edu.rp.c346.fyp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by 16033265 on 7/18/2018.
 */

public class LoginDetailActivity extends AppCompatActivity {

    Button btnGraph;
    Button btnThreshold;
    Button btnSolenoid;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_detail);

        btnGraph = findViewById(R.id.buttonChart);
        btnSolenoid = findViewById(R.id.buttonSolenoid);
        btnThreshold = findViewById(R.id.buttonThreshold);

        Intent intentReceived = getIntent();

        btnGraph.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentGraph = new Intent(getBaseContext(),Chart.class);
                startActivity(intentGraph);
            }
        });

        btnThreshold.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentThreshold = new Intent(getBaseContext(),Threshold.class);
                startActivity(intentThreshold);
            }
        });

    }
}
