package com.winsontan520.datagovsg.samples.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.winsontan520.datagovsg.samples.R;

public class MainActivity extends BaseActivity {

    public static final String TAG = "MainActivity";

    private Class[] clazzes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Defined Array values to show in ListView
        String[][] values = new String[][]{
                {"Traffic Images", "@GET(/transport/traffic-images)"},
                {"Car park availability", "@GET(/transport/carpark-availability)"},
                {"Taxi availability", "@GET(/transport/taxi-availability)"},
        };

        clazzes = new Class[]{
                TrafficImagesActivity.class,
                CarParkAvailabilityActivity.class,
                TaxiAvailabilityActivity.class,
        };

        ListView lv = (ListView) findViewById(android.R.id.list);
        lv.setAdapter(new ArrayAdapter<String[]>(this, android.R.layout.simple_list_item_2, android.R.id.text1, values) {
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                View view = super.getView(position, convertView, parent);
                TextView text1 = (TextView) view.findViewById(android.R.id.text1);
                TextView text2 = (TextView) view.findViewById(android.R.id.text2);

                text1.setText(getItem(position)[0]);
                text2.setText(getItem(position)[1]);
                text2.setPadding(0, 0, 0, 20);
                text2.setTextColor(Color.GRAY);
                return view;
            }
        });
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                launchActivity(clazzes[position]);
            }
        });

    }

    private void launchActivity(Class clazz) {
        startActivity(new Intent(this, clazz));
    }
}
