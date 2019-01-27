package edu.ucsd.cse110.asynctaskapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private boolean isCancelled = false;
    private Button btnCount;
    private Button btnCancel;
    private TextView textResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCount = findViewById(R.id.buttonCount);
        btnCancel = findViewById(R.id.buttonCancel);
        textResult = findViewById(R.id.textResult);

        btnCount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isCancelled = false;

                for (int i = 0; i < 10 && !isCancelled; i++) {
                    textResult.setText(String.valueOf(i));
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if (isCancelled) {
                    textResult.setText("Cancelled");
                } else {
                    textResult.setText("10");
                }
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//              https://developer.android.com/reference/android/os/AsyncTask#cancel(boolean)
                isCancelled = true;
            }
        });
    }
}
