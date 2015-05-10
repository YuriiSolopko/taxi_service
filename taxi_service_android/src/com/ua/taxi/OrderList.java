package com.ua.taxi;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.View;
import android.widget.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutionException;

/**
 * Created by Wolf on 21.04.2015.
 */
public class OrderList extends Activity {
    private ArrayAdapter<String> adapter;
    private String url = "http://192.168.1.134:8083/";
    private List<String> values;
    private String driverId;
    private boolean listClickable = true;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        driverId = intent.getStringExtra("driver_id");
//        System.out.println("DRIVER ID = " + driverId);
        setContentView(R.layout.orderlayout);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, new ArrayList<String>());
        final ListView orderList = (ListView) findViewById(R.id.orderlist);
        final TextView activeOrder = (TextView) findViewById(R.id.activeOrder);
        orderList.setAdapter(adapter);

        orderList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (listClickable) {
                    String item = ((TextView) view).getText().toString();
                    if (!item.equals("Доступных заказов нет")) {
                        try {
                            String result = new ReserveOrder().execute(url + "reserveOrder?driverId=" + driverId +
                                    "&orderId=" + item.substring(0, item.indexOf("|"))).get();
                            if (result!= null && result.equals("true")) {
                                adapter.remove(item);
                                activeOrder.setText(item + "\n(нажмите после выполнения заказа)");
                                listClickable = false;
                            } else {
                                Toast.makeText(getBaseContext(), "Заказ уже забран (" + result + ")" , Toast.LENGTH_LONG).show();
                            }
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        } catch (ExecutionException e) {
                            e.printStackTrace();
                        }
                    }
                } else {
                    Toast.makeText(getBaseContext(), "Ошибка. У вас есть не завершенный заказ" , Toast.LENGTH_LONG).show();
                }
            }
        });

        activeOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String order = activeOrder.getText().toString();
                listClickable = true;
                activeOrder.setText("");
                try {
                    String result = new ExecuteOrder().execute(url + "executeOrder?driverId=" + driverId +
                            "&orderId=" + order.substring(0, order.indexOf("|"))).get();
                } catch (InterruptedException e) {
                    Toast.makeText(getBaseContext(), "InterruptedException" , Toast.LENGTH_LONG).show();
                } catch (ExecutionException e) {
                    Toast.makeText(getBaseContext(), "ExecutionException" , Toast.LENGTH_LONG).show();
                }
            }
        });

        callAsynchronousTask();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    public void callAsynchronousTask() {
        final Handler handler = new Handler();
        Timer timer = new Timer();
        TimerTask doAsynchronousTask = new TimerTask() {
            @Override
            public void run() {
                handler.post(new Runnable() {
                    public void run() {
                        try {
                            List<String> values = new GetOrders().execute(url + "getOrders").get();
                            adapter.clear();
                            if (values == null) {
                                Toast.makeText(getBaseContext(), "Error. Check internet connection" , Toast.LENGTH_LONG).show();
                            } else if (values.size() == 0) {
                                adapter.add("Доступных заказов нет");
                            } else {
                                for (String s : values) {
                                    adapter.add(s);
                                }
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        };
        timer.schedule(doAsynchronousTask, 0, 5000); //execute in every 5000 ms
    }

    private class GetOrders extends AsyncTask<String, Void, List<String>> {

        @Override
        protected List<String> doInBackground(String... urls) {

            try {
                URL url = new URL(urls[0]);
                HttpURLConnection conn = (HttpURLConnection)url.openConnection();
                conn.setConnectTimeout(5000);
                BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                List<String> orders = new ArrayList<String>();
                String str;
                while( (str = br.readLine()) != null){
                    orders.add(str);
                }
                return orders;
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
    }

    private class ReserveOrder extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... urls) {

            URL url = null;
            try {
                url = new URL(urls[0]);
                HttpURLConnection conn = (HttpURLConnection)url.openConnection();
                conn.setConnectTimeout(5000);
                BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                return br.readLine();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
    }

    private class ExecuteOrder extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... urls) {

            URL url = null;
            try {
                url = new URL(urls[0]);
                HttpURLConnection conn = (HttpURLConnection)url.openConnection();
                conn.setConnectTimeout(5000);
                BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                return br.readLine();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
    }

}
