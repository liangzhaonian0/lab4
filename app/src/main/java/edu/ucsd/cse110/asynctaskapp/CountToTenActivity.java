package edu.ucsd.cse110.asynctaskapp;

import android.os.AsyncTask;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CountToTenActivity extends AppCompatActivity {
    private boolean isCancelled = false;
    private Button btnCount;
    private Button btnCancel;
    private TextView textResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_count_to_ten);

        btnCount = findViewById(R.id.buttonCount);
        btnCancel = findViewById(R.id.buttonCancel);
        textResult = findViewById(R.id.textResult);

        final CountToTenAsyncTask counter = new CountToTenAsyncTask();
        btnCount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                counter.execute();
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter.cancel(true);
            }
        });



        Button buttonGoBack = (Button) findViewById(R.id.goBackButton);
        buttonGoBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();

            }
        });
    }




    private class CountToTenAsyncTask extends AsyncTask<String, String, String> {

        private String timeLeft;

        @Override
        protected String doInBackground(String... params) {
            for (int i = 0; i < 11 ; i++) {
                timeLeft = Integer.toString(i);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    timeLeft = e.getMessage();
                }
                publishProgress(timeLeft);
            }
            return "0";
        }

        @Override
        protected void onPostExecute(String result) {
            //textResult.setText("10");
        }

        @Override
        protected void onPreExecute() {

        }

        @Override
        protected void onProgressUpdate(String... text) {
            textResult.setText(text[0]);
        }
    }
}
