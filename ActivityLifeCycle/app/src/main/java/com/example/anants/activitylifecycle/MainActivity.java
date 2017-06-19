package com.example.anants.activitylifecycle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView msg;
    LinearLayout bg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        msg.setText("Android Oncreate Activity");
        bg.setBackgroundColor(getResources().getColor(R.color.red));
        Log.d("Android","onCreate () called");

    }

    private void init() {
        msg=(TextView) findViewById(R.id.message);
        bg=(LinearLayout) findViewById(R.id.bg);
    }

    @Override
    protected void onStart() {
        super.onStart();
        msg.setText("Android onStart () called");
        bg.setBackgroundColor(getResources().getColor(R.color.green));
        Log.d("Android","onStart () called");

    }

    @Override
    protected void onResume() {
        super.onResume();
        msg.setText("Android onResume () called");
        bg.setBackgroundColor(getResources().getColor(R.color.green));
        Log.d("Android","onResume () called");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        msg.setText("Android onRestart () called");
        bg.setBackgroundColor(getResources().getColor(R.color.green));
        Log.d("Android","onRestart () called");
    }

    @Override
    protected void onPause() {
        super.onPause();
        msg.setText("Android onPause () called");
        bg.setBackgroundColor(getResources().getColor(R.color.green));
        Log.d("Android","onPause () called");
    }

    @Override
    protected void onStop() {
        super.onStop();
        msg.setText("Android onStop () called");
        bg.setBackgroundColor(getResources().getColor(R.color.green));
        Log.d("Android","onStop () called");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        msg.setText("Android onDestroy () called");
        bg.setBackgroundColor(getResources().getColor(R.color.green));
        Log.d("Android","onDestroy () called");
    }
}
