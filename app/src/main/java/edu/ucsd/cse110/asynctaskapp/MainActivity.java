package edu.ucsd.cse110.asynctaskapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonGoToCount = (Button) findViewById(R.id.buttonGoToCount);
        buttonGoToCount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchActivity();

            }
        });
    }

    public void launchActivity() {
        Intent goToCount = new Intent(this, CountToTenActivity.class);
        startActivity(goToCount);
    }
}
