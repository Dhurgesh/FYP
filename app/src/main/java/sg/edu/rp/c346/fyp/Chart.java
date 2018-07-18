package sg.edu.rp.c346.fyp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by 16033265 on 7/18/2018.
 */

public class Chart extends AppCompatActivity {



    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chart);

        Intent intentReceivedGraph = getIntent();

    }
}
