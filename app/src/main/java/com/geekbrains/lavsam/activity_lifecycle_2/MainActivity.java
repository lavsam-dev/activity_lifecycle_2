package com.geekbrains.lavsam.activity_lifecycle_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity /*implements View.OnClickListener*/ {

//    class ClickListenerHandler implements View.OnClickListener {
//
//        @Override
//        public void onClick(View v) {
//
//        }
//    }

//    private View.OnClickListener clickListener = new View.OnClickListener() {
//
//        @Override
//        public void onClick(View v) {
//
//            if (v.getId() == R.id.hello_world) {
//
//            }
//        }
//    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.hello_world).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("ARG_COUNT", 4);
                startActivity(intent);
            }
        });

        if (savedInstanceState == null) {
            logCycle("Create first time");
        } else {
            logCycle("Recreate");
        }
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
        Log.d("ActivityLog", "MainActivity_" + event);
    }
}