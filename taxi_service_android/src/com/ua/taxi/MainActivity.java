package com.ua.taxi;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.ExecutionException;

/**
 * Created by Jura on 24.04.2015.
 */
public class MainActivity extends Activity {

    private static final String SUBMIT_URL = "http://192.168.1.134:8083/authDriver";
    private MainActivity instance = this;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.taxi_main);
        final EditText driverName = (EditText) findViewById(R.id.driver_name);
        final EditText driverSurname = (EditText) findViewById(R.id.driver_surname);
        final EditText driverPatronymic = (EditText) findViewById(R.id.driver_patronymic);
        final EditText driverId = (EditText) findViewById(R.id.driver_id);
        final Button submit = (Button) findViewById(R.id.submit_driver);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SubmitDriver task = new SubmitDriver();
                task.execute(SUBMIT_URL + "?firstName=" + driverName.getText() + "&lastName=" + driverSurname.getText() +
                        "&patronymic=" + driverPatronymic.getText() + "&id=" + driverId.getText());
                try {
                    String result = task.get();
                    if (result != null && result.equals("true")) {
                        Intent intent = new Intent(instance, OrderList.class);
                        intent.putExtra("driver_id", driverId.getText().toString());
                        startActivity(intent);
                    } else {
                        Toast.makeText(instance, "Authorization failed" , Toast.LENGTH_LONG).show();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    private class SubmitDriver extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... urls) {

            try {
                URL url = new URL(urls[0]);
                HttpURLConnection conn = (HttpURLConnection)url.openConnection();
                BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                String str = br.readLine();
                return str;
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
    }
}
