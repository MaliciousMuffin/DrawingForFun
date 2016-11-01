package com.example.sammyo.drawingforfun;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    CustomView view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        view = (CustomView) findViewById(R.id.canvas);
    }
    protected void cameraCapture(View v) {
        Intent intent = new Intent(this,StartCamera.class);

        startActivity(intent);

    }
}
