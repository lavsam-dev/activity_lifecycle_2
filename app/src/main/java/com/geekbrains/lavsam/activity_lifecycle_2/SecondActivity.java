package com.geekbrains.lavsam.activity_lifecycle_2;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    private static final String ARG_COUNT = "ARG_COUNT";
    private TextView clickCount;
    //    private int clicks = 0;
//    private CounterSer counterSer;
    private Counter counter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        int value = getIntent().getIntExtra("ARG_COUNT", 0);

        if (savedInstanceState == null) {
            logCycle("create first time" + " ARG_COUNT = " + value);
//            counterSer = new CounterSer(0);
            counter = new Counter(0);
        } else {
            logCycle("recreate" + " ARG_COUNT = " + value);

//            counterSer = (CounterSer) savedInstanceState.getSerializable(ARG_COUNT);
            counter = (Counter) savedInstanceState.getParcelable(ARG_COUNT);
        }

        clickCount = findViewById(R.id.count_msg);

        updateCount();

        findViewById(R.id.btn_click).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                counterSer.increase();
                counter.increase();
                updateCount();
            }
        });

    }

//    @Override
//    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
//
//        clicks = savedInstanceState.getInt(ARG_COUNT, 0);
//        super.onRestoreInstanceState(savedInstanceState);
//    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
//        outState.putSerializable(ARG_COUNT, counterSer);
        outState.putParcelable(ARG_COUNT, counter);
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onStart() {
        super.onStart();
        logCycle("started");
    }

    @Override
    protected void onResume() {
        super.onResume();
        logCycle("resumed");
    }

    @Override
    protected void onPause() {
        super.onPause();
        logCycle("paused");
    }

    @Override
    protected void onStop() {
        super.onStop();
        logCycle("stopped");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        logCycle("destroyed");
    }

    private void logCycle(String event) {
        Log.d("ActivityLog", "SecondActivity_" + event);
    }

    private void updateCount() {
//        clickCount.setText(getString(R.string.click_count, counterSer.getValue()));
        clickCount.setText(getString(R.string.click_count, counter.getValue()));
    }

}